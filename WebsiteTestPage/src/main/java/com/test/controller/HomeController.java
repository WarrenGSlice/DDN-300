package com.test.controller;

/** * * * * * * * * * * * * * * *
 * CST-339 CLC Milestone Project
 * Order Management Application *
 * Created by Warren Peterson,* *
 * Jonathan Levan, Ivan Gudino  *
 * * * * * * * * * * * * * * * **/ 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Home Controller sets domain to root and redirects to index
@Controller
public class HomeController {

    // Show Home page.
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/index")
    public String index() {
    	return "index";
    }
    
	/*
	 * @GetMapping("/releasedate") public String GetReleaseDate(Model model) {
	 * return "releasedate.html"; }
	 * 
	 * @GetMapping("/aboutme") public String GetAboutMe() { return "aboutme.html"; }
	 * 
	 * @GetMapping("/contactus") public String GetContactUs() { return
	 * "contactus.html"; }
	 * 
	 * @GetMapping("/content") public String Content() { return "content.html"; }
	 * 
	 * @GetMapping("/otherworks") public String GetOtherWorks() { return
	 * "otherworks.html"; }
	 * 
	 * @GetMapping("/preorder") public String GetPreOrder() { return
	 * "preorder.html"; }
	 */

}