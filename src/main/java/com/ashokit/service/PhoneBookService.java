package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Contact;


public interface PhoneBookService {
	
	public String addContact(Contact contact);
	public List<Contact> fetchAllContact();
	public void deleteContactById(Integer id);
	public Contact editContactById(Integer id);

}
