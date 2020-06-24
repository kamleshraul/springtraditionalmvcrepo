package com.codekam.springmvcxml.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class MyControllerTest {

	private MockMvc mockMvc;
	
	private MyController myController;
	
	@BeforeEach
	void setUp() throws Exception {
		myController=new MyController();
		mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
	}

	@Test
	void testMyfirst() throws Exception {
		mockMvc.perform(get("/ping"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("index"));
	}

	@Test
	void testMyfirstThymeleaft() throws Exception {
		mockMvc.perform(get("/pingthymeleaf"))
		   .andExpect(status().isOk())
		   .andExpect(view().name("index.html"));
	}

	
	 

}
