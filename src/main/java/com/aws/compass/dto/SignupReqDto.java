package com.aws.compass.dto;

import com.aws.compass.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class SignupReqDto {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String oauth2Id;
    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @NotBlank
    private String phone;
    @NotBlank
    private String provider;

    public User toUser() {
        return User.builder()
                .email(email)
                .oauth2Id(oauth2Id)
                .name(name)
                .nickname(nickname)
                .phone(phone)
                .provider(provider)
                .build();
    }
}
