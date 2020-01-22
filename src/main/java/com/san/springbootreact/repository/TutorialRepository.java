package com.san.springbootreact.repository;

import org.springframework.data.repository.CrudRepository;

import com.san.springbootreact.model.Tutorial;

public interface TutorialRepository extends CrudRepository<Tutorial, Integer> {

}
