package br.com.futfatec.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.futfatec.api.domain.rodada.Rodada;

public interface RodadaRepository extends MongoRepository<Rodada, String> {

	public List<Rodada> findByIdTabela(String idTabela);
	
	public Rodada findByIdTabelaAndDia(String idTabela, long dia);

}
