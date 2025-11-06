package service;

import model.Item;
import java.util.*;
import java.util.stream.Collectors;

public class ShoppingService {

    private final List<Item> listaCompras;

    public ShoppingService(List<Item> listaInicial) {
        this.listaCompras = listaInicial;
    }

    public void adicionar(String nome, String categoria, int quantidade) {
        listaCompras.add(new Item(nome, categoria, quantidade));
        System.out.println("Item adicionado!");
    }

    public void listarPorCategoria() {
        Map<String, List<Item>> agrupado = listaCompras.stream()
            .collect(Collectors.groupingBy(Item::getCategoria));
        
        agrupado.forEach((categoria, itens) -> {
            System.out.println("\n Categoria: " + categoria);
            itens.forEach(i -> System.out.println(" - " + i));
        });
    }

    public void rankingCategorias() {
        Map<String, Long> ranking = listaCompras.stream()
            .collect(Collectors.groupingBy(Item::getCategoria, Collectors.counting()));

        System.out.println("\n Ranking de Categorias:");
        ranking.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " itens"));
    }

    public List<Item> getLista() {
        return listaCompras;
    }
    
}
