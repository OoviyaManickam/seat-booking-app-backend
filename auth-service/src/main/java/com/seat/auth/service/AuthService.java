package com.seat.auth.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.seat.auth.dto.AuthDto;
import com.seat.auth.dto.PasswordChangeDto;
import com.seat.auth.dto.RegisterDto;
import com.seat.auth.entity.AuthEntity;
import com.seat.auth.entity.CustomerEntity;
import com.seat.auth.middleware.JwtToken;
import com.seat.auth.model.TokenModel;
import com.seat.auth.repository.AuthRepo;
import com.seat.auth.repository.CustomerRepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;

@Service
public class AuthService {
    @Autowired
    private JwtToken jwt;

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Value("$(spring.mail.username)")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String htmlContent, String gifPath) throws MessagingException, IOException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true); // true indicates HTML

        FileSystemResource res = new FileSystemResource(gifPath);
        helper.addInline("registration", res);

        mailSender.send(message);
    }

    public String loadHtmlTemplate(String templatePath) throws IOException {
        Resource resource = new ClassPathResource(templatePath);
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

  public ResponseEntity<RegisterDto> registerUser(RegisterDto user) throws IOException {
        boolean found = authRepo.existsByEmail(user.getEmail());
        if (found) {
            user.setStatus(401);
            user.setMessage("Email already exists");
        } else {
            AuthEntity auth = new AuthEntity();
            BeanUtils.copyProperties(user, auth);

            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            auth.setPassword(bcrypt.encode(auth.getPassword()));
            authRepo.save(auth);

            CustomerEntity customer = new CustomerEntity();
            BeanUtils.copyProperties(user, customer);
            customer.setCustomerId(auth.getId());
            customerRepo.save(customer);
            user.setStatus(200);
            user.setMessage("Email registered successfully");

            String htmlContent;
            try {
                htmlContent = loadHtmlTemplate("templates/registration_template.html");
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(user);
            }

            String gifPath = new ClassPathResource("static/registration.gif").getFile().getAbsolutePath();
            try {
                sendEmail(auth.getEmail(), "Registration Successful", htmlContent, gifPath);
            } catch (MessagingException | IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.status(user.getStatus()).body(user);
    }

  public ResponseEntity<AuthDto> loginUser(AuthEntity user)
  {
    AuthEntity found = authRepo.findByEmail(user.getEmail());
    AuthDto response = new AuthDto();
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    if(found != null){
      boolean pwdCheck = bcrypt.matches(user.getPassword(), found.getPassword());
      if(pwdCheck){
        response.setStatus(200);
        response.setMessage("User login successful");
        response.setToken(jwt.generateToken(found));
        CustomerEntity customerEntity = customerRepo.findByCustomerId(found.getId());
        response.setName(customerEntity.getName());
      }
      else{
        response.setStatus(401);
        response.setMessage("Password does not match");
      }
    }
    else{
      response.setStatus(401);
      response.setMessage("User does not exist");
    }
    return ResponseEntity.status(response.getStatus()).body(response);
  }

  public String getCustomerIdfromToken(String token){
    if (token.startsWith("Bearer ")) {
      token = token.substring(7);
  }
    TokenModel tokenModel = jwt.getTokenModelfromToken(token.split(" ")[1]);
    String customerid = tokenModel.getId();
    return customerid;
  }

  public ResponseEntity<RegisterDto> getUserDetails(String token){
    token = "Bearer " + token;
    String customerid = getCustomerIdfromToken(token);
    CustomerEntity customer = customerRepo.findByCustomerId(customerid);
    RegisterDto dto = new RegisterDto();
    BeanUtils.copyProperties(customer, dto);
    AuthEntity auth = authRepo.findById(customerid).get();
    BeanUtils.copyProperties(auth, dto);
    dto.setStatus(200);
    return ResponseEntity.status(dto.getStatus()).body(dto);
  }

  public ResponseEntity<RegisterDto> updateUserDetails(RegisterDto data){
      AuthEntity auth = authRepo.findByEmail(data.getEmail());
      if (auth != null) {
        auth.setEmail(data.getEmail());
        authRepo.save(auth);

        CustomerEntity customer = customerRepo.findByCustomerId(auth.getId());
        if (customer != null) {
          customer.setName(data.getName());
          customer.setPhoneNumber(data.getPhoneNumber());
          customerRepo.save(customer);
        }
        return ResponseEntity.ok(data);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
  }

  public ResponseEntity<PasswordChangeDto> changePassword(PasswordChangeDto data,String token) {
    token = "Bearer " + token;
    String customerid = getCustomerIdfromToken(token);
    AuthEntity auth = authRepo.findById(customerid).get();
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    boolean pwdCheck = bcrypt.matches(data.getCurrentPassword(), auth.getPassword());
    if (!pwdCheck) {
        data.setStatus("error");
        data.setMessage("Current password is incorrect.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(data);
    }

    auth.setPassword(bcrypt.encode(data.getNewPassword()));
    authRepo.save(auth);
    data.setStatus("success");
    data.setMessage("Password changed successfully.");
    return ResponseEntity.ok(data);
  }
  
}
