package com.aws.compass.dto;

import com.aws.compass.entity.Review;
import com.aws.compass.entity.ReviewCount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ReviewListRespDto {
    List<Review> reviewList;
    ReviewCount reviewCount;
}
