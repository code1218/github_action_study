package com.aws.compass.dto;

import lombok.Data;

@Data
public class DisapprovalReqDto {
    private int academyRegistrationId;
    private String rejectReason;
}
