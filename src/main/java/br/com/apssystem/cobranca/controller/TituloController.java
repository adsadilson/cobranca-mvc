package br.com.apssystem.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	private static final String CADASTRO_VIEW = "CadastroTitulo";

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Titulo());
		return mv;
	}

	@PostMapping()
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		if (errors.hasErrors()) {
			return mv;
		}
		service.salvar(titulo);
		mv.addObject("mensagem", "Título salvo com sucesso!");
		return mv;
	}

	@GetMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Titulo titulo) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}

	@GetMapping
	public String pesquisar(Model model) {
		List<Titulo> list = service.listarTodosTitulos();
		model.addAttribute("titulos", list);
		return "PesquisaTitulos";
	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}

}