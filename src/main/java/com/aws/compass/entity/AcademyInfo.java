package com.aws.compass.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcademyInfo {
    private int academyInfoId;
    @JsonProperty("ACADEMY_ID")
    private int ACADEMY_ID;
    private int userId;
    private String logoImg;
    private String classSize;
    private String coursePeriod;
    private String purpose;
    private String homePage;
    private String phone;
}
