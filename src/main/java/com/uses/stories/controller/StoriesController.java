package com.uses.stories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uses.stories.models.Storie;
import com.uses.stories.service.UsesStoriesService;

@RestController
@RequestMapping(path = "/stories")
public class StoriesController {
	
	private final UsesStoriesService usesStoriesService;
	
	@Autowired
	public StoriesController(UsesStoriesService usesStoriesService) {
		this.usesStoriesService = usesStoriesService;
	}
	
	@GetMapping(path="/{identifiant}")
	public ResponseEntity<List<Storie>> getUsesStories(@PathVariable(value = "identifiant") String identifiant) {
		return new ResponseEntity<>(usesStoriesService.getUsesStoriesByUser(identifiant), HttpStatus.OK);
	}
	
	// update state uses stories and return list uses storie sorted
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Storie>> updateState(@RequestBody Storie storie) {
		return new ResponseEntity<>(usesStoriesService.updateStorie(storie),HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Storie> addUsesStorie(@RequestBody Storie storie) {
		return new ResponseEntity<>(usesStoriesService.addUsesStorie(storie), HttpStatus.OK);
	}
}
