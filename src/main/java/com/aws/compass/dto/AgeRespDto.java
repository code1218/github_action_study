package com.aws.compass.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AgeRespDto { // 정보등록 응답 데이터 DTO
    private int ageId;
    private String ageRange;
}
