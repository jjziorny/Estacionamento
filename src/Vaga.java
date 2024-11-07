public class Vaga {
    private int numero;
    private String tamanho;  // "pequeno", "médio", "grande"
    private boolean ocupada;
    private Veiculo veiculo;

    public Vaga(int numero, String tamanho) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.ocupada = false;
        this.veiculo = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public boolean alocar(Veiculo veiculo) {
        if (!ocupada && this.tamanho.equals(veiculo.getTamanho())) {
            this.ocupada = true;
            this.veiculo = veiculo;
            return true;
        }
        return false;
    }

    public void liberar() {
        this.ocupada = false;
        this.veiculo = null;
    }
}
