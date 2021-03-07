package com.website.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private ResourceLoader resourceLoader;

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

	@GetMapping(value = "/download")
	public void downloadResume(HttpServletResponse response) {
		try {
			final Resource resource = resourceLoader.getResource("classpath:Resume.pdf");
			File file = resource.getFile();
			String fileName = "Resume";
			InputStream inputStream = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");
			IOUtils.copy(inputStream, response.getOutputStream());
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
