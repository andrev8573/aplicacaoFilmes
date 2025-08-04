package com.screenmatch.Screen.Match.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        // Cliente e requisicao em codigo pelas bibliotecas da JDK
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null; // Retorno null por padrao
        try {
            response = client // Envio da requisicao via metodo no objeto cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) { // Validacoes de input, output e interrupcao
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body(); // Corpo da resposta
        return json;
    }
}
