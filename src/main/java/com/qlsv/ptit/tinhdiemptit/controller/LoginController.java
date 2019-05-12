package com.qlsv.ptit.tinhdiemptit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage() {
		return "/login/login-page";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "/ngoaile/access-denied";
	}
}
