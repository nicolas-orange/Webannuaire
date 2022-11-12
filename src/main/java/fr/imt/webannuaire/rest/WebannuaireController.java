package fr.imt.webannuaire.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebannuaireController {

	@GetMapping("/webannuaire")
	public String webannuaire(@RequestParam(required = false, defaultValue = "*") String id,
			Model model) {
		model.addAttribute("name", id);
		return "webannuaire";
	}
}
