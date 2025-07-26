package com.shikhar.JournalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/report")
    public String healthCheck(){
        return "Ok report";
    }
}
