package br.com.everis.estacionamento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repository;
	
	public Veiculo salvar(Veiculo veiculo) {
		return repository.save(veiculo);
	}
	
	public List<Veiculo> buscarTodos(){
		return (List<Veiculo>) repository.findAll();
	}
	
	public List<Veiculo> veiculosCliente(Long idCliente) {
		List<Veiculo> todosVeiculos = buscarTodos();
		List<Veiculo> veiculosCliente = new ArrayList<Veiculo>();
		for (Veiculo veiculo : todosVeiculos) {
			if (veiculo.getCliente() != null && veiculo.getCliente().getCpf() != null && veiculo.getCliente().getCpf().equals(idCliente)) {
				veiculosCliente.add(veiculo);
			}
		}
		
		return veiculosCliente;
	}

}
