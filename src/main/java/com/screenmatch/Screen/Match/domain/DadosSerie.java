package com.screenmatch.Screen.Match.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignora todos os atributos nao mapeados
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("Year") Integer ano) {
}
