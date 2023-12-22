package com.aws.compass.entity;

import com.aws.compass.dto.ConvenienceRespDto;
import com.aws.compass.dto.ReviewRespDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    private int reviewId;
    @JsonProperty("ACADEMY_ID")
    private int ACADEMY_ID;
    private int userId;
    private float score;
    private String reviewContent;
    private String nickname;
    private String academyName;
}
