public class Pessoa {
    
    private String nome;
    private double peso;
    private double altura;


    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getNome() {
        return nome;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getImc() {
        return peso / (altura * altura);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Peso : " + peso + " | Altura: " + altura + " | IMC: " + String.format("%.2f", getImc());
    }
}
