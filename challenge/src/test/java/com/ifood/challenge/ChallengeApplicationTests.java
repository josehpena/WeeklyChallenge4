package com.ifood.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifood.challenge.location.LocationController;
import com.ifood.challenge.location.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
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

	@Autowired
	private LocationService locationService;


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
					.andExpect(jsonPath("$[0].name").value("Location 1"));
	}

	@Test
	public void create_a_list_of_locations() throws Exception{

		ResultActions resultActions = mockMvc.perform(
				get("/feather/10")
						.contentType(MediaType.APPLICATION_JSON));

		resultActions
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(10)))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[9].name").value("Location 10"));
	}

	@Test
	public void expect_empty_body() throws Exception {
		mockMvc.perform(get("/feather/0")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$").isEmpty());

	}

	@Test
		public void givenBadArguments_whenGetSpecificException_thenBadRequest() throws Exception {

		assertThrows(IllegalArgumentException.class,() -> { locationService.getLocation(-1);});

	}






}
