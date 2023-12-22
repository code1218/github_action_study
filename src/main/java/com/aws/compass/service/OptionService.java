package com.aws.compass.service;

import com.aws.compass.dto.*;
import com.aws.compass.entity.AdministrativeDistrict;
import com.aws.compass.repository.OptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionMapper optionMapper;

    public List<EducationOfficeRespDto> getEducationOfficeList() {
        List<EducationOfficeRespDto> educationOfficeRespDtos = new ArrayList<>();
        optionMapper.getEducationOfficeList().forEach(educationOffice -> educationOfficeRespDtos.add(educationOffice.toEducationOfficeDto()));
        return educationOfficeRespDtos;
    }

    public  List<AdministrativeDistrictRespDto> getAdministrativeDistrictList() {
        List<AdministrativeDistrictRespDto> administrativeDistrictRespDtos = new ArrayList<>();
        optionMapper.getAdministrativeDistrictList().forEach(administrativeDistrict -> administrativeDistrictRespDtos.add(administrativeDistrict.toAdministrativeDistrictDto()));
        return administrativeDistrictRespDtos;
    }

    public List<CategoryRespDto> getCategoryList() {
        List<CategoryRespDto> categoryRespDtos = new ArrayList<>();
        optionMapper.getCategoryList().forEach(category -> categoryRespDtos.add(category.toCategoryDto()));
        return categoryRespDtos;
    }

    public List<CategoryDetailRespDto> getCategoryDetailList() {
        List<CategoryDetailRespDto> categoryDetailRespDtos = new ArrayList<>();
        optionMapper.getCategoryDetailList().forEach(categoryDetail -> categoryDetailRespDtos.add(categoryDetail.toCategoryDetailDto()));
        return categoryDetailRespDtos;
    }

    public List<ConvenienceRespDto> getConvenienceList() {
        List<ConvenienceRespDto> convenienceRespDtos = new ArrayList<>();
        optionMapper.getConvenienceList().forEach(convenience -> convenienceRespDtos.add(convenience.toConvenienceDto()));
        return convenienceRespDtos;
    }

    public List<AgeRespDto> getAgeList() {
        List<AgeRespDto> ageRespDtos = new ArrayList<>();
        optionMapper.getAgeList().forEach(age -> ageRespDtos.add(age.toAgeDto()));
        return ageRespDtos;
    }
}
