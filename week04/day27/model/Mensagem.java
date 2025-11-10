package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensagem {
    private String usuario;
    private String conteudo;
    private LocalDateTime horario;

    public Mensagem(String usuario, String conteudo) {
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.horario = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "[" + horario.format(fmt) + "] " + usuario + ": " + conteudo;
    }    
    
}
