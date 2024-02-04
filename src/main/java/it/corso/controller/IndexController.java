package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	ProdottoService prodottoService;
	
	@GetMapping
	public String getPage(Model model) {
		model.addAttribute("prodotti", prodottoService.getProdotti());
		return "index";
	}
	
	@GetMapping("/cancella")
	public String cancellaProdotto(@RequestParam("id") int id) {
		Prodotto prodotto = prodottoService.getProdottoById(id);
		prodottoService.cancellaProdotto(prodotto);
		return "redirect:/";
	}
}
