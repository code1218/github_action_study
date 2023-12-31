package com.aws.compass.jwt;

import com.aws.compass.entity.User;
import com.aws.compass.repository.AuthMapper;
import com.aws.compass.security.PrincipalUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    private final Key key;
        private final AuthMapper authMapper;

        public JwtProvider(@Value("${jwt.secret}") String secret,
                           @Autowired AuthMapper authMapper) {
            key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
            this.authMapper = authMapper;
        }

        public String generateToken(Authentication authentication) {
            PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
            String oauth2Id = authentication.getName();

            Date date = new Date(new Date().getTime() + (1000 * 60 * 60 * 24));

            return Jwts.builder()
                    .setSubject("AccessToken")
                    .setExpiration(date)
                    .claim("oauth2Id", oauth2Id)
                    .claim("email", principalUser.getUser().getEmail())
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        }

        public Claims getClaims(String token) {
            Claims claims = null;
            try {
                claims = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token)
                        .getBody();
            } catch (Exception e) {
                System.out.println(e.getClass() + ": " + e.getMessage());
            }
            return claims;
        }

        public String getToken(String bearerToken) {    // Bearer 잘라 주는 함수
            if(!StringUtils.hasText(bearerToken)) {
                return null;
            }
            return bearerToken.substring("Bearer ".length());
        }

        // 토큰이 유효한지 확인해 Authentication 객체를 반환하는 함수
        public Authentication getAuthentication(String token) {
            Claims claims = getClaims(token);
            if(claims == null) {    // 토큰이 유효하지 않은 경우
                return null;
            }

            // 클레임 정보에서 이메일 값을 추출하여 해당 이메일을 가진 사용자를 데이터베이스에서 찾음
            // oauth2 로그인만 있으므로 oauth2id로 확인
            User user = authMapper.findUserByOauth2Id(claims.get("oauth2Id").toString());
            if(user == null) {  // 토큰은 유효하지만 db에서 user를 지워버렸을 경우
                return null;
            }

            PrincipalUser principalUser = new PrincipalUser(user);

            // Spring Security의 UsernamePasswordAuthenticationToken을 사용하여
            // 사용자 정보와 권한 정보를 포함한 Authentication 객체를 생성하고 반환
            return new UsernamePasswordAuthenticationToken(principalUser, null, principalUser.getAuthorities());
        }

        public String generateAuthMailToken(String email) {
            Date date = new Date(new Date().getTime() + 1000 * 60 * 5); // 메일 인증 토큰 유효기간 : 5분

            return Jwts.builder()
                    .setSubject("AuthenticationEmailToken")
                    .setExpiration(date)
                    .claim("email", email)
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
        }
}
