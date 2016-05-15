package br.com.futfatec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.futfatec.api.domain.artilharia.Jogador;
import br.com.futfatec.api.repository.JogadorRepository;

@RequestMapping("/artilharia")
@Controller
public class ArtilhariaController {
	@Autowired
	private JogadorRepository jogadorRepository;

	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "/jogador/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Jogador saveJogador(@RequestBody Jogador jogador) {
		return jogadorRepository.save(jogador);
	}

	@ResponseBody
	@RequestMapping(value = "/get/{idTabela}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Jogador> get(@PathVariable String idTabela) {
		return jogadorRepository.findByIdTabelaOrderByGolsDesc(idTabela, new PageRequest(0, 2));
	}

}
