package com.example.bettererrorpagesdemo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on April, 2018
 *
 * @author destan
 */
@Controller
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

	private final SampleServiceFromModule sampleServiceFromModule;

	@GetMapping
	String demo() {
		throw new RuntimeException("Example exception");
	}

	@GetMapping("/broken-template-with-syntax-error")
	String syntaxError() {
		return "products/syntaxError";
	}

	@GetMapping("/broken-template-with-missing-property")
	String missingProperty() {
		return "products/missingProperty";
	}

	@GetMapping("/missing-template")
	String missing() {
		return "fancy-name";
	}

	@GetMapping("/error-from-another-module")
	String fromAnotherModule() {
		sampleServiceFromModule.someMethod(null);
		return "fancy-name";
	}

	@GetMapping("/error-from-layout")
	String errorFromLayout() {
		return "products/contentWithLayout";
	}
}