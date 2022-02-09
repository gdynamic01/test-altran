package com.uses.stories.service;

import java.util.List;

import com.uses.stories.models.Storie;

public interface UsesStoriesService {

	List<Storie> getUsesStoriesByUser(String identifiant);
	List<Storie> updateStorie(Storie storie);
	Storie addUsesStorie(Storie storie);
}
