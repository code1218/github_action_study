package com.aws.compass.dto;

import com.aws.compass.entity.AcademyRegistration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class AwaitingAcademiesRespDto {
    private List<AcademyRegistration> academyRegistrations;
    private int listTotalCount;
}
