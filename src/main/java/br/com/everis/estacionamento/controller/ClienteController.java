package br.com.everis.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.service.ClienteService;
import br.com.everis.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping("/buscartodos")
	public List<Cliente> buscarTodos(){
		return clienteService.buscarTodos();
	}
	
	@GetMapping("/veiculoscliente")
	public List<Veiculo> veiculosCliente(Long idCliente){
		return veiculoService.veiculosCliente(idCliente);
	}
	

}
