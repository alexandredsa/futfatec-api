package br.com.futfatec.api.domain.tabela;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Tabela {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;
	@NotNull
	@Field
	private String nomeCampeonato;
	@Field
	private String leagueId;
	@NotNull
	@Field
	private List<Grupo> grupos;

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeCampeonato() {
		return nomeCampeonato;
	}

	public void setNomeCampeonato(String nomeCampeonato) {
		this.nomeCampeonato = nomeCampeonato;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public Grupo getBySigla(String sigla) {
		for (Grupo grupo : this.grupos) {
			if (grupo.getSigla().equals(sigla))
				return grupo;
		}

		return null;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}
