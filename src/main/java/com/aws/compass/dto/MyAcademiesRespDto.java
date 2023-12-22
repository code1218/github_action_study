package com.aws.compass.dto;

import com.aws.compass.entity.AcademyRegistration;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MyAcademiesRespDto {
    private List<AcademyRegistration> academyRegistrations;
    private int listTotalCount;
}
