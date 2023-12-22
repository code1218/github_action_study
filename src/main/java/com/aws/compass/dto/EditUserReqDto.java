package com.aws.compass.dto;

import com.aws.compass.entity.User;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EditUserReqDto {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String nickname;
    @NotBlank
    private String phone;

    public User toUser() {
        return User.builder()
                .email(email)
                .name(name)
                .nickname(nickname)
                .phone(phone)
                .build();
    }
}
