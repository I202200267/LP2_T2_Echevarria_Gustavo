package com.examenT2.LP2_T2_Echevarria_Gustavo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:/ordencompra/listado";
	}
}