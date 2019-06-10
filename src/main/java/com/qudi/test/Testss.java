package com.qudi.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Testss {
	
	
		@RequestMapping("/my")
		public String test() {
			return "BUILD SUCCESS";
		}

}
