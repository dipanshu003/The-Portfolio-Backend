package com.diptech.portfolio.dao;

import com.diptech.portfolio.entities.MyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyInfoRepository extends JpaRepository<MyInfo, Integer> {

}
