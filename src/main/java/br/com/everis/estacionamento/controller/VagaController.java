package br.com.everis.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Vaga;
import br.com.everis.estacionamento.service.VagaService;

@RestController
@RequestMapping("/vaga")
public class VagaController {
	@Autowired
	private VagaService vagaService;

	@GetMapping("/buscartodos")
	public List<Vaga> buscarTodos(){
		return vagaService.buscarTodos();
	}

	@GetMapping("/buscarporid")
	public Vaga buscarVagaId(Long id) {
		return vagaService.buscarVagaId(id);
	}


}
