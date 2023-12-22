package com.aws.compass.repository;

import com.aws.compass.entity.Academy;
import com.aws.compass.entity.AcademyRegistration;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    public List<AcademyRegistration> getAcademyRegistrations(int page);
    public int getAwaitingAcademyCount();
    public int updateApprovalState(int academyRegistrationId);
    public int updateUserRole(int userId);
    public int updateApprovalStatus(int academyRegistrationId, String rejectReason);
}
