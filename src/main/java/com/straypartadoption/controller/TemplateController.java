package com.straypartadoption.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class TemplateController {

	@GetMapping
	public String getLogin() {
		return "login";
	}
	
}
