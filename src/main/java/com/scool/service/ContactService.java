package com.scool.service;

import org.springframework.stereotype.Service;

import com.scool.model.Contact;

@Service
public class ContactService {
	
	public boolean saveMessageDetaisl(Contact contact) {
		boolean isSaved = true;
		
		//logic to persist the data into the database
		
		return isSaved;
	}
}
