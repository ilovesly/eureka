package zxy.demo.springboot.boot_feature.web;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	private Logger logger = Logger.getLogger(WelcomeController.class);

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		model.put("time", new Date());
		model.put("message", this.message);
		System.out.println("welcome page");
		return "welcome";
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

}