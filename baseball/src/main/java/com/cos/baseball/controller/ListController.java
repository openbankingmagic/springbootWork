package com.cos.baseball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;



@Controller
public class ListController {
	
//	@Autowired
//	private TeamRepository teamRepository;
//
//	@GetMapping("/")
//	public String teams(Model model) {
//		List<Team> teams = teamRepository.findAll();
//
//		model.addAttribute("teams", teams);
//
//		return "list";
//	}
	
	
	@Autowired
	TeamRepository teamRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Team> teams = teamRepository.findAll();
		model.addAttribute("teams", teams);
		
		return "list";
	}
	
	

//	@GetMapping("/all")
//	public @ResponseBody List<Team> all_list() {
//		
//		List<Team> teams = teamRepository.findAll();
//		
//		return teams;
//	}
	
}
