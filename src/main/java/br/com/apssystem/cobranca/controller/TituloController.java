package br.com.apssystem.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.apssystem.cobranca.model.Titulo;
import br.com.apssystem.cobranca.service.TituloService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/titulos")
@AllArgsConstructor
public class TituloController {

	private TituloService service;

	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		
		service.salvar(titulo);

		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Título salvo com sucesso!");

		return mv;
	}

}