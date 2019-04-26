package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContacService;

@Service("contacServiceImpl")
public class ContacServiceImpl implements ContacService {

	// se inyecta el repository:
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		/*retornara un listado de entidad "Contact" y debe ser pasado a un ContactModel*/
		List<Contact> contacts = contactRepository.findAll(); //este listado de contactos debe ser recorrido
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		for (Contact contact : contacts) {

			contactsModel.add(contactConverter.convertContact2ContactModel(contact));/*como recibe un contact, hay que pasarle
			un listado de contactos q se ira recorriendo */
		}
		return contactsModel;
	}
	
	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}
	@Override
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(contactRepository.findById(id)) ;
	}
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(null != contact) {
			contactRepository.delete(findContactById(id));
		}
	}

}