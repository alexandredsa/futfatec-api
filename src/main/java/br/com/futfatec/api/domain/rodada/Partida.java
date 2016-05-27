package br.com.futfatec.api.domain.rodada;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

public class Partida implements Comparable<Partida>{
	@NotNull
	private Time timeA;
	@NotNull
	private Time timeB;
	@NotNull
	private String horaInicio;
	private List<Evento> eventos;

	public Time getTimeA() {
		return timeA;
	}

	public void setTimeA(Time timeA) {
		this.timeA = timeA;
	}

	public Time getTimeB() {
		return timeB;
	}

	public void setTimeB(Time timeB) {
		this.timeB = timeB;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Partida))
			return false;

		Partida p = (Partida) obj;

		if (!(p.getHoraInicio().equals(this.horaInicio)))
			return false;

		if (!(p.getTimeA().equals(this.timeA)))
			return false;

		if (!(p.getTimeB().equals(this.timeB)))
			return false;

		return true;
	}

	@Override
	public int compareTo(Partida p) {
		return p.getHoraInicio().compareTo(this.horaInicio);
	}

}
