package com.icimpoes.journal.repository;

import java.time.DayOfWeek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icimpoes.journal.model.Agenda;

@Repository("agendaRepository")
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	
	Agenda findById(Long id);
	
	Agenda findByDayOfWeek(DayOfWeek dayOfWeek);
	
}