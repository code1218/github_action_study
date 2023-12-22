package com.aws.compass.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AcademyLikeRespDto {
    private int likeId;
    private int userId;
    private int ACADEMYID;
}
