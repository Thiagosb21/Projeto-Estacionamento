package br.com.everis.estacionamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estacionamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int qtdvagas;
	private String nomeEstacionamento;
	private String endereco;
	private String telefoneEstacionamento;
	@OneToMany (mappedBy = "estacionamento")
	private List<Vaga> vagas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQtdvagas() {
		return qtdvagas;
	}

	public void setQtdvagas(int qtdvagas) {
		this.qtdvagas = qtdvagas;
	}

	public String getNomeEstacionamento() {
		return nomeEstacionamento;
	}

	public void setNomeEstacionamento(String nomeEstacionamento) {
		this.nomeEstacionamento = nomeEstacionamento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefoneEstacionamento() {
		return telefoneEstacionamento;
	}

	public void setTelefoneEstacionamento(String telefoneEstacionamento) {
		this.telefoneEstacionamento = telefoneEstacionamento;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
	

}
