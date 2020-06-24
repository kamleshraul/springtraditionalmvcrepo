package com.codekam.springmvcxml.controller;

import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	public MyController() {
		System.out.println("Index Controller initilaized");
	}
	
	@InitBinder
	protected void initbinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}
	
	@RequestMapping("/ping")
	public String myfirst() {
		System.out.println("INdex controller");
		return "index";
	}
	
	@RequestMapping("/pingthymeleaf")
	public String myfirstThymeleaft() {
		System.out.println("Hitting Thymeleaf view");
		return "index.html";
	}
	
	@RequestMapping("/welcome-model-view")
	public ModelAndView welcome(ModelMap model) {
		model.put("name","ZYZ");
		return new ModelAndView("welcome-model-view", model);
		
	}
}
