package net.bb.contact.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import net.bb.contact.model.Contact;

@Component
public class ContactServiceImpl implements ContactService {

	
	static HashMap<Integer,Contact> contactIdMap=getContactIdMap();
	
	int i = 4;
	
	public ContactServiceImpl() {
		  super();
		  contactIdMap=new HashMap<Integer,Contact>();
		  initContact();		  
	}
	
	public static void initContact() {
			  Contact personaContatto1=new Contact(1, "Bill Gates", "bill@microsoft.com","New York","123");
			  Contact personaContatto2=new Contact(2, "Larry Page", "page@gmail.com","California","456");
			  Contact personaContatto3=new Contact(3, "Matteo", "matteobonfà@gmail.com","Milano","789");
			  Contact personaContatto4=new Contact(4, "Paolo Binda", "paolobinda@gmail.com","Intra","000");	
			  contactIdMap.put(1,personaContatto1);
			  contactIdMap.put(2,personaContatto2);
			  contactIdMap.put(3,personaContatto3);
			  contactIdMap.put(4,personaContatto4);
	 }
	
	public static HashMap<Integer, Contact> getContactIdMap() {		  
		return contactIdMap;
	}
	
	@Override
	public Contact save(Contact c) {
		i++;
		c.setId(i);
		contactIdMap.put(i, c);
		return c;
	}
	
	@Override
	public Contact update(Contact c) {		
		if(c.getId()<=0)
			  return null;
		contactIdMap.put(c.getId(), c);
			  return c;
	}

	@Override
	public Contact get(Integer id) {
		  Contact contact= contactIdMap.get(id);
		  return contact;
	}

	@Override
	 public void deleteContact(Integer id){
	  contactIdMap.remove(id);
	 }

	@Override
	public List<Contact> list() {
		List<Contact> contacts = new ArrayList<Contact>(contactIdMap.values());
		return contacts;
	}

	@Override
	public List<Contact> search(String s) {
		List<Contact> searchList = new ArrayList<Contact>();
		Iterator<Integer> it = contactIdMap.keySet().iterator(); 
		while(it.hasNext()) {
			Integer entry = it.next(); 
			if (contactIdMap.get(entry).getName().equalsIgnoreCase(s) || 
				contactIdMap.get(entry).getEmail().equalsIgnoreCase(s) || 
				contactIdMap.get(entry).getAddress().equalsIgnoreCase(s) || 
				contactIdMap.get(entry).getPhone().equalsIgnoreCase(s)) {
					searchList.add(contactIdMap.get(entry));
				}
		}
		contactIdMap.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
		System.out.println(contactIdMap.size());
		return searchList;
	}

}
