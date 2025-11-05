package model;

public class Cidade {
    private String nome;
    private String pais;
    private long populacao;

    public Cidade(String nome, String pais, long populacao) {
        this.nome = nome;
        this.pais = pais;
        this.populacao = populacao;
    }

    public String getNome() { return nome; }
    public String getPais() { return pais; }
    public long getPopulacao() { return populacao; }

    @Override
    public String toString() {
        return nome + " (" + pais + ") - " + populacao;
    }
    
}
