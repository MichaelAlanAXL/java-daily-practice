package dev.michael.day04.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int quantidade;
    private double preco;

    public Produto() {}

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPreco() { return preco; }

    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", nome='" + nome + '\'' + 
            ", quantidade=" + quantidade + 
            ", preço=" + preco + '}';
    }

    
    
}
