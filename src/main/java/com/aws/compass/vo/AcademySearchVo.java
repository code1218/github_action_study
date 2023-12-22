package com.aws.compass.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcademySearchVo {
    private int academyId;
    private String atptOfcdcScCode;
    private String admstZoneNm;
    private String acaAsnum;
    private String acaNm;
    private String realmScNm;
    private String leOrdNm;
    private String leCrseNm;
    private List<Integer> ageIds;
    private int countAgeId;
    private List<Integer> convenienceIds;
    private int countConvenienceId;
    private String classify;
    private int index;
    private int pSize;
}
