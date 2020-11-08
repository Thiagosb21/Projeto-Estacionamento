package br.com.everis.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	
	public Cliente salvar(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public List<Cliente> buscarTodos(){
		return (List<Cliente>) repository.findAll();
	}
	
}
