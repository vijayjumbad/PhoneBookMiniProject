package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ashokit.entity.Contact;
import com.ashokit.repository.ContactInfoRepository;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {
	@Autowired
	private ContactInfoRepository repo;

	@Override
	public String addContact(Contact contact) {

		Contact save = repo.save(contact);

		return save != null ? "contact saved successfully" : "Contact not saved";
	}

	@Override
	public List<Contact> fetchAllContact() {
		List<Contact> listEntity = null;

		return listEntity = repo.findByIsActive("y");

	}

	@Override
	public void deleteContactById(Integer id) {
		Contact contact = repo.findById(id).get();
		contact.setIsActive("N");
		repo.save(contact);
	}

	@Override
	public Contact editContactById(Integer id) {
		Optional<Contact> findById = repo.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			return null;

	}

}
