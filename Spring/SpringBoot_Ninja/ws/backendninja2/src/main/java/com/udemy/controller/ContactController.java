package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.service.ContacService;

@Controller
@RequestMapping("/contacts") 
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contacServiceImpl")
	private ContacService contactService;
	
		@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontact";
	}
	
	@GetMapping("/contactform")
	public String redirectContactForm(@RequestParam(name="id", required = false) int id,
			Model model) {
		ContactModel contact = new ContactModel();
		if(id != 0) {
			contact= contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel",contact);
		return ViewConstant.CONTACT_FORM;
	}

	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model){
		LOG.info("METHOD: addContact() -- PARAMS: "+ contactModel.toString());
		//si esto es distinto de null, es decir ha insertado en la base de datos
		if(null != contactService.addContact(contactModel)) {
			//va añadir un result 1
			model.addAttribute("result", 1);
		}else {
			model.addAttribute("result", 0);
		}
		return "redirect:/contacts/showcontact";
	}
	@GetMapping("/showcontact")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required = true) int id) {
		 contactService.removeContact(id);
		 return showContacts();
	}
	
	
	

}
