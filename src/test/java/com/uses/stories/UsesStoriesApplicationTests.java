package com.uses.stories;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uses.stories.datas.DatasRepositorie;
import com.uses.stories.models.EtatEnum;
import com.uses.stories.models.Storie;


@SpringBootTest
@AutoConfigureMockMvc
class UsesStoriesApplicationTests {
	
	private final String URI_BASE = "/stories";
	
	@Autowired
	protected MockMvc mockMvc;
	
	@BeforeEach
	public void setUp() {
		DatasRepositorie.create();
	}

	@Test
	void testgetUsesStoriesSuccess() throws Exception {
		final String URI[] = {URI_BASE, "id1"};
		mockMvc.perform(get(String.join("/", URI)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].title").value("title1"))
				.andDo(print());
	}
	
	@Test
	void testUpdateStateSuccess() throws Exception {
		Storie storie = new Storie(5, "title5", EtatEnum.TERMINEE, "description5", "id1");
		mockMvc.perform(put(URI_BASE)
			   .contentType(MediaType.APPLICATION_JSON_VALUE)
			   .content(convertObjectToJson(storie)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.[2].title").value("title5"))
		.andExpect(jsonPath("$.[2].etatEnum").value("TERMINEE"))
		.andDo(print());
	}
	
	@Test
	void testAddUsesStorieSuccess() throws Exception {
		Storie storie = new Storie(0, "title8", EtatEnum.CREE, "description8", "id1");
		mockMvc.perform(post(URI_BASE)
				   .contentType(MediaType.APPLICATION_JSON_VALUE)
				   .content(convertObjectToJson(storie)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.idStories").isNotEmpty())
			.andDo(print());
	}
	
	private <T> String convertObjectToJson(T object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

}
