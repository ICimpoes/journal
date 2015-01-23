package com.icimpoes.journal.model;

import java.time.DayOfWeek;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(generator = "agendaSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "agendaSeq", initialValue = 1, allocationSize = 1, sequenceName = "agenda_seq")
	private Long id;

	@Column(name = "week_day", unique = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;

	@ManyToMany
	@JoinTable(name = "agenda_to_exercise", joinColumns = { @JoinColumn(name = "agenda_id") }, inverseJoinColumns = { @JoinColumn(name = "exercise_id") }, uniqueConstraints = @UniqueConstraint(columnNames = {
			"agenda_id", "exercise_id" }))
	private List<AbstractExercise> exercises;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<AbstractExercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<AbstractExercise> exercises) {
		this.exercises = exercises;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

}
