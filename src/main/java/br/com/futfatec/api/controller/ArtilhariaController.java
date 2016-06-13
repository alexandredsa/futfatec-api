package br.com.futfatec.api.controller;

import java.util.ArrayList;
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

	/**
	 * 
	 * @param idTabela
	 *            ID da Tabela da Competição
	 * @return Retorna os 15 primeiros jogadores com mais gols na competição.
	 */
	@ResponseBody
	@RequestMapping(value = "/{idTabela}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Jogador> get(@PathVariable String idTabela) {
		return jogadorRepository.findByIdTabelaAndGolsGreaterThanOrderByGolsDesc(idTabela, 0, new PageRequest(0, 15));
	}

	@ResponseBody
	@RequestMapping(value = "/elenco/{time}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Jogador> getElenco(@PathVariable String time) {
		return jogadorRepository.findByTime(time);
	}

	@ResponseBody
	@RequestMapping(value = "/carga", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Jogador> migrate() {
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		

		jogadores.add(new Jogador("Vinicius Silva", "Toisss"));
		jogadores.add(new Jogador("Fabio Magalhães", "Toisss"));
		jogadores.add(new Jogador("Victor Manoel", "Toisss"));
		jogadores.add(new Jogador("Bruno Henrique", "Toisss"));
		jogadores.add(new Jogador("Lucas Lira", "Toisss"));
		jogadores.add(new Jogador("Guilherme Nalessio", "Toisss"));
		jogadores.add(new Jogador("Ivan Batista", "Toisss"));
		jogadores.add(new Jogador("Guilherme Vorpagel", "Toisss"));
		jogadores.add(new Jogador("Vinicius Vorpagel", "Toisss"));
		jogadores.add(new Jogador("João Vitor", "Toisss"));

		jogadores.add(new Jogador("Alejandro", "R7"));
		jogadores.add(new Jogador("Victor Diniz", "R7"));
		jogadores.add(new Jogador("Artur Guedes", "R7"));
		jogadores.add(new Jogador("João Vitor Bezerra", "R7"));
		jogadores.add(new Jogador("João Vitor Leandro", "R7"));
		jogadores.add(new Jogador("Pedro", "R7"));
		jogadores.add(new Jogador("Luiz Fernando", "R7"));
		jogadores.add(new Jogador("Lucas Correa", "R7"));
		jogadores.add(new Jogador("Lucas Sobral", "R7"));
		jogadores.add(new Jogador("Thauã", "R7"));

		jogadores.add(new Jogador("Alexandre Alves", "Real Nair"));
		jogadores.add(new Jogador("Lucas Gallani", "Real Nair"));
		jogadores.add(new Jogador("Lucas Monteiro", "Real Nair"));
		jogadores.add(new Jogador("Luiz Felipe", "Real Nair"));
		jogadores.add(new Jogador("Vitor Caetano", "Real Nair"));
		jogadores.add(new Jogador("Mateus G. Silva", "Real Nair"));
		jogadores.add(new Jogador("Matheus Gobo", "Real Nair"));
		jogadores.add(new Jogador("Luiz Fernando", "Real Nair"));
		jogadores.add(new Jogador("Guilherme Willians", "Real Nair"));

		jogadores.add(new Jogador("Evandro Santana", "Tudo Nosso"));
		jogadores.add(new Jogador("Kaio Vinicius", "Tudo Nosso"));
		jogadores.add(new Jogador("Guilherme Santos", "Tudo Nosso"));
		jogadores.add(new Jogador("Maycon", "Tudo Nosso"));
		jogadores.add(new Jogador("Lincoln", "Tudo Nosso"));
		jogadores.add(new Jogador("Gabriel da Silva", "Tudo Nosso"));
		jogadores.add(new Jogador("Lucas de Lima", "Tudo Nosso"));
		jogadores.add(new Jogador("Matheus Gabriel", "Tudo Nosso"));
		jogadores.add(new Jogador("Matheus Ferreira", "Tudo Nosso"));
		jogadores.add(new Jogador("Felipe Lopes", "Tudo Nosso"));

		jogadores.add(new Jogador("Murilo", "Tramontina"));
		jogadores.add(new Jogador("Lucas Baccarat", "Tramontina"));
		jogadores.add(new Jogador("Caio", "Tramontina"));
		jogadores.add(new Jogador("Luis Gama", "Tramontina"));
		jogadores.add(new Jogador("Gabriel", "Tramontina"));
		jogadores.add(new Jogador("Luiz Pires", "Tramontina"));
		jogadores.add(new Jogador("Weslley", "Tramontina"));
		jogadores.add(new Jogador("Bruno", "Tramontina"));
		jogadores.add(new Jogador("Geovane", "Tramontina"));
		jogadores.add(new Jogador("José Antônio", "Tramontina"));

		jogadores.add(new Jogador("Richard", "B Negado"));
		jogadores.add(new Jogador("Adilson", "B Negado"));
		jogadores.add(new Jogador("Weslley", "B Negado"));
		jogadores.add(new Jogador("Davi Matheus", "B Negado"));
		jogadores.add(new Jogador("Rubens", "B Negado"));
		jogadores.add(new Jogador("Carlivan", "B Negado"));
		jogadores.add(new Jogador("Rodrigo", "B Negado"));
		jogadores.add(new Jogador("Fabio Marques", "B Negado"));
		jogadores.add(new Jogador("Hebert", "B Negado"));
		jogadores.add(new Jogador("David Alves", "B Negado"));

		jogadores.add(new Jogador("Lúcio Maciel", "Gleba"));
		jogadores.add(new Jogador("Alan henrique", "Gleba"));
		jogadores.add(new Jogador("Hawy", "Gleba"));
		jogadores.add(new Jogador("Ronny", "Gleba"));
		jogadores.add(new Jogador("Felipe Oliveira", "Gleba"));
		jogadores.add(new Jogador("Marcos Paulo", "Gleba"));
		jogadores.add(new Jogador("Gustavo dos Santos", "Gleba"));
		jogadores.add(new Jogador("Thiago", "Gleba"));
		jogadores.add(new Jogador("Jhow D'Arco", "Gleba"));
		jogadores.add(new Jogador("Felipe", "Gleba"));

		jogadores.add(new Jogador("Andreverson", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("Caio Pereira", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("Kayque", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("Thawan", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("Mauricio", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("Igor", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("João Paulo", "Fome Zero Sport Clube"));
		jogadores.add(new Jogador("Caio Dos Santos", "Fome Zero Sport Clube"));

		jogadores.add(new Jogador("Odirlei", "Veteranos"));
		jogadores.add(new Jogador("João Vitor", "Veteranos"));
		jogadores.add(new Jogador("Rodrigo", "Veteranos"));
		jogadores.add(new Jogador("Carlos Eduardo", "Veteranos"));
		jogadores.add(new Jogador("Marcio", "Veteranos"));
		jogadores.add(new Jogador("Ederson", "Veteranos"));
		jogadores.add(new Jogador("Marcos Santos", "Veteranos"));
		jogadores.add(new Jogador("Petras", "Veteranos"));
		jogadores.add(new Jogador("Antônio", "Veteranos"));
		jogadores.add(new Jogador("Jorge Marcolino", "Veteranos"));

		jogadores.add(new Jogador("Marcos Felipe", "UNIDOS"));
		jogadores.add(new Jogador("Angelo", "UNIDOS"));
		jogadores.add(new Jogador("Enrico", "UNIDOS"));
		jogadores.add(new Jogador("Vinícius Diniz", "UNIDOS"));
		jogadores.add(new Jogador("André Gabriel", "UNIDOS"));
		jogadores.add(new Jogador("Guilherme Barbosa", "UNIDOS"));
		jogadores.add(new Jogador("Felipe Mateus", "UNIDOS"));
		jogadores.add(new Jogador("Anderson Maia", "UNIDOS"));
		jogadores.add(new Jogador("Michael", "UNIDOS"));

		jogadores.add(new Jogador("Gean Maike", "Confrades"));
		jogadores.add(new Jogador("Afonso", "Confrades"));
		jogadores.add(new Jogador("Erick", "Confrades"));
		jogadores.add(new Jogador("Eduardo", "Confrades"));
		jogadores.add(new Jogador("Jason", "Confrades"));
		jogadores.add(new Jogador("Caio", "Confrades"));
		jogadores.add(new Jogador("Rodrigo Ribeiro", "Confrades"));
		jogadores.add(new Jogador("Matheus", "Confrades"));
		jogadores.add(new Jogador("Manuel", "Confrades"));
		jogadores.add(new Jogador("Alex Veloso", "Confrades"));

		jogadores.add(new Jogador("Rodrigo Fernandes", "Vorskla"));
		jogadores.add(new Jogador("Bruno Sánchez", "Vorskla"));
		jogadores.add(new Jogador("Henrique Silva", "Vorskla"));
		jogadores.add(new Jogador("Felipe Leme", "Vorskla"));
		jogadores.add(new Jogador("Thiago Kaique", "Vorskla"));
		jogadores.add(new Jogador("Guilherme", "Vorskla"));
		jogadores.add(new Jogador("William Cícero", "Vorskla"));
		jogadores.add(new Jogador("Caio", "Vorskla"));
		jogadores.add(new Jogador("Arthur Lestingi", "Vorskla"));
		jogadores.add(new Jogador("William Queiroz", "Vorskla"));


		for (Jogador jogador : jogadores) {
			jogador.setIdTabela("57389ee14c7ffc3655ed47d7");
			jogadorRepository.save(jogador);
		}

		return jogadores;
	}
}
