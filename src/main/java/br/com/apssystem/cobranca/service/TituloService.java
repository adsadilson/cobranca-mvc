package br.com.apssystem.cobranca.service;

import java.util.List;

import br.com.apssystem.cobranca.model.Titulo;

public interface TituloService {

	public void salvar(Titulo titulo);
	
	public List<Titulo> listarTodosTitulos();
}
