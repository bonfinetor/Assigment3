package net.bb.contact.service;

import java.util.List;

import net.bb.contact.model.Contact;

public interface ContactService {
	
	public Contact update(Contact contact);
	
	public Contact get(Integer id);
	
	public List<Contact> list();

	void deleteContact(Integer id);

	public Contact save(Contact c);
	
	public List<Contact> search(String s);
}
