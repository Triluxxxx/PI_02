package web.cont.sacr.upeu.Aplicacion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/aplicacion")
	public String inicio() {
		return "home";
	}
	
}
