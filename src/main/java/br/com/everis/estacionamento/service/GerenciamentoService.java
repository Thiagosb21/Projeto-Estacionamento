package br.com.everis.estacionamento.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Cliente;
import br.com.everis.estacionamento.model.Estacionamento;
import br.com.everis.estacionamento.model.Vaga;
import br.com.everis.estacionamento.model.Veiculo;

@Service
public class GerenciamentoService {
	@Autowired
	ClienteService clienteService = new ClienteService();
	@Autowired
	VeiculoService veiculoService = new VeiculoService();
	@Autowired
	VagaService vagaService = new VagaService();
	@Autowired
	EstacionamentoService estacionamentoService = new EstacionamentoService();

	public String registrarEntrada(Long cpf, String email, String nome, String telefone, String placa, String cor,
			String modelo, Long idEstacionamento) {

		Estacionamento estacionamento = estacionamentoService.buscarEstacionamentoId(idEstacionamento);
		Cliente cliente = new Cliente();
		Veiculo veiculo = new Veiculo();
		Vaga vaga = new Vaga();

		try {
			if (estacionamentoService.vagasDisp(idEstacionamento) > 0) {

				cliente.setCpf(cpf);
				cliente.setEmail(email);
				cliente.setNome(nome);
				cliente.setTelefone(telefone);

				veiculo.setPlaca(placa);
				veiculo.setCor(cor);
				veiculo.setModelo(modelo);
				veiculo.setCliente(cliente);

				vaga.setVeiculo(veiculo);
				vaga.setEstacionamento(estacionamento);
				vaga.setEntrada(Calendar.getInstance().getTime());

			} else {
				throw new Exception("Estacionamento lotado");
			}

			clienteService.salvar(cliente);
			veiculoService.salvar(veiculo);
			vagaService.salvar(vaga);
		} catch (NumberFormatException e) {
			return ("CPF invalido");
		} catch (Exception e) {
			return ("Erro: " + e.getMessage());
		}

		return "Entrada de veiculo registrada com sucesso.";
	}

	public String registrarSaida(Long id) {
		Vaga vaga = vagaService.buscarVagaId(id);
		vaga.setSaida(Calendar.getInstance().getTime());
		vagaService.salvar(vaga);
		return "Saida registrada";
	}

}
