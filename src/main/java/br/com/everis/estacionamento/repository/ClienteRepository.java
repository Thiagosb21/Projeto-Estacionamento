package br.com.everis.estacionamento.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.everis.estacionamento.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	

}
