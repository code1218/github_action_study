package com.aws.compass.repository;

import com.aws.compass.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    public User findUserByOauth2Id(String oauth2Id);
    public int checkDuplicate(User user);
    public int saveUser(User user);
}
