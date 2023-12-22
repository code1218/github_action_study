package com.aws.compass.dto;

import com.aws.compass.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class AcademyInfoRespDto {
    private Academy academy;
    private AcademyInfo academyInfo;
    private List<Convenience> convenience;
    private List<Age> age;
    private List<ClassInfo> classInfo;
}
