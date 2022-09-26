package com.homeloan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.entity.IncomeDetails;

@Repository("incomeRepo")
public interface IncomeDetailsRepository extends JpaRepository<IncomeDetails, Integer> {

}
