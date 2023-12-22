package com.aws.compass.service;

import com.aws.compass.dto.SignupReqDto;
import com.aws.compass.entity.User;
import com.aws.compass.exception.DuplicateException;
import com.aws.compass.repository.AuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper authMapper;

    public boolean signup(SignupReqDto signupReqDto) {
        User user = signupReqDto.toUser();
        int errorCode = authMapper.checkDuplicate(user);
        if(errorCode > 0) {
            responseDuplicateError(errorCode);
        }
        return authMapper.saveUser(user) > 0;
    }

    public void responseDuplicateError(int errorCode) {
        Map<String, String> errorMap = new HashMap<>();
        switch (errorCode) {
            case 1:
                errorMap.put("email", "이미 사용중인 이메일입니다.");
                break;
            case 2:
                errorMap.put("nickname", "이미 사용중인 닉네임입니다.");
                break;
            case 3:
                errorMap.put("email", "이미 사용중인 이메일입니다.");
                errorMap.put("nickname", "이미 사용중인 닉네임입니다.");
                break;
        }
        throw new DuplicateException(errorMap);
    }
}
