package com.aws.compass.controller;

import com.aws.compass.dto.PurchaseReqDto;
import com.aws.compass.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    // 광고 목록 가져오기
    @GetMapping("/api/ad/products")
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.ok(paymentService.getProducts());
    }

    // 광고 결제된 학원
    @PostMapping("/api/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseReqDto purchaseReqDto) {
        return ResponseEntity.ok(paymentService.purchase(purchaseReqDto));
    }

    // 광고 정보 유효성 검사
    @GetMapping("/api/purchase/check")
    public ResponseEntity<?> getPurchaseInfo(@RequestParam int userId, @RequestParam int academyId) {
        return ResponseEntity.ok(paymentService.isPurchase(userId, academyId));
    }
}
