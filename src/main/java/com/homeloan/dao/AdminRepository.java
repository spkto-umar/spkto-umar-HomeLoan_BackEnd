package com.homeloan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.entity.Admin;

@Repository("adminRepo")
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
