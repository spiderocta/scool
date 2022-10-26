package com.scool.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.scool.model.Contact;
import com.scool.service.ContactService;

import javax.validation.Valid;
import org.springframework.security.core.Authentication;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class ContactController {

	private final ContactService contactService;

	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
	}


	@RequestMapping(value = "/saveMsg",method = POST)
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		if(errors.hasErrors()){
			log.error("Contact form validation failed due to : " + errors.toString());
			return "contact.html";
		}
		contactService.saveMessageDetails(contact);
		return "redirect:/contact";
	}

	@RequestMapping("/displayMessages")
	public ModelAndView displayMessages(Model model) {
		List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
		ModelAndView modelAndView = new ModelAndView("messages.html");
		modelAndView.addObject("contactMsgs",contactMsgs);
		return modelAndView;
	}

	@RequestMapping(value = "/closeMsg",method = GET)
	public String closeMsg(@RequestParam int id, Authentication authentication) {
		contactService.updateMsgStatus(id,authentication.getName());
		return "redirect:/displayMessages";
	}

}
