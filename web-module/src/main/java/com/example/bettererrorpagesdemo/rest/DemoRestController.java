package com.example.bettererrorpagesdemo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created on April, 2018
 *
 * @author destan
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

	@GetMapping
	ResponseEntity<Map<String, Object>> demo(Principal principal) {

		final Map<String, Object> response = new HashMap<>();
		response.put("demo-attribute", Instant.now());
		response.put("another-attribute", LocalDateTime.now());
		response.put("yet-another-attribute", Calendar.getInstance());
		response.put("user-attribute", new Date());
		response.put("xxx-attribute", UUID.randomUUID().toString());
		response.put("message", "Hello");
		response.put("user", principal.getName());

		return ResponseEntity.ok(response);
	}

}