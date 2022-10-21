package com.scool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	// theses are navigations that requires no business logic only click and view 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/courses").setViewName("courses");
		registry.addViewController("/about").setViewName("about");   
		registry.addViewController("/holidays").setViewName("holidays"); 
	}
}
