package br.com.alura.ConversoDeMoeda.Servece;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscarDados {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

//        System.out.println("Qual é moeda base: ");
//        String moedaBase = sc.nextLine();
//
//        System.out.println("Qual é moeda destino: ");
//        String moedaDestino = sc.nextLine();
        String endereco = "https://v6.exchangerate-api.com/v6/d91cfa7e8348055ca3d67e47/latest/USD";

                    //"https://v6.exchangerate-api.com/v6/" + "d91cfa7e8348055ca3d67e47" + "/latest/ "+ moedaBase + moedaDestino;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(response.body());
    }
}
