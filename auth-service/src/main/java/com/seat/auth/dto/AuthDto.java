package com.seat.auth.dto;

import lombok.Data;

@Data
public class AuthDto {
  private int status;
  private String name;
  private String message;
  private String token;
}
