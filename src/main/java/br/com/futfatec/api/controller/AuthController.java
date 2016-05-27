package br.com.futfatec.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.futfatec.api.domain.artilharia.Jogador;
import br.com.futfatec.api.domain.auth.Credentials;
import br.com.futfatec.api.domain.auth.Role;
import br.com.futfatec.api.domain.auth.ValidationStatus;
import br.com.futfatec.api.domain.tabela.Grupo;
import br.com.futfatec.api.domain.tabela.Tabela;
import br.com.futfatec.api.domain.tabela.Time;
import br.com.futfatec.api.repository.AuthRepository;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthRepository authRepository;

	@ResponseBody
	@RequestMapping(value = "/{accessId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String accessId) {
		Credentials credentials = authRepository.findByAccessId(accessId);
		ValidationStatus validationStatus = new ValidationStatus();

		if (credentials == null) {
			validationStatus.setPermission(false);
			return new ResponseEntity<ValidationStatus>(validationStatus, HttpStatus.UNAUTHORIZED);
		}

		validationStatus.setPermission(true);
		validationStatus.setRole(credentials.getRole());
		validationStatus.setLeagueId(credentials.getLeagueId());
		return new ResponseEntity<ValidationStatus>(validationStatus, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Credentials test() {
		Credentials credentials = new Credentials();
		credentials.setAccessId("DIGAO-CHAMPIONS-LEAGUE-2016");
		credentials.setRole(Role.JOGADOR);
		return credentials;
	}

}
