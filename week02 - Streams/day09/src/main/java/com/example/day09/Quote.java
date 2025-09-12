package com.example.day09;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String q; // frase
    private String a; // autor

    public String getQ() { return q; }
    public void setQ(String q) { this.q = q; }

    public String getA() { return a; }
    public void setA(String a) { this.a = a; }
}