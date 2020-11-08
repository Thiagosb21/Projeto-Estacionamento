package br.com.everis.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.model.Estacionamento;
import br.com.everis.estacionamento.service.EstacionamentoService;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	@Autowired
	private EstacionamentoService estacionamentoService;
	
	@PostMapping("/salvar")
	public Estacionamento salvar(Estacionamento estacionamento) {
		return estacionamentoService.salvar(estacionamento);
	}
	@GetMapping("/buscartodos")
	public List<Estacionamento> buscarTodos(){
		return estacionamentoService.buscarTodos();
	}
	@GetMapping("/buscarporid")
	public Estacionamento buscarEstacionamentoId(Long id){
		return estacionamentoService.buscarEstacionamentoId(id);
	}
	@GetMapping("/buscarvagasdisponiveis")
	public int vagasDisp(Long id){
		return estacionamentoService.vagasDisp(id);
	}
	

}
