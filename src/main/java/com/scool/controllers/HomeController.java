package com.scool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "", "/home"})
	public String displayHome() {
		return "home";
	}
	
	@RequestMapping("/courses")
	public String displayCourses() {
		return "courses";
	}
	
}
