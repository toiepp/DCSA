package me.mikholsky.practice5.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping(produces = "application/json")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("{\"status\": 200,\n \"message\": \"Yup, I 'm fine!\"}");
    }
}
