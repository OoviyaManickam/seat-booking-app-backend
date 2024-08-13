package com.seat.auth.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "auth")
public class AuthEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;
    private Integer role;
    private String email;
    private String password;
}
