package br.com.futfatec.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.futfatec.api.domain.auth.Credentials;

public interface AuthRepository extends MongoRepository<Credentials, String>{

	public Credentials findByAccessId(String accessId);
}
