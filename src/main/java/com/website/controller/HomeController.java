package com.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/home")
	public String index() {
		return "index/index";
	}

	@GetMapping(value = "/")
	public String home() {
		return "index/index";
	}

	@GetMapping(value = "/about")
	public String about() {
		return "About/About";
	}

	@GetMapping(value = "/blogs")
	public String blogs() {

		return "Blogs/Blogs";
	}

	@GetMapping(value = "/contact")
	public String contact() {
		return "Contact/Contact";
	}

	@GetMapping(value = "/portfolio")
	public String portfolio() {
		return "Portfolio/Portfolio";
	}

	@GetMapping(value = "/resume")
	public String resume() {
		return "Resume/Resume";
	}

}
