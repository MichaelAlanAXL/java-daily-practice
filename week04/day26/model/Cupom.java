package model;

import java.time.LocalDate;

public class Cupom {
    private String codigo;
    private double desconto;
    private LocalDate validade;

    // Construtor sem-argumentos necessário para desserialização (Gson)
    public Cupom() {
    }

    public Cupom(String codigo, double desconto, LocalDate validade) {
        this.codigo = codigo;
        this.desconto = desconto;
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Cupom [codigo=" + codigo + ", desconto=" + desconto + ", validade=" + validade + "]";
    }    
    
}
