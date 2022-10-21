package com.scool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scool.model.Contact;
import com.scool.service.ContactService;

@Controller
public class ContactController {
	
	private final ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	
	
	@RequestMapping("/contact")
	public String displayContact() {
		return "contact";
	}
	
//	@PostMapping("/saveMsg")
//	public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum, 
//			@RequestParam String email, @RequestParam String subject, @RequestParam String message) {
//		// basic logic goes here
//		
//		return new ModelAndView("redirect:/contact");
//	}
	
	@PostMapping("/saveMsg")
	public ModelAndView saveMessage(Contact contact) {
		// test the flow
		contactService.saveMessageDetaisl(contact);
		
		return new ModelAndView("redirect:/contact");
	}
}
