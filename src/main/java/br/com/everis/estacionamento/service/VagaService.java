package br.com.everis.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Vaga;
import br.com.everis.estacionamento.repository.VagaRepository;

@Service
public class VagaService {
	@Autowired
	private VagaRepository repository;
	
	public Vaga salvar(Vaga vaga) {
		return repository.save(vaga);
	}

	public List<Vaga> buscarTodos(){
		return (List<Vaga>) repository.findAll();
	}
	
	public Vaga buscarVagaId(Long id) {
		return repository.findById(id).get();
	}

}
