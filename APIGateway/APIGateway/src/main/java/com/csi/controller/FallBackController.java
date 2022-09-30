package com.csi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FallBackController {

    @GetMapping("/employeefallback")
    public String employeeFallBack(){
        return "Employee Service is down please wait!!!!!!!";
    }
    @GetMapping("/departmentfallback")
    public String departmentFallBack(){
        return "Department Service is down please wait!!!!!!!";
    }



}
