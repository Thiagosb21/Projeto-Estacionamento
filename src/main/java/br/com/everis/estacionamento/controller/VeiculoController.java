package br.com.everis.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Veiculo;
import br.com.everis.estacionamento.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	@Autowired
	private VeiculoService veiculoService;
	 
	@GetMapping("/buscartodos")
	public List<Veiculo> buscarTodos(){
		return veiculoService.buscarTodos();
	}

}
