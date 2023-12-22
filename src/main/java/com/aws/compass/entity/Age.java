package com.aws.compass.entity;

import com.aws.compass.dto.AgeRespDto;
import com.aws.compass.dto.ConvenienceRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Age {
    private int ageId;
    private String ageRange;

    public AgeRespDto toAgeDto () {
        return AgeRespDto.builder()
                .ageId(ageId)
                .ageRange(ageRange)
                .build();
    }
}
