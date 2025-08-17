package com.diptech.portfolio.controllers;

import com.diptech.portfolio.entities.ContactMe;
import com.diptech.portfolio.entities.MyInfo;
import com.diptech.portfolio.services.MyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyInfoController {

    @Autowired
    private MyInfoService myInfoService;

    @GetMapping("/getInfo")
    public ResponseEntity<MyInfo> getFullInfo() {
        MyInfo info = myInfoService.getFullInfo();
        if (info != null) {
            return ResponseEntity.ok(info);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
