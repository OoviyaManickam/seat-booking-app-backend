package com.seat.auth.dto;

import lombok.Data;

@Data
public class RegisterDto {
  private int status;
  private String message;
  private String password;
  private String name;
  private String email;
  private String phoneNumber;
  private int age;
  private String location;
  private int role;
}
