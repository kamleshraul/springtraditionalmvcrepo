package com.codekam.springmvcxml.advices;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DateBindingControllerAdvice {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateformat,false));
	}

}
