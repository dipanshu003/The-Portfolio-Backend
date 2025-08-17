package com.diptech.portfolio.controllers;

import com.diptech.portfolio.entities.ContactMe;
import com.diptech.portfolio.services.ContactMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactMeController {

    @Autowired
    private ContactMeService contactMeService;

    @PostMapping("/saveContactDetails")
    public ResponseEntity<Boolean> saveContactInfo(@RequestBody ContactMe contactMeData) {
        Boolean saved = contactMeService.saveContactMe(contactMeData);
        return ResponseEntity.ok(saved);
    }
}
