package com.scool.service;

import com.scool.constants.ScoolConstants;
import com.scool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scool.model.Contact;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;


	public boolean saveMessageDetails(Contact contact){
		boolean isSaved = false;
		contact.setStatus(ScoolConstants.OPEN);
		contact.setCreatedBy(ScoolConstants.ANONYMOUS);
		contact.setCreatedAt(LocalDateTime.now());
		int result = contactRepository.saveContactMsg(contact);
		if(result>0) {
			isSaved = true;
		}
		return isSaved;
	}

	public List<Contact> findMsgsWithOpenStatus(){
		List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(ScoolConstants.OPEN);
		return contactMsgs;
	}

	public boolean updateMsgStatus(int contactId, String updatedBy){
		boolean isUpdated = false;
		int result = contactRepository.updateMsgStatus(contactId,ScoolConstants.CLOSE, updatedBy);
		if(result>0) {
			isUpdated = true;
		}
		return isUpdated;
	}

}
