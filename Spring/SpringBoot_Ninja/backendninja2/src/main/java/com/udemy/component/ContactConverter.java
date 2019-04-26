package com.udemy.component;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

//esta clase tiene 2 metodos 
// 1. convierte un modelo a Entidad
// 2. Convierte una Entidad a modelo

@Component("contactConverter")
public class ContactConverter {
	
	public Contact convertContactModel2Contact(ContactModel contactModel) {
		Contact contact= new Contact();
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setId(contactModel.getId());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		return contact;
	}
	public ContactModel convertContact2ContactModel(Contact contact) {
		
		ContactModel contactModel= new ContactModel();
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setId(contact.getId());	
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
			return contactModel;
	}

}
