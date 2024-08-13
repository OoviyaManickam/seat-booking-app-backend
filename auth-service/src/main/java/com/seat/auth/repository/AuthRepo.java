package com.seat.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seat.auth.entity.AuthEntity;

@Repository
public interface AuthRepo extends JpaRepository<AuthEntity, String> {
    AuthEntity findByEmail(String email);

    boolean existsByEmail(String email);
}
