package com.scool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	
	@RequestMapping("/contact")
	public String displayContact() {
		return "contact";
	}
	
	@PostMapping("/saveMsg")
	public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum, 
			@RequestParam String email, @RequestParam String subject, @RequestParam String message) {
		// basic logic goees here
		
		return new ModelAndView("redirect:/contact");
	}
}
