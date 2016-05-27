package br.com.futfatec.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.futfatec.api.domain.tabela.Tabela;

public interface TabelaRepository extends MongoRepository<Tabela, String> {
	public Tabela findOneByLeagueId(String leagueId);
}
