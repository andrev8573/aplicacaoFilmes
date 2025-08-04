package com.screenmatch.Screen.Match;

import com.screenmatch.Screen.Match.domain.DadosEpisodio;
import com.screenmatch.Screen.Match.domain.DadosSerie;
import com.screenmatch.Screen.Match.services.ConsumoApi;
import com.screenmatch.Screen.Match.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {
		var apiFilmes = new ConsumoApi(); // Inferência de tipo (primitivo ou contruído)
		// URL com parâmetros
		var json = apiFilmes.obterDados("https://www.omdbapi.com/?t=The+Walking+Dead&season=1&episode=1&apikey=6c5f82fc");
		// Conversor
		ConverteDados desserializacao = new ConverteDados();
		// Classe de mapeamento recebe o valor do conversor com seus parametros
		DadosSerie dadosSerie = desserializacao.obterDados(json, DadosSerie.class);
		DadosEpisodio dadosEpisodio = desserializacao.obterDados(json, DadosEpisodio.class);
		System.out.printf("Titulo: %s e seu lancamento foi em %d\n", dadosSerie.titulo(), dadosSerie.ano());
		System.out.println(dadosEpisodio);
	}
}
