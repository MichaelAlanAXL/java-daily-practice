package com.example.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Supplier;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {     
        Supplier<String> quoteSupplier = () -> {
            try {
                URL url = new URL("https://zenquotes.io/api/random");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
    
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Converter JSON
                ObjectMapper mapper = new ObjectMapper();
                Quote[] quotes = mapper.readValue(response.toString(), Quote[].class);

                Quote firstQuote = quotes[0];    
                return firstQuote.getQ() + " - " + firstQuote.getA();
    
            } catch (IOException e) {
                System.out.println("Erro ao buscar frase: " + e.getMessage());
                e.printStackTrace();
                return "Erro ao buscar frase";
            }
            
        };

        System.out.println(quoteSupplier.get());
    }
}
