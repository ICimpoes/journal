package com.icimpoes.journal.service;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icimpoes.journal.model.AbstractExercise;
import com.icimpoes.journal.model.Agenda;

public interface AgendaService {

	@Transactional
	void addExerciseToAgenda(AbstractExercise exercise);

	Agenda findById(Long id);

	Agenda findByDayOfWeek(DayOfWeek dayOfWeek);

	List<Agenda> findAll();
	
	@Transactional
	Agenda saveAgenda(Agenda agenda);
	
	@Transactional
	void deleteAgenda(Long agendaId);
	
}
