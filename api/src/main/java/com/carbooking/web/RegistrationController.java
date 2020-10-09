package com.carbooking.web;



import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import com.carbooking.exception.InvalidRequestException;

import com.carbooking.model.RegisterDto;

import com.carbooking.repo.Register;

import com.carbooking.service.RegisterService;



@RestController

@RequestMapping("/register")

public class RegistrationController {



    @Autowired

    RegisterService service;



    @PostMapping

    public ResponseEntity<Register> registerUser(@Valid @RequestBody RegisterDto dto) throws InvalidRequestException {

    	String errorMsg = validateRegisterDto(dto);

    	if(errorMsg != "") {

    		throw new InvalidRequestException(errorMsg);

    	}
    	Register register = null;
    	try {

    		 register = service.add(dto);

		} catch (DataIntegrityViolationException e) {

			throw new InvalidRequestException("Duplicate user");

		}

        return new ResponseEntity<Register>(register, HttpStatus.OK);

    }



	private String validateRegisterDto(@Valid RegisterDto dto) {

		String errorMsg = "";

		if(StringUtils.isEmpty(dto.getUsername())) {

			errorMsg = "Username must not be empty";

		}

		if(StringUtils.isEmpty(dto.getPassword())) {

			errorMsg = "Password must not be empty";

		}

		if(StringUtils.isEmpty(dto.getUserType())) {

			errorMsg = "User type must not be empty";

		}

		if(dto.getCustomerDto() == null ) {

			if(dto.getDealerDto() == null) {

				errorMsg = "Dealer details must not be empty";

			}

		}

		if(dto.getDealerDto() == null ) {

			if(dto.getCustomerDto() == null) {

				errorMsg = "Customer details must not be empty";

			}

		}

		return errorMsg;

			

	}



}