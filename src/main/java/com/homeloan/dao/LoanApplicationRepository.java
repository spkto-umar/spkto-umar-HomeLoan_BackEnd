package com.homeloan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.entity.LoanApplication;

@Repository("loanRepo")
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Integer> {

}
