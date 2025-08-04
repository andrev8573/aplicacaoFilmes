package com.screenmatch.Screen.Match.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    // Classe do jackson que mapeia JSON para Java
    private ObjectMapper objectMapper = new ObjectMapper();

    // Basta instanciar ConverteDados e informar o JSON e a classe do mapeamento (qualquer que seja a record)
    @Override
    public <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException {
        return objectMapper.readValue(json, classe);
    }
}
