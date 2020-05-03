package com.vmware.calc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.vmware.calc.controller.CalcController;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {CalcController.class})
@WebMvcTest
public class VmwareCalcApplicationTests {// extends VmwareCalcApplicationTests {

	
	@Autowired
	private WebApplicationContext webApplicationContext;


	private MockMvc mockMvc;

	@BeforeEach
    void createNewStack() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@WithMockUser(username = "admin", password = "admin")
	public void testAdd() throws Exception {
		mockMvc.perform(post("/api/add")
//					.header(HttpHeaders.AUTHORIZATION,
//	                    "Basic " + Base64Utils.encodeToString("admin:admin".getBytes()))
		           .contentType(MediaType.APPLICATION_JSON)
		           .content("{ \"x\": \"100\", \"y\": \"50\" }") 
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().isOk())
		           .andExpect(jsonPath("$.result").value(150)); 

	}
	
	@Test
	@WithMockUser(username = "admin", password = "admin")
	public void testDiff() throws Exception {
		mockMvc.perform(post("/api/diff")
//					.header(HttpHeaders.AUTHORIZATION,
//	                    "Basic " + Base64Utils.encodeToString("admin:admin".getBytes()))
		           .contentType(MediaType.APPLICATION_JSON)
		           .content("{ \"x\": \"100\", \"y\": \"50\" }") 
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().isOk())
		           .andExpect(jsonPath("$.result").value(50)); 

	}
}
