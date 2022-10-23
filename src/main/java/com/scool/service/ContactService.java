package com.scool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.scool.model.Contact;
@Slf4j
@Service
public class ContactService {
	
	public boolean saveMessageDetaisl(Contact contact) {
		boolean isSaved = true;
		
		//logic to persist the data into the database
		log.info(contact.toString());
		return isSaved;
	}
}
