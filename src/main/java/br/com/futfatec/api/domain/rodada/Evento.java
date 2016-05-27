package br.com.futfatec.api.domain.rodada;

import br.com.futfatec.api.domain.artilharia.Jogador;

public class Evento {
	private TipoEvento tipo;
	private Jogador jogador;

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

}
