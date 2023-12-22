package com.aws.compass.repository;


import com.aws.compass.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {
    public List<EducationOffice> getEducationOfficeList();
    public List<AdministrativeDistrict> getAdministrativeDistrictList();
    public List<Category> getCategoryList();
    public List<CategoryDetail> getCategoryDetailList();
    public List<Convenience> getConvenienceList();
    public List<Age> getAgeList();
}
