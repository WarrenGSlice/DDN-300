package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** * * * * * * * * * * * * * * *
 * DDN-300 Web Design Project
 * Jay Jellum Book Release Site *
 * Created by Warren Peterson,* *
 * * * * * * * * * * * * * * * **/ 

@Controller
@RequestMapping("/aboutme")
public class AboutMeController {

	@GetMapping("")
	public String showAboutMe(Model model){
		model.addAttribute("title", "Release Date for The Cradle of Existence book");
		return "aboutme.html";
		
	}
}