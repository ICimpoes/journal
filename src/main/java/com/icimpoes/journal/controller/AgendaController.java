package com.icimpoes.journal.controller;

import java.time.DayOfWeek;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icimpoes.journal.model.Agenda;
import com.icimpoes.journal.service.AgendaService;
import com.icimpoes.journal.util.Messages;

@Controller("agendaController")
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	AgendaService agendaService;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addAgenda(Model model){
		model.addAttribute("newAgenda", new Agenda());
		return "agenda/editAgenda";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAgenda(@ModelAttribute("newAgenda") Agenda agenda) {
		agendaService.saveAgenda(agenda);
		return "redirect:view.html";
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAgenda() {
		return "agenda/viewAgendas";
	}
	
	@RequestMapping(value = "/getAllAgendas", method = RequestMethod.GET)
	public @ResponseBody List<Agenda> getAllAgendas() {
		return agendaService.findAll();
	}
	
	@RequestMapping(value = "/daysOfWeek", method = RequestMethod.GET)
	public @ResponseBody DayOfWeek[] getDaysOfWeek() {
		return DayOfWeek.values();
	}
	
	@RequestMapping(value = "/deleteAgenda", method = RequestMethod.POST)
	public @ResponseBody Messages deleteAgenda(@RequestBody Long agendaId) {
		agendaService.deleteAgenda(agendaId);
		return Messages.SUCCESS;
	}
	
	
	
	
}
