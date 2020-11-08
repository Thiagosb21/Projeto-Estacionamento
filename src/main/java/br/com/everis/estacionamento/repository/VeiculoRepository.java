package br.com.everis.estacionamento.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.everis.estacionamento.model.Veiculo;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

}
