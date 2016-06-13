package br.com.futfatec.api.domain.rodada;

import java.util.ArrayList;
import java.util.TreeSet;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Rodada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;
	@NotNull
	@Field
	private Etapa etapa;
	@NotNull
	@Field
	private TreeSet<Partida> partidas;
	/**
	 * Timestamp - Dia do jogo
	 */
	@NotNull
	@Field
	private long dia;

	@Field
	private String idTabela;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public TreeSet<Partida> getPartidas() {
		return partidas;
	}

	public Partida getPartida(String horaInicio) {
		for (Partida partida : this.partidas) {
			if (partida.getHoraInicio().equals(horaInicio))
				return partida;
		}

		return null;
	}

	public void setPartidas(TreeSet<Partida> partidas) {
		this.partidas = partidas;
	}

	public long getDia() {
		return dia;
	}

	public void setDia(long dia) {
		this.dia = dia;
	}

	public String getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(String idTabela) {
		this.idTabela = idTabela;
	}

	public void setPartida(Partida partida) {
		if (partidas == null)
			return;

		partidas.add(partida);
	}

}
