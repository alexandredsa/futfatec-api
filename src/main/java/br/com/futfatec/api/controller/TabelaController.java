package br.com.futfatec.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.futfatec.api.domain.tabela.Grupo;
import br.com.futfatec.api.domain.tabela.Tabela;
import br.com.futfatec.api.domain.tabela.Time;
import br.com.futfatec.api.repository.TabelaRepository;

@RequestMapping("/tabela")
@Controller
public class TabelaController {
	@Autowired
	private TabelaRepository tabelaRepository;

	@ResponseBody
	@RequestMapping(value = "/{leagueId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String leagueId) {
		Tabela tabela = tabelaRepository.findOneByLeagueId(leagueId);

		return new ResponseEntity<Tabela>(tabela, tabela == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/time/save/{idTabela}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> save(@RequestBody Time time, @PathVariable String idTabela) {
		Tabela tabela = tabelaRepository.findOne(idTabela);

		if (tabela == null)
			return new ResponseEntity<Tabela>(tabela, HttpStatus.NOT_FOUND);

		Grupo grupo = tabela.getByTime(time);
		grupo.addTime(time);

		return new ResponseEntity<Tabela>(tabelaRepository.save(tabela), HttpStatus.CREATED);
	}
}
