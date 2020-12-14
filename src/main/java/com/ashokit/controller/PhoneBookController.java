package com.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.constant.AppPropertiesConstant;
import com.ashokit.entity.Contact;
import com.ashokit.props.AppProperties;
import com.ashokit.service.PhoneBookService;

@Controller
public class PhoneBookController {
	
     private static final  Logger logger=LoggerFactory.getLogger(PhoneBookController.class);
	@Autowired
	private PhoneBookService service;
	@Autowired
	private AppProperties props;

	@GetMapping("loadform")
	public String loadForm(Map<String, Object> map, @ModelAttribute("contact") Contact contact) {
        
		return AppPropertiesConstant.CONTACT_PAGE;
		

	}

	@PostMapping("savecontact")
	public String saveForm(RedirectAttributes redirect, Contact contact) {
		logger.debug("****save form () excution started*****");
		  Map<String, String> messages = props.getMessages();
		String msg = null;
		if (contact.getContactid() == null) {
			logger.info("*****contact successfully save****");
			msg =messages.get(AppPropertiesConstant.SAVE_SUCC);
		}else {
			logger.info("*****contact successfully update****");
			msg = messages.get(AppPropertiesConstant.UPDATE_SUCC);
		}
		contact.setIsActive("y");
		String result = service.addContact(contact);
		if (result != null) {
			//keep in model attr
			redirect.addFlashAttribute(AppPropertiesConstant.RESULT_VAR, msg);
		} else {

			redirect.addFlashAttribute("errMsg", messages.get(AppPropertiesConstant.SAVE_FAIL));
		}
		logger.debug("****save form () excution succesful*****");
		logger.info("****save form() excution successful completed");
		return "redirect:view_contact";
	}

	@GetMapping("view_contact")
	public String handleViewContactLink(Model model) {
		logger.debug("*****handle view () execution started*****");
		//user service
		List<Contact> listContact = service.fetchAllContact();
		//keep in model attr
		model.addAttribute("listContact", listContact);
		logger.debug("*****handle view () execution ended*****");
		logger.info("******hanle view () execution successfully completed*****");
		return "Get_contact";
	}

	@GetMapping("edit")
	public String handleEditLink(@RequestParam("id") int id, Model model) {
		logger.debug("*****handle edit () execution startes******");
		Contact contact = service.editContactById(id);
		//keep in model scope
		model.addAttribute("contact", contact);
		logger.debug("*****handle edit () execution ended******");
		logger.info("handleEditLink() execution successfully completed*******");
		return AppPropertiesConstant.CONTACT_PAGE;

	}

	@GetMapping("/delete")
	public String handleDeleteLink(@RequestParam Integer cid) {
		logger.debug("*****deleteLink() execution started******");
		//use service method
		service.deleteContactById(cid);
		logger.debug("*****deleteLink() execution ended******");
		logger.info("*****deleteLink() execution successfully completed********");
		return "redirect:/view_contact";
	}

}
