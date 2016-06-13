package br.com.futfatec.api.domain.rodada;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Partida implements Comparable<Partida> {
	@NotNull
	private Time timeA;
	@NotNull
	private Time timeB;
	@NotNull
	private String horaInicio;
	private List<Evento> eventos;
	private Status status;

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

	public Time getTime(String nome) {
		if (getTimeA().getNome().equalsIgnoreCase(nome))
			return this.getTimeA();
		
		
		if (getTimeB().getNome().equalsIgnoreCase(nome))
			return this.getTimeB();
		
		return null;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public List<Evento> getEventos() {
		if (eventos == null)
			eventos = new ArrayList<Evento>();

		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public void addEvento(Evento evento) {
		this.eventos = getEventos();
		this.eventos.add(evento);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
