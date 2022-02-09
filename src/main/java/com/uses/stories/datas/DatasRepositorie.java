package com.uses.stories.datas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.uses.stories.models.EtatEnum;
import com.uses.stories.models.Storie;

public abstract class DatasRepositorie {
	
	private static int index = 1;
	private static List<Storie> stories1 = new ArrayList<>();
	private static List<Storie> stories2 = new ArrayList<>();
	
	
	public static void setUsesStories(List<Storie> stories) {
		stories.add(new Storie(index, "title"+index, EtatEnum.EN_COUR, "description"+index, "id1"));
		index++;
		stories.add(new Storie(index, "title"+index, EtatEnum.CREE, "description"+index, "id1"));
		index++;
		stories.add(new Storie(index, "title"+index, EtatEnum.CREE, "description"+index, "id1"));
		index++;
		stories.add(new Storie(index, "title"+index, EtatEnum.TERMINEE, "description"+index, "id1"));
		index++;
	}
	
	// create data
	public static void create() {
		setUsesStories(stories1);
		setUsesStories(stories2);
	}
	
	// update storie
	public static List<Storie> updateStorie(Storie storie) {
		int i = 0;
		while(i<stories2.size() && stories2.get(i).getIdStories() != storie.getIdStories()) {
			i++;
		}
		if (i<stories2.size()) {
			stories2.get(i).setEtatEnum(storie.getEtatEnum());
		}
		// Tri par ordre croissant state
		Comparator<Storie> comparator = Comparator.comparing(Storie::getEtatEnum);
		return stories2.stream().sorted(comparator).collect(Collectors.toList());
	}
	
	// get stories1
	public static List<Storie> getStories1() {
		return stories1;
	}
	
	// get stories2
	public static List<Storie> getStories2() {
		return stories2;
	}
	
	// add storie
	public static Storie add(Storie storie) {
		storie.setIdStories(index);
		stories1.add(storie);
		index++;
		return storie;
	}

}
