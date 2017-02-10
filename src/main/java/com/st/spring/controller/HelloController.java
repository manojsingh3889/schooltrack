package com.st.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("printing ============= helloooooo heeeelllloooo");
		model.addAttribute("name", "John Doe");

		return "welcome";
	}
}
