package com.aakashkumar.microservices.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/")
	public String home() {
		return new StringBuilder("Welcome to Pricing Service, Today's time is ").append(new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a").format(new Date())).toString();
	}
}
