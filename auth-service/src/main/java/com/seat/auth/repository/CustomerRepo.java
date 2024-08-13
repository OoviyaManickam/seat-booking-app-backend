package com.seat.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seat.auth.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, String>{
  CustomerEntity findByCustomerId(String customerId);
  
  boolean existsByCustomerId(String customerId);
}
