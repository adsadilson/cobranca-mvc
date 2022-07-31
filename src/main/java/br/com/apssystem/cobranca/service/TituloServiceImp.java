package br.com.apssystem.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apssystem.cobranca.model.Titulo;
import br.com.apssystem.cobranca.repository.TituloRepository;

@Service
public class TituloServiceImp implements TituloService {

	@Autowired
	private TituloRepository repository;

	@Override
	public void salvar(Titulo titulo) {
		repository.save(titulo);
	}

	@Override
	public List<Titulo> listarTodosTitulos() {
		return repository.findAll();
	}

	@Override
	public void excluir(Long id) {
		repository.deleteById(id);
	}

}
