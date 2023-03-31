package com.stl.EmployeeLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.EmployeeLogin.jwt.JwtUtils;
import com.stl.EmployeeLogin.model.EmployeeLogin;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("Employee")
public class EmployeeloginController {
	
	@Autowired
    AuthenticationManager authmanage;
    
    @Autowired
    JwtUtils jwtUtils;
    
    
  //login
    @PostMapping("/authenticatetoken")
    public String authDoctor(@RequestBody EmployeeLogin employee){
        try {
            @SuppressWarnings("unused")
            
            Authentication authtoken=  authmanage.authenticate(
                    new UsernamePasswordAuthenticationToken(employee.getEmail(), employee.getPassword()));
            String token = jwtUtils.generateToken(employee.getEmail().toString());
            return token;
            
        } catch (Exception e) {
            // TODO: handle exception
            return "Login Failed";
        }
    }

}
