package com.straypartadoption.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straypartadoption.entity.User;
import com.straypartadoption.entity.UserRole;
import com.straypartadoption.security.UserSecurityService;

@Service
public class RegistrationService {
		
	@Autowired
	UserSecurityService userSecurityService;
	RegistrationRequest request;
	
	public void registerUser (RegistrationRequest request) {
        userSecurityService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
 
	}
	
}
