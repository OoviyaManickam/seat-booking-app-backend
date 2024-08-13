package com.seat.auth.dto;

import lombok.Data;

@Data
public class PasswordChangeDto {
  private String currentPassword;
  private String newPassword;
  private String status;
  private String message;
}
