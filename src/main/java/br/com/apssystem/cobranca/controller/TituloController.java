package br.com.apssystem.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.apssystem.cobranca.model.StatusTitulo;
import br.com.apssystem.cobranca.model.Titulo;
import br.com.apssystem.cobranca.service.TituloService;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private TituloService service;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("titulo/Cadastro");
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(Titulo titulo) {
		service.salvar(titulo);
		return "redirect:/titulos";
	}

	@RequestMapping
	public String pesquisar(Model model) {
		List<Titulo> list = service.listarTodosTitulos();
		model.addAttribute("titulos", list);
		return "Home";
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}

}