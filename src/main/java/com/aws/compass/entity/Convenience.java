package com.aws.compass.entity;

import com.aws.compass.dto.ConvenienceRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Convenience {
    private int convenienceId;
    private String  convenienceName;

    public ConvenienceRespDto toConvenienceDto () {
        return ConvenienceRespDto.builder()
                .convenienceId(convenienceId)
                .convenienceName(convenienceName)
                .build();
    }
}
