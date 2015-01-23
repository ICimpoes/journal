package com.icimpoes.journal.service.impl;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icimpoes.journal.model.AbstractExercise;
import com.icimpoes.journal.model.Agenda;
import com.icimpoes.journal.repository.AgendaRepository;
import com.icimpoes.journal.service.AgendaService;

@Service("agendaService")
public class AgendaServiceImpl implements AgendaService {

	private Agenda agenda;

	@Autowired
	private AgendaRepository agendaRepository;

	public AgendaServiceImpl() {

	}

	public AgendaServiceImpl(Agenda agenda) {
		this.agenda = agenda;
	}

	public void addExerciseToAgenda(AbstractExercise exercise) {
		agenda.getExercises().add(exercise);
		agendaRepository.save(agenda);
	}

	public Agenda findById(Long id) {
		return agendaRepository.findById(id);
	}

	public Agenda findByDayOfWeek(DayOfWeek dayOfWeek) {
		return agendaRepository.findByDayOfWeek(dayOfWeek);
	}

	public List<Agenda> findAll() {
		return agendaRepository.findAll();
	}
	
	public Agenda saveAgenda(Agenda newAgenda) {
		agenda = agendaRepository.save(newAgenda);
		return agenda;
	}
	
	public void deleteAgenda(Long agendaId){
		// TODO Add some logic here
		agendaRepository.delete(agendaId);
	}
	
	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}


}
