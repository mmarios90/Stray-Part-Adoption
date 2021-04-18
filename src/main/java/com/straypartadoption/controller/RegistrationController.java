package com.straypartadoption.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.straypartadoption.registration.RegistrationRequest;
import com.straypartadoption.registration.RegistrationService;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("request", new RegistrationRequest());
		return "registration";
	}

	@PostMapping
	public String userRegistration(@Valid RegistrationRequest request, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("request", request);
			System.out.println("Skataaaa");
			return "registration";
		}

		registrationService.registerUser(request);
		System.out.println("Success! You can now login to your account.");
		return "registrationSuccess";
	}

}
