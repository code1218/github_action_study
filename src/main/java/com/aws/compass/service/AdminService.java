package com.aws.compass.service;

import com.aws.compass.dto.ApprovalAcademyReqDto;
import com.aws.compass.dto.AwaitingAcademiesRespDto;
import com.aws.compass.dto.DisapprovalReqDto;
import com.aws.compass.entity.AcademyRegistration;
import com.aws.compass.repository.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminMapper adminMapper;

    public AwaitingAcademiesRespDto getAwaitingAcademies(int page) {
        int index = (page - 1) * 5;

        List<AcademyRegistration> academyRegistrations = adminMapper.getAcademyRegistrations(index);
        int listTotalCount = adminMapper.getAwaitingAcademyCount();

        return new AwaitingAcademiesRespDto(academyRegistrations, listTotalCount);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean approvalAcademy(ApprovalAcademyReqDto approvalAcademyReqDto) {
        return adminMapper.updateApprovalState(approvalAcademyReqDto.getAcademyRegistrationId()) > 0
                && adminMapper.updateUserRole(approvalAcademyReqDto.getUserId()) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean disapprovalAcademy(DisapprovalReqDto disapprovalReqDto) {
        return adminMapper.updateApprovalStatus(disapprovalReqDto.getAcademyRegistrationId(), disapprovalReqDto.getRejectReason()) > 0;
    }
}
