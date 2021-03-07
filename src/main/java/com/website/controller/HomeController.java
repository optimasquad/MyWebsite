package com.website.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	private static final int BUFFER_SIZE = 4096;

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
	public String downloadResume(HttpServletResponse response) {
		try {
			LOGGER.info("Clicking on download link");
			final Resource resource = resourceLoader.getResource("classpath:Resume.pdf");
			File downloadFile = resource.getFile();
			LOGGER.info("finding download file" + downloadFile);
			FileInputStream inputStream = new FileInputStream(downloadFile);

			response.setContentType("application/force-download");
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			OutputStream outStream = response.getOutputStream();

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();

		} catch (Exception e) {
			LOGGER.error("error occured" + e);
			e.printStackTrace();
		}
		return "Resume/Resume";
	}

}
