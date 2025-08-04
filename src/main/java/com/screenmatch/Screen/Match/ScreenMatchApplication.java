package com.screenmatch.Screen.Match;

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
		var json = apiFilmes.obterDados("http://www.omdbapi.com/?t=The+Avengers&apikey=6c5f82fc");
		// Conversor
		ConverteDados desserializacao = new ConverteDados();
		// Classe de mapeamento recebe o valor do conversor com seus parametros
		DadosSerie dadosSerie = desserializacao.obterDados(json, DadosSerie.class);
		System.out.printf("Titulo do filme: %s e seu lancamento foi em %d", dadosSerie.title(), dadosSerie.year());
	}
}
