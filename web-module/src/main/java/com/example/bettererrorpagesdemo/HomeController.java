package com.example.bettererrorpagesdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created on April, 2018
 *
 * @author destan
 */
@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	String home(HttpSession session) {

		// populating sample session attributes
		session.setAttribute("demo-attribute", Instant.now());
		session.setAttribute("another-attribute", LocalDateTime.now());
		session.setAttribute("yet-another-attribute", Calendar.getInstance());
		session.setAttribute("user-attribute", new Date());
		session.setAttribute("xxx-attribute", UUID.randomUUID().toString());

		return "index";
	}

}