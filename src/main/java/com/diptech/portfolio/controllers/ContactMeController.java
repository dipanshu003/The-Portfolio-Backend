package com.diptech.portfolio.controllers;

import com.diptech.portfolio.entities.ContactMe;
import com.diptech.portfolio.services.ContactMeService;
import com.diptech.portfolio.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private EmailService emailService;


    @PostMapping("/saveContactDetails")
    public ResponseEntity<Boolean> saveContactInfo(@RequestBody ContactMe contactMeData) {
        if (contactMeService.saveContactMe(contactMeData)) {
            emailService.sendContactNotification(
                    contactMeData.getName(),
                    contactMeData.getEmail(),
                    contactMeData.getMessage()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        }
    }


}
