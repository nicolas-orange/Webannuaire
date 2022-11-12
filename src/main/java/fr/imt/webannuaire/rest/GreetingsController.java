package fr.imt.webannuaire.rest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

	@GetMapping("/greetings")
	public String greeting(@RequestParam(required = false, defaultValue = "Papa") String name, Model model) {
		model.addAttribute("name", name);
		return "greetings";
	}
}
