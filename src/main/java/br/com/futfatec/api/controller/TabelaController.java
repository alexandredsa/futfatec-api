package br.com.futfatec.api.controller;

import java.util.ArrayList;
import java.util.Arrays;

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
	@RequestMapping(value = "/get/{accessId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String accessId) {
		Tabela tabela = tabelaRepository.findOneByAccessId(accessId);

		return new ResponseEntity<Tabela>(tabela, tabela == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/time/save/{idTabela}/{siglaGrupo}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveJogador(@RequestBody Time time, @PathVariable String idTabela,
			@PathVariable String siglaGrupo) {
		Tabela tabela = tabelaRepository.findOne(idTabela);

		if (tabela == null)
			return new ResponseEntity<Tabela>(tabela, HttpStatus.NOT_FOUND);
			
		Grupo grupo = tabela.getBySigla(siglaGrupo);
		if(grupo.getTimes().contains(time))
			grupo.getTimes().set(grupo.getTimes().indexOf(time), time);

		return new ResponseEntity<Tabela>(tabelaRepository.save(tabela), HttpStatus.CREATED);
	}

	@ResponseBody
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Tabela test() {
		Tabela t = new Tabela();
		t.setNomeCampeonato("Amigos do Digão");

		Grupo grupoA = new Grupo();
		grupoA.setSigla("A");
		Time realNair = new Time("Real Nair");
		ArrayList<Time> times = new ArrayList<Time>();
		times.add(realNair);
		grupoA.setTimes(times);
		t.setGrupos(Arrays.asList(grupoA));
		t.setAccessId("wkdj2dnc03iic4");
		return t;
	}

}
