package com.icimpoes.journal.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icimpoes.journal.model.AbstractExercise;

public interface ExerciseService {

	AbstractExercise findById(Long id);
	
	List<AbstractExercise> findAll();
	
	@Transactional
	AbstractExercise saveExercise(AbstractExercise exercise);
	
}
