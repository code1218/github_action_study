package com.aws.compass.entity;

import com.aws.compass.dto.AcademyLikeRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LikeAcademy {

    private int likeId;
    private int userId;
    private int ACADEMYID;

    public AcademyLikeRespDto academyLikeRespDto() {

        return AcademyLikeRespDto.builder()
                .likeId(likeId)
                .userId(userId)
                .ACADEMYID(ACADEMYID)
                .build();
    }
}
