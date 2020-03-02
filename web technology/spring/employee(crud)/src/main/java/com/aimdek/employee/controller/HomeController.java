package com.aimdek.employee.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aimdek.employee.beans.emp;
import com.aimdek.employee.dao.empDao;

@Controller
public class HomeController {

	
	@Autowired
	empDao empDao;

//	@RequestMapping(value = "/")
//	public String test(HttpServletResponse response) throws IOException {
//		return "home";
//	}

	
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model) throws IOException {
		List<emp> listContact = empDao.list();
		model.addObject("listContact", listContact);
		model.setViewName("home");
		
		return model;
	}

	@RequestMapping(value = "/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    emp newContact = new emp();
	    model.addObject("contact", newContact);
	    model.setViewName("ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute emp contact) {
	    empDao.saveOrUpdate(contact);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    empDao.delete(contactId);
	    return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int contactId = Integer.parseInt(request.getParameter("id"));
	    emp contact = empDao.get(contactId);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("contact", contact);
	 
	    return model;
	}
	
	
}
