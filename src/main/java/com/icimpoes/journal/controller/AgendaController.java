package com.icimpoes.journal.controller;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.icimpoes.journal.model.Agenda;
import com.icimpoes.journal.service.AgendaService;
import com.icimpoes.journal.util.Messages;

@Controller("agendaController")
@RequestMapping("/agenda")
@SessionAttributes({"selectedAgenda"})
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
	
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public String viewAllAgendas() {
		return "agenda/viewAllAgendas";
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
	
	@RequestMapping(value = "/view")
	public String viewAgenda(Model model){
		if (!model.containsAttribute("selectedAgenda")) {
			Agenda agenda = agendaService.findByDayOfWeek(getTodaysWeekDay());
			model.addAttribute("selectedAgenda", agenda);
		}
		return "agenda/viewAgenda";
	}

	//Return today's Day Of Week
	private DayOfWeek getTodaysWeekDay() {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new Date());
		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		dayNum = dayNum > 1 ? dayNum - 1 : 7;
		DayOfWeek day = DayOfWeek.of(dayNum);
		return day;
	}
}
