package br.com.everis.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.estacionamento.service.GerenciamentoService;

@RestController
@RequestMapping("/gerenciamento")
public class GerenciamentoController {
	@Autowired
	private GerenciamentoService gerenciamentoService;
	
	@PostMapping("/registrarentrada")
	public String registrarEntrada(Long cpf, String email, String nome, String telefone,
			String placa, String cor, String modelo, Long idEstacionamento) {
		return gerenciamentoService.registrarEntrada(cpf, email, nome, telefone, placa, cor, modelo, idEstacionamento);
	}
	
	@PostMapping("/registrarsaida")
	public String registrarSaida (Long id) {
		return gerenciamentoService.registrarSaida(id);
	}
}
