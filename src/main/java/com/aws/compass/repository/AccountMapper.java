package com.aws.compass.repository;

import com.aws.compass.entity.Academy;
import com.aws.compass.entity.Review;
import com.aws.compass.entity.ReviewCount;
import com.aws.compass.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    public int updateUser(User user);
    public User findUserByEmail(String email);
    public int updateEnabledToEmail(String email);
    public int checkDuplicateAndIdNot(User user);
    public int deleteUser(int userId);

    public int getLikeState(int userId, int academyId);
    public int insertLike(int userId, int academyId);
    public int deleteLike(int userId, int academyId);

    public int getLikeCountByUserId(int userId);
    public List<Academy> getLikeAcademies(int userId, int index);

    public int getLikeCountByAcademyId(int academyId);

    public List<Review> getUserReviews(int userId, int index);
    public ReviewCount getUserReviewCount(int userId);
}
