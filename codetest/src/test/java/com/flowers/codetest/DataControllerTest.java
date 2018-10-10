package com.flowers.codetest;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CodetestApplication.class)
@SpringBootTest
public class DataControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webContext;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}

	@Test
	public void testService() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/getData").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testModifyCall() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.put("/v1/getData/modify/4").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.is(4)))
				.andExpect(jsonPath("$.title", Matchers.is("1800Flowers")))
				.andExpect(jsonPath("$.body", Matchers.is("1800Flowers")));
	}

	@Test
	public void tetUniqueCall() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/v1/getData/unique").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.uniqueDataCount", Matchers.is(10)));
	}

}
