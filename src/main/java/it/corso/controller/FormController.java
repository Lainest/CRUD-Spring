package it.corso.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/form")
public class FormController {
	@Autowired
	ProdottoService prodottoService;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam(name = "id", required = false) Integer id) {
		Prodotto prodotto = id == null ? new Prodotto() : prodottoService.getProdottoById(id);
		model.addAttribute("prodotto", prodotto);
		return "form";
	}
	
	@PostMapping
	public String registraProdotto(@Valid @ModelAttribute("prodotto") Prodotto prodotto,
			BindingResult result) {
		if(result.hasErrors())
			return "form";
		prodottoService.registraProdotto(prodotto);
		return "redirect:/";
	}
}
