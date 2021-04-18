package com.straypartadoption.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.straypartadoption.entity.User;
import com.straypartadoption.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public UserSecurityService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository; 
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	 

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format("user with email %s not found", email)));
	}
	
	public void signUpUser (User user) {
		boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();
		
		if (userExists) throw new IllegalStateException("email already in use");
		
		String encodedPassword  = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		
		//String token = UUID.randomUUID().toString();
		//return token;
	}

}
