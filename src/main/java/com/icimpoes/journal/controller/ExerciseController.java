package com.icimpoes.journal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icimpoes.journal.model.EnglishExercise;
import com.icimpoes.journal.model.AbstractExercise;
import com.icimpoes.journal.service.ExerciseService;

@Controller
@RequestMapping(value = "/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addExercise(Model model){
		model.addAttribute("newExercise", new EnglishExercise());
		return "exercise/editExercise";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveExercise(@ModelAttribute("newExercise") EnglishExercise exercise) {
		exerciseService.saveExercise(exercise);
		return "redirect:view.html";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewExercises() {
		return "exercise/viewExercises";
	}
	
	@RequestMapping(value = "/getAllExercises", method = RequestMethod.GET)
	public @ResponseBody List<AbstractExercise> getAllExercises() {
		return exerciseService.findAll();
	}
}
