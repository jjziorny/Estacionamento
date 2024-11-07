import java.util.Scanner;

class Estacionamento{
    public static void main(String[] args) {
        Gerenciamento gerenciamento = new Gerenciamento();


        gerenciamento.adicionarVaga(new Vaga(1, "pequeno"));
        gerenciamento.adicionarVaga(new Vaga(2, "médio"));
        gerenciamento.adicionarVaga(new Vaga(3, "grande"));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Registrar entrada de veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Relatório de vagas ocupadas");
            System.out.println("4. Relatório de histórico de veículos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome o newline

            switch (opcao) {
                case 1:
                    System.out.print("Informe a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Informe o modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Informe o tamanho do veículo (pequeno, médio, grande): ");
                    String tamanho = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                    if (gerenciamento.registrarEntrada(veiculo)) {
                        System.out.println("Veículo " + placa + " registrado com sucesso.");
                    } else {
                        System.out.println("Não há vaga disponível para o veículo " + placa + ".");
                    }
                    break;
                case 2:
                    System.out.print("Informe a placa do veículo para registrar a saída: ");
                    placa = scanner.nextLine();
                    if (!gerenciamento.registrarSaida(placa)) {
                        System.out.println("Veículo não encontrado ou já saiu.");
                    }
                    break;
                case 3:
                    gerenciamento.relatorioVagasOcupadas();
                    break;
                case 4:
                    gerenciamento.relatorioHistorico();
                    break;
                case 5:
                    running = false;
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}


