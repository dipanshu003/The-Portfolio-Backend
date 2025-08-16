package com.diptech.portfolio.services;

import com.diptech.portfolio.dao.MyInfoRepository;
import com.diptech.portfolio.entities.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyInfoService {

    @Autowired
    private MyInfoRepository myInfoRepo;

    public MyInfo getFullInfo() {
        return myInfoRepo.findById(1).orElse(null);
    }


}
