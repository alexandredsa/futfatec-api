package br.com.futfatec.api.domain.tabela;

import java.util.TreeSet;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Grupo {
	@NotNull
	@Field
	private String sigla;
	@NotNull
	@Field
	private TreeSet<Time> times;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public TreeSet<Time> getTimes() {
		return times;
	}

	public void setTimes(TreeSet<Time> times) {
		this.times = times;
	}

	public void addTime(Time time) {
		this.times.add(time);
	}
}
