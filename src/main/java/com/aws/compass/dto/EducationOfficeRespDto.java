package com.aws.compass.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EducationOfficeRespDto { // 정보등록 응답 데이터 DTO
    private int educationOfficeId;
    private String educationOfficeName;
    private String educationOfficeCode;
}
