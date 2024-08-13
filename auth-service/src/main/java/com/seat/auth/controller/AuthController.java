package com.seat.auth.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seat.auth.dto.AuthDto;
import com.seat.auth.dto.PasswordChangeDto;
import com.seat.auth.dto.RegisterDto;
import com.seat.auth.entity.AuthEntity;
import com.seat.auth.service.AuthService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  AuthService service;

  @PostMapping("/register")
  public ResponseEntity<RegisterDto> handleRegister(@RequestBody RegisterDto body) throws IOException{
    return service.registerUser(body);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthDto> handleLogin(@RequestBody AuthEntity body){
    return service.loginUser(body);
  }

  @GetMapping("/token")
  public String handleToken(@RequestHeader("Authorization") String token){
    return service.getCustomerIdfromToken(token);
  }

  @GetMapping("/getdetails")
  public ResponseEntity<RegisterDto> getProfileDetails(@RequestHeader("Authorization") String token){
    return service.getUserDetails(token);
  }

  @PostMapping("/updatedetails")
  public ResponseEntity<RegisterDto> updateProfileDetails(@RequestBody RegisterDto dto){
    System.out.println(dto);
    return service.updateUserDetails(dto);
  }

  @PostMapping("/changepassword")
    public ResponseEntity<PasswordChangeDto> changePassword(@RequestBody PasswordChangeDto data,@RequestHeader("Authorization") String token) {
        return service.changePassword(data,token);
    }
}
