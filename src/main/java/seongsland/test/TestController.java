package seongsland.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("/get")
	public String get(Model model) {
		String testValue	= testService.getTest("test1");
		
		model.addAttribute("testValue", testValue);
		model.addAttribute("hello", "seongsland!");
		return "test/get";
	}
	
	@GetMapping("/set")
	public String set(Model model) {
		String testValue	= testService.setTest();
		model.addAttribute("testValue", testValue);
		return "test/set";
	}
}