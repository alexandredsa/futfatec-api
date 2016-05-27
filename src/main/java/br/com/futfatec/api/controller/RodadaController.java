package br.com.futfatec.api.controller;

import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;

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
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.futfatec.api.domain.rodada.Etapa;
import br.com.futfatec.api.domain.rodada.Partida;
import br.com.futfatec.api.domain.rodada.Rodada;
import br.com.futfatec.api.domain.rodada.Time;
import br.com.futfatec.api.repository.RodadaRepository;

@Controller
@RequestMapping("/rodada")
public class RodadaController {

	@Autowired
	private RodadaRepository rodadaRepository;

	@ResponseBody
	@RequestMapping(value = "/{idTabela}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String idTabela) {
		List<Rodada> rodadas = rodadaRepository.findByIdTabela(idTabela);

		return new ResponseEntity<List<Rodada>>(rodadas, rodadas == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	/**
	 * 
	 * @param idTabela
	 * @param dia - Timestamp da data da partida
	 * @return Rodada completa
	 */
	@ResponseBody
	@RequestMapping(value = "/{idTabela}/{dia}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String idTabela, @PathVariable long dia) {
		Rodada rodada = rodadaRepository.findByIdTabelaAndDia(idTabela, dia);
		return new ResponseEntity<Rodada>(rodada, rodada == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rodada save(@PathVariable String id, @RequestBody Partida partida) {
		Rodada rodada = rodadaRepository.findOne(id);
		rodada.getPartidas().remove(partida);
		rodada.setPartida(partida);
		return rodadaRepository.save(rodada);
	}

	@ResponseBody
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	public Rodada test() {
		Partida partida = new Partida();
		partida.setHoraInicio("12:00");
		Time timeA = new Time();
		timeA.setNome("Confrades FC");
		timeA.setGols(0);
		Time timeB = new Time();
		timeB.setNome("Toisss");
		timeB.setGols(0);
		partida.setTimeA(timeA);
		partida.setTimeB(timeB);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 4);

		Rodada rodada = new Rodada();
		rodada.setDia(cal.getTime().getTime());
		rodada.setEtapa(Etapa.GRUPO);
		
		TreeSet<Partida> t = new TreeSet<Partida>();
		t.add(partida);
		rodada.setPartidas(t);
		return rodada;
	}

}
