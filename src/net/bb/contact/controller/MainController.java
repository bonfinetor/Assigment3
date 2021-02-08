package net.bb.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.bb.contact.model.Contact;
import net.bb.contact.service.ContactServiceImpl;

@Controller
public class MainController {

	@Autowired
	private ContactServiceImpl contactService;
	
	
	@RequestMapping(value = "/")
	public ModelAndView ListContact(ModelAndView model) {
		
		List<Contact> listContact = contactService.list();
		model.addObject("listContact", listContact);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView ListContact1(ModelAndView model) {
		
		List<Contact> listContact = contactService.list();
		model.addObject("listContact", listContact);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("contact_form");
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Contact contact) {
		if(contact.getId() == null) {
			contactService.save(contact);
		} else {
			contactService.update(contact);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactService.get(id);
		
		ModelAndView model = new ModelAndView("contact_form");
		
		model.addObject("contact", contact);
		
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteContact(@RequestParam Integer id) {
		contactService.deleteContact(id);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchContact(ModelAndView model, HttpServletRequest request) {
		String s = request.getParameter("search");
		List<Contact> listContact = contactService.search(s);
		model.addObject("listContact", listContact);
		model.setViewName("searchpage");
		return model;
	}
	
}