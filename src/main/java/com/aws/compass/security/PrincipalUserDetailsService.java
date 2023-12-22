package com.aws.compass.security;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PrincipalUserDetailsService implements OAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();    // 사용자 정보 로드하기 위한 서비스 생성
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);    // 사용자 정보 로드

        Map<String, Object> attributes = oAuth2User.getAttributes();    // 사용자 정보에서 속성 얻어옴.

        String provider = userRequest.getClientRegistration().getClientName();  // Naver, Kakao 등 provider 이름
        Map<String, Object> response = null;
        switch (provider) {
            case "Naver":
                response = (Map<String, Object>) attributes.get("response");    // 속성에서 response 부분 꺼냄(id, email, name 등의 실질적 사용자 데이터)
                break;
            case "Kakao":
                response = (Map<String, Object>) attributes.get("properties");
                response.put("id", attributes.get("id"));
                break;
        }
        response.put("provider", provider); // provider 속성을 추가해줌.
        return new DefaultOAuth2User(new ArrayList<>(), response, "id");
    }
}
