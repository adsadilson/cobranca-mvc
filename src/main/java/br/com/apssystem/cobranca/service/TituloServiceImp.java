package br.com.apssystem.cobranca.service;

import org.springframework.stereotype.Service;

import br.com.apssystem.cobranca.model.Titulo;
import br.com.apssystem.cobranca.repository.TituloRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TituloServiceImp implements TituloService {

	private TituloRepository tituloRepository;

	@Override
	public void salvar(Titulo titulo) {
		tituloRepository.save(titulo);
	}

}
