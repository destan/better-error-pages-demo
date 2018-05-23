package com.example.bettererrorpagesdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April, 2018
 *
 * @author destan
 */
@Controller
@RequestMapping("/non-public")
public class NonPublicController {

	@GetMapping
	String demo() {
		DemoClass.error();
		return "";
	}
}

class DemoClass {
	static void error() {
		try {
			DemoClass2.error();
		}
		catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}

class DemoClass2 {
	static void error() {
		throw new RuntimeException("Demo error here.");
	}
}