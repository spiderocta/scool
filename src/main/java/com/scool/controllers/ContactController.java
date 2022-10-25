package com.scool.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scool.model.Contact;
import com.scool.service.ContactService;

import javax.validation.Valid;

@Controller
@Slf4j
public class ContactController {
	
	private final ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	
	
	@RequestMapping("/contact")
	public String displayContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}

	@PostMapping("/saveMsg")
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		if(errors.hasErrors()){
			log.error("contact form validations failed due to : " + errors.toString());
			return "contact";
		}
		contactService.saveMessageDetaisl(contact);
		return "redirect:/contact";
	}
}
