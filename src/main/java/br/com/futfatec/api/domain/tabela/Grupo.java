package br.com.futfatec.api.domain.tabela;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document
public class Grupo {
	@NotNull @Field
	private String sigla;
	@NotNull @Field
	private List<Time> times;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	@Document
	public class Time {
		@NotNull @Field
		private String nome;
		@Field
		private int golsPro;
		@Field
		private int golsContra;
		@Field
		private int pontos;
		@Field
		private int jogos;
		@Field
		private int vitorias;

		public Time(String nome) {
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getGolsPro() {
			return golsPro;
		}

		public void setGolsPro(int golsPro) {
			this.golsPro = golsPro;
		}

		public int getGolsContra() {
			return golsContra;
		}

		public void setGolsContra(int golsContra) {
			this.golsContra = golsContra;
		}

		public int getPontos() {
			return pontos;
		}

		public void setPontos(int pontos) {
			this.pontos = pontos;
		}

		public int getJogos() {
			return jogos;
		}

		public void setJogos(int jogos) {
			this.jogos = jogos;
		}

		public int getVitorias() {
			return vitorias;
		}

		public void setVitorias(int vitorias) {
			this.vitorias = vitorias;
		}
	}
}
