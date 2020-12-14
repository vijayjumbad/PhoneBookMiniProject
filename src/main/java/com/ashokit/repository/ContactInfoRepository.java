package com.ashokit.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Contact;

public interface ContactInfoRepository extends JpaRepository<Contact, Serializable> {
	
	List<Contact> findByIsActive(String s);

}
