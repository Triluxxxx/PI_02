package app.cwge.upeu.lm.Upeu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
	public String inicio() {
		return "Hola :0";
	}
}
