import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;  // "pequeno", "médio", "grande"
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.entrada = null;
        this.saida = null;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void registrarEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public void registrarSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    // Método para calcular o valor baseado no tempo de permanência
    public double calcularValor() {
        if (entrada != null && saida != null) {
            long minutos = java.time.Duration.between(entrada, saida).toMinutes();
            if (minutos <= 60) {
                return 5.0;
            } else if (minutos <= 180) {
                return 10.0;
            } else {
                return 15.0;
            }
        }
        return 0.0;
    }
}
