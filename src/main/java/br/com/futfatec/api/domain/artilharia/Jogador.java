package br.com.futfatec.api.domain.artilharia;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;
	@NotNull
	@Field
	private String nome;
	@Field
	private int cartaoAmarelo;
	@Field
	private int cartaoVermelho;
	@Field
	private int gols;
	@NotNull
	@Field
	private String time;

	@Field
	private String idTabela;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Jogador(String nome) {
		this.nome = nome;
	}

	public Jogador() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}

	public void setCartaoAmarelo(int cartaoAmarelo) {
		if(this.cartaoAmarelo < 1)
			this.cartaoAmarelo = cartaoAmarelo;
		else{
			this.cartaoAmarelo = 0;
			this.cartaoVermelho = 1;
		}
	}

	public int getCartaoVermelho() {
		return cartaoVermelho;
	}

	public void setCartaoVermelho(int cartaoVermelho) {
		this.cartaoVermelho = cartaoVermelho;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIdTabela() {
		return idTabela;
	}

	public void setIdTabela(String idTabela) {
		this.idTabela = idTabela;
	}
}
