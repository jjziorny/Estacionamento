import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Gerenciamento {
    private List<Vaga> vagas;
    private List<Veiculo> historico;

    public Gerenciamento() {
        this.vagas = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public boolean registrarEntrada(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (!vaga.isOcupada() && vaga.alocar(veiculo)) {
                veiculo.registrarEntrada(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    public boolean registrarSaida(String placa) {
        for (Vaga vaga : vagas) {
            if (vaga.isOcupada() && vaga.getVeiculo().getPlaca().equals(placa)) {
                Veiculo veiculo = vaga.getVeiculo();
                veiculo.registrarSaida(LocalDateTime.now());
                double valor = veiculo.calcularValor();
                historico.add(veiculo);
                vaga.liberar();
                System.out.println("Veículo " + placa + " saiu. Valor a pagar: R$ " + valor);
                return true;
            }
        }
        return false;
    }

    public void relatorioVagasOcupadas() {
        System.out.println("Relatório de Vagas Ocupadas:");
        for (Vaga vaga : vagas) {
            if (vaga.isOcupada()) {
                Veiculo veiculo = vaga.getVeiculo();
                System.out.println("Vaga " + vaga.getNumero() + " - Tamanho: " + vaga.getTamanho() + " - Placa: " + veiculo.getPlaca());
            }
        }
    }

    public void relatorioHistorico() {
        System.out.println("Histórico de Permanência de Veículos:");
        for (Veiculo veiculo : historico) {
            System.out.println("Placa: " + veiculo.getPlaca() + " - Entrada: " + veiculo.getEntrada() + " - Saída: " + veiculo.getSaida() + " - Valor Pago: R$ " + veiculo.calcularValor());
        }
    }
}
