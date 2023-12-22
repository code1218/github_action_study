package com.aws.compass.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConvenienceRespDto { // 정보등록 응답 데이터 DTO
    private int convenienceId;
    private String  convenienceName;
}
