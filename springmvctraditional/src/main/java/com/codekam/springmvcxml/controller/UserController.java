package com.codekam.springmvcxml.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.codekam.springmvcxml.model.User;

@Controller
@SessionAttributes("exampleSessionAttribute")
public class UserController {

	Logger log=LoggerFactory.getLogger("abc");
	
	private static final String REDIRECT_USER_LIST = "redirect:/list-users";	
	private final String CREATE_USER_PAGE="User/user";
	private final String LIST_USER="User/list-users";
	
	@ModelAttribute("countryList")
	public List<String> countryList() {
		return Arrays.asList("India","Australia","Newzeland","Westindies");
	}
	
	@RequestMapping(value="/create-user" ,method = {RequestMethod.GET})
	public String showCreateUserPage(ModelMap model) {
		model.addAttribute("user",new User());
		model.addAttribute("exampleSessionAttribute", "Guest User");
		return CREATE_USER_PAGE;
	}
	
	@RequestMapping(value="/create-user",method= {RequestMethod.POST})
	public String addTodo(User user,ModelMap model) {
		model.addAttribute("exampleSessionAttribute", user.getName());
		log.error("user details "+user);
		return REDIRECT_USER_LIST;
	}
	
	@RequestMapping(value="/create-user-with-valiation",method= {RequestMethod.POST})
	public String addTodoWithValidation(@Valid User user,BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			return CREATE_USER_PAGE;
		}
		model.addAttribute("exampleSessionAttribute", user.getName());
		log.info("user datils "+user);
		return REDIRECT_USER_LIST;
	}
	
	@RequestMapping(value="/list-users" ,method= {RequestMethod.GET})
	public String listUser() {
		return LIST_USER;
	}
}
