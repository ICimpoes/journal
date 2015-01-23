package com.icimpoes.journal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icimpoes.journal.model.AbstractExercise;
import com.icimpoes.journal.repository.ExerciseRepository;
import com.icimpoes.journal.service.ExerciseService;

@Service("exerciseServiceImpl")
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public AbstractExercise findById(Long id) {
		return null;
	}

	@Transactional
	public AbstractExercise saveExercise(AbstractExercise exercise) {
		return exerciseRepository.save(exercise);
	}

	public List<AbstractExercise> findAll() {
		return exerciseRepository.findAll();
	}
	
}
