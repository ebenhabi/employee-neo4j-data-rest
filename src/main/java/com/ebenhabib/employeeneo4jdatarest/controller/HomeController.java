package com.ebenhabib.employeeneo4jdatarest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(ModelMap modal) {
		modal.addAttribute("title", "Management Employees");
		return "index";
	}
	
	@RequestMapping("/partials/{page}")
	public String partialHandler(@PathVariable("page") final String page) {
		return page;
	}
}
