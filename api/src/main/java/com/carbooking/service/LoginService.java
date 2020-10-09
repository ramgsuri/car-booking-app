package com.carbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carbooking.model.LoginDto;
import com.carbooking.model.LoginResponse;
import com.carbooking.repo.Register;
import com.carbooking.repo.RegisterRepository;

@Service
public class LoginService {

    @Autowired
    private RegisterRepository registerRepository;

    public LoginResponse checkLogin(LoginDto dto) {
        Register register = registerRepository.findByUsername(dto.getUsername());
        return new LoginResponse(register.getUsername(), register.getUserType());
        
    }
}
