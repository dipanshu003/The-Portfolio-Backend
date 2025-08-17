package com.diptech.portfolio.services;

import com.diptech.portfolio.dao.ContactMeRepository;
import com.diptech.portfolio.entities.ContactMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactMeService {

    @Autowired
    private ContactMeRepository contactMeRepository;

    public boolean saveContactMe(ContactMe contactData) {
        if (contactData != null
                && contactData.getName() != null
                && contactData.getEmail() != null) {

            // Better to use logger instead of println
            System.out.println("In Service: " + contactData);

            contactMeRepository.save(contactData);
            return true;
        }
        return false;
    }


}
