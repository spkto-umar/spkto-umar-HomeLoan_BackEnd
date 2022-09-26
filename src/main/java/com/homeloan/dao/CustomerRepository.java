package com.homeloan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeloan.entity.Customer;

@Repository("customerRepo")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
