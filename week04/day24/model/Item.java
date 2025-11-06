package model;

public class Item {
    private String nome;
    private String categoria;
    private int quantidade;

    public Item(String nome, String categoria, int quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return nome + " (" + quantidade + ")";
    }

}
