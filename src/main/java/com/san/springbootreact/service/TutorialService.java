package com.san.springbootreact.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.springbootreact.model.Tutorial;
import com.san.springbootreact.repository.TutorialRepository;

@Service
public class TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;

	public Iterable<Tutorial> findAll() {
		return tutorialRepository.findAll();
	}

	public Optional<Tutorial> findById(Integer id) {
		return tutorialRepository.findById(id);
	}

	public Tutorial save(Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	public void deleteById(Integer id) {
		tutorialRepository.deleteById(id);
	}
}
