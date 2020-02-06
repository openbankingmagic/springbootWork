package com.cos.baseball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

	// localhost:8080/home/
	// localhost:8080/home
	@GetMapping({ "", "/" })
	public String Home() {
		return "list";
	}

}
