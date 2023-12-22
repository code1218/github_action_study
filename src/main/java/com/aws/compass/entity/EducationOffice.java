package com.aws.compass.entity;

import com.aws.compass.dto.EducationOfficeRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EducationOffice {
    private int educationOfficeId;
    private String educationOfficeName;
    private String educationOfficeCode;

    public EducationOfficeRespDto toEducationOfficeDto() {
        return EducationOfficeRespDto.builder()
                .educationOfficeId(educationOfficeId)
                .educationOfficeName(educationOfficeName)
                .educationOfficeCode(educationOfficeCode)
                .build();
    }
}
