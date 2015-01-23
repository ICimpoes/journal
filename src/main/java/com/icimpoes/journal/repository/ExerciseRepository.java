package com.icimpoes.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icimpoes.journal.model.AbstractExercise;


@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<AbstractExercise, Long>{

}
