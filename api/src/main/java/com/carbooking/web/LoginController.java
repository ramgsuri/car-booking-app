package com.carbooking.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbooking.model.LoginDto;
import com.carbooking.model.LoginResponse;
import com.carbooking.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> registerUser(@RequestBody LoginDto dto) {
    	
        return new ResponseEntity<LoginResponse>(loginService.checkLogin(dto), HttpStatus.OK);
    }
}
