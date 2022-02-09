package com.uses.stories.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.uses.stories.datas.DatasRepositorie;
import com.uses.stories.models.EtatEnum;
import com.uses.stories.models.Storie;
import com.uses.stories.service.UsesStoriesService;

@Service
public class UsesStoriesServiceImpl implements UsesStoriesService {

	// retourne la liste des uses stories en cour d'un utilisateur donnees
	public List<Storie> getUsesStoriesByUser(String identifiant) {
		return DatasRepositorie.getStories1().stream()
			  .filter(stories -> stories.getIdentifiant().equals(identifiant) && stories.getEtatEnum() != EtatEnum.TERMINEE)
			  .collect(Collectors.toList());
	}

	@Override
	public List<Storie> updateStorie(Storie storie) {
		return DatasRepositorie.updateStorie(storie);
	}

	@Override
	public Storie addUsesStorie(Storie storie) {
		return Objects.nonNull(storie.getTitle()) ? DatasRepositorie.add(storie) : storie;
	}

}
