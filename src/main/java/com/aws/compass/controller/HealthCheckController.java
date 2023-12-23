package com.aws.compass.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Value("${serverName}")
    private String serverName;
    @Value("${server.env}")
    private String env;
    @Value("${server.address}")
    private String serverAddress;
    @Value("${server.port}")
    private String port;

    private Integer visitedCount = 0;

    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        visitedCount++;

        Map<String, Object> healthCheckData = new HashMap<>();
        healthCheckData.put("serverName", serverName);
        healthCheckData.put("env", env);
        healthCheckData.put("address", serverAddress);
        healthCheckData.put("port", port);
        healthCheckData.put("visitedCount", visitedCount);
        return ResponseEntity.ok(healthCheckData);
    }

    @GetMapping("/env")
    public ResponseEntity<String> getEnv() {
        return ResponseEntity.ok(env);
    }
}
