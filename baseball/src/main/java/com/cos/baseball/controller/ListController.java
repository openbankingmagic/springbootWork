package com.cos.baseball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.model.Team;
import com.cos.baseball.repository.TeamRepository;



@Controller
public class ListController {
	
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("/")
	public String teams(Model model) {
		List<Team> teams = TeamRepository.findAll();

		model.addAttribute("teams", teams);

		return "/list";
	}

	@GetMapping("/all")
	public @ResponseBody List<Team> all_list() {
		
		List<Team> teams = TeamRepository.findAll();
		
		return teams;
	}
	
}
