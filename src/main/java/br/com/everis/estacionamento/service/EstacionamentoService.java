package br.com.everis.estacionamento.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.estacionamento.model.Estacionamento;
import br.com.everis.estacionamento.model.Vaga;
import br.com.everis.estacionamento.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	@Autowired
	private EstacionamentoRepository repository;

	public Estacionamento salvar(Estacionamento estacionamento) {
		return repository.save(estacionamento);
	}

	public List<Estacionamento> buscarTodos() {
		return (List<Estacionamento>) repository.findAll();
	}

	public Estacionamento buscarEstacionamentoId(Long id) {
		return repository.findById(id).get();
	}

	public int vagasDisp(Long idEstacionamento) {
		Estacionamento estacionamento = buscarEstacionamentoId(idEstacionamento);
		List<Vaga> vagaOcupada = new ArrayList<Vaga>();
		for (Vaga vaga : estacionamento.getVagas()) {
			if (vaga.getSaida() == null) {
				vagaOcupada.add(vaga);
			}
		}
		return estacionamento.getQtdvagas() - vagaOcupada.size();

	}

}
