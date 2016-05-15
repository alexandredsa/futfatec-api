package br.com.futfatec.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.futfatec.api.domain.artilharia.Jogador;

public interface JogadorRepository extends MongoRepository<Jogador, String> {
	public List<Jogador> findByIdTabelaOrderByGolsDesc(String idTabela, Pageable pageable);
}
