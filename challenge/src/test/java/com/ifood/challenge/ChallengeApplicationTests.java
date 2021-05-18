package com.ifood.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifood.challenge.location.ExceptionController;
import com.ifood.challenge.location.LocationController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ChallengeApplicationTests {

	private final String BASE_URL = "/feather/";

	//Instância do ObjectMapper para trabalhar com JSON
	private ObjectMapper objectMapper;

	//Controlador REST tratado por meio de injeção de dependências
	@Autowired
	private LocationController restController;

	//Instância do MockMVC
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders
				.standaloneSetup(restController, new ExceptionController())
				.build();
	}

	@Test
	public void not_found_test_404() throws Exception {
		mockMvc.perform(get(BASE_URL)).andExpect(status().isNotFound());
	}

	@Test
	public void createLocationTest() throws Exception{

		ResultActions resultActions = mockMvc.perform(
				get("/feather/1")
				.contentType(MediaType.APPLICATION_JSON));

			resultActions
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
					.andExpect(jsonPath("$[0].name").value("Location 0"));
	}

	@Test
	public void givenBadArguments_whenGetSpecificException_thenBadRequest() throws Exception {
		String exceptionParam = "bad_arguments";

		mockMvc.perform(get("/feather/-1", exceptionParam)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isBadRequest())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof ExceptionController.BadArgumentsException))
				.andExpect(result -> assertEquals("bad arguments", result.getResolvedException().getMessage()));
	}





}
