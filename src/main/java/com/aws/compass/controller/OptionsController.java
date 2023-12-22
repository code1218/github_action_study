package com.aws.compass.controller;

import com.aws.compass.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/option")
public class OptionsController {

    private final OptionService optionService;

    // 교육청 전체 불러오기
    @GetMapping("/education-offices")
    public ResponseEntity<?> getEducationOffices() {
        return ResponseEntity.ok(optionService.getEducationOfficeList());
    }

    // 행정구역 전체 불러오기
    @GetMapping("/administrative-districts")
    public ResponseEntity<?> getAdministrativeDistrict() {
        return  ResponseEntity.ok(optionService.getAdministrativeDistrictList());
    }

    // 분야명 전체 불러오기
    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        return  ResponseEntity.ok(optionService.getCategoryList());
    }

    // 교습 과정 목록명 전체 불러오기
    @GetMapping("/category-details")
    public ResponseEntity<?> getCategoryDetails() {
        return  ResponseEntity.ok(optionService.getCategoryDetailList());
    }

    // 시설 및 편의사항 전체 불러오기
    @GetMapping("/conveniences")
    public ResponseEntity<?> getConvenienceOptions() {
        return ResponseEntity.ok(optionService.getConvenienceList());
    }

    // 수강 연령 전체 불러오기
    @GetMapping("/ages")
    public ResponseEntity<?> getAgeOptions() {
        return ResponseEntity.ok(optionService.getAgeList());
    }

}
