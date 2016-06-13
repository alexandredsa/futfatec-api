package br.com.futfatec.api.controller;

import java.util.List;

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

import br.com.futfatec.api.domain.artilharia.Jogador;
import br.com.futfatec.api.domain.rodada.Evento;
import br.com.futfatec.api.domain.rodada.Partida;
import br.com.futfatec.api.domain.rodada.Rodada;
import br.com.futfatec.api.domain.rodada.Status;
import br.com.futfatec.api.domain.rodada.Time;
import br.com.futfatec.api.domain.rodada.TipoEvento;
import br.com.futfatec.api.repository.JogadorRepository;
import br.com.futfatec.api.repository.RodadaRepository;
import br.com.futfatec.api.repository.TabelaRepository;

@Controller
@RequestMapping("/rodada")
public class RodadaController {

	@Autowired
	private RodadaRepository rodadaRepository;

	@Autowired
	private JogadorRepository jogadorRepository;

	@ResponseBody
	@RequestMapping(value = "/{idTabela}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String idTabela) {
		List<Rodada> rodadas = rodadaRepository.findByIdTabela(idTabela);

		return new ResponseEntity<List<Rodada>>(rodadas, rodadas == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	/**
	 * 
	 * @param idTabela
	 * @param dia
	 *            - Timestamp da data da partida
	 * @return Rodada completa
	 */
	@ResponseBody
	@RequestMapping(value = "/{idTabela}/{dia}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> get(@PathVariable String idTabela, @PathVariable long dia) {
		Rodada rodada = rodadaRepository.findByIdTabelaAndDia(idTabela, dia);
		return new ResponseEntity<Rodada>(rodada, rodada == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value = "/partida/{rodadaId}/{horaInicio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getPartida(@PathVariable String rodadaId, @PathVariable String horaInicio) {
		Rodada rodada = rodadaRepository.findOne(rodadaId);
		Partida p = rodada.getPartida(horaInicio);
		return new ResponseEntity<Partida>(p, p == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
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
	@RequestMapping(value = "/update/{rodadaId}/{horaInicio}/evento", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> saveEvento(@PathVariable String rodadaId, @PathVariable String horaInicio,
			@RequestBody Evento evento) {
		Rodada rodada = rodadaRepository.findOne(rodadaId);

		try {
			Partida partida = rodada.getPartida(horaInicio);
			
			if(partida.getStatus() == Status.FINALIZADO){
				return new ResponseEntity<Rodada>(rodada, HttpStatus.FORBIDDEN);
			}
			
			Jogador jogador = jogadorRepository.findOne(evento.getJogador().getId());
			switch (evento.getTipo()) {
			case GOL:
				jogador.setGols(jogador.getGols() + 1);
				partida.getTime(jogador.getTime()).addGol();
				break;
			case CARTAO_AMARELO:
				jogador.setCartaoAmarelo(jogador.getCartaoAmarelo() + 1);
				break;
			case CARTAO_VERMELHO:
				jogador.setCartaoVermelho(jogador.getCartaoVermelho() + 1);
				break;
			}
			jogadorRepository.save(jogador);

			evento.setJogador(jogador);
			partida.addEvento(evento);
			rodada.setPartida(partida);


			return new ResponseEntity<Rodada>(rodadaRepository.save(rodada), HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<Rodada>(rodada, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
