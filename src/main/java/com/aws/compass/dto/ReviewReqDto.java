package com.aws.compass.dto;

import com.aws.compass.entity.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReviewReqDto {
    @JsonProperty("ACADEMY_ID")
    private int ACADEMY_ID;
    private int userId;
    private float score;
    private String reviewContent;

    public Review toReview(){
        return Review.builder()
                .ACADEMY_ID(ACADEMY_ID)
                .userId(userId)
                .score(score)
                .reviewContent(reviewContent)
                .build();
    }
}
