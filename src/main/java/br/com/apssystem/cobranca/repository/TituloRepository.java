package br.com.apssystem.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apssystem.cobranca.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long> {

}
