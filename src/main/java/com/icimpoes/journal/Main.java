package com.icimpoes.journal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.icimpoes.journal.model.AbstractExercise;
import com.icimpoes.journal.model.Agenda;
import com.icimpoes.journal.model.EnglishExercise;
import com.icimpoes.journal.repository.AgendaRepository;
import com.icimpoes.journal.repository.ExerciseRepository;


public class Main {
	
	@Autowired
	static ExerciseRepository exerciseRepository;
	
	@Autowired
	static AgendaRepository agendaRepository;
	
	public static void main(String[] args) {
		AbstractExercise exercise1 = new EnglishExercise();
		exercise1.setName("first");
		exercise1.setDescription("sadasdasdadasdaasasfas");
		AbstractExercise exercise2 = new EnglishExercise();
		exercise2.setName("second");
		List<AbstractExercise> exercises = new ArrayList<AbstractExercise>();
		exercises.add(exercise1);
		exercises.add(exercise2);
		Agenda agenda = new Agenda();
		agenda.setExercises(exercises);
		exerciseRepository.save(exercise2);
		agendaRepository.save(agenda); 
	}
}
