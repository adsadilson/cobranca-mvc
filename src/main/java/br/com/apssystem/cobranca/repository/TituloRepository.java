package br.com.apssystem.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apssystem.cobranca.model.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {

}
