package com.scool.model;

import lombok.Data;

// this class object will hold the contact form data from the view
@Data
public class Contact {
	private String name;
	private String mobileNum;
	private String email;
	private String subject;
	private String message;


}
