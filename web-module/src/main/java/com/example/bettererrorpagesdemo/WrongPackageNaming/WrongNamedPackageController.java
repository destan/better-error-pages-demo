package com.example.bettererrorpagesdemo.WrongPackageNaming;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April, 2018
 *
 * @author destan
 */
@Controller
@RequestMapping("/wrong-naming")
public class WrongNamedPackageController {

	@GetMapping
	String demo() {
		throw new RuntimeException("Example exception");
	}

}