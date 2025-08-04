package com.screenmatch.Screen.Match.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDados {
    // Generics permite trabalhar que o metodo trabalha com qualquer tipo recebido
    <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException;
}
