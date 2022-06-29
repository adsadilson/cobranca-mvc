package br.com.apssystem.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apssystem.cobranca.model.Titulo;
import br.com.apssystem.cobranca.repository.TituloRepository;

@Service
public class TituloServiceImp implements TituloService {

	@Autowired
	private TituloRepository tituloRepository;

	@Override
	public void salvar(Titulo titulo) {
		tituloRepository.save(titulo);
	}

	@Override
	public List<Titulo> listarTodosTitulos() {
		return tituloRepository.findAll();
	}

}
