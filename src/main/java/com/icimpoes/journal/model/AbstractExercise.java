package com.icimpoes.journal.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "exercise")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "exercise_type", length = 15)
public abstract class AbstractExercise {
	
	@Id
	@GeneratedValue(generator = "exerciseSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "exerciseSeq", initialValue = 1, allocationSize = 1, sequenceName = "exercise_seq")
	@JsonIgnore
	private Long id;
	
	@Column(name = "name", length = 20, nullable = false, unique = true)
	private String name;
	
	@Column(name = "description")
	@Type(type = "text")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
