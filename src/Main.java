import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Vaga");
            System.out.println("2. Registrar Entrada de Veículo");
            System.out.println("3. Registrar Saída de Veículo");
            System.out.println("4. Gerar Relatório de Vagas Ocupadas");
            System.out.println("5. Gerar Histórico de Veículos");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Número da Vaga: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tamanho da Vaga (pequeno-médio-grande): ");
                    String tamanhoVaga = scanner.nextLine();
                    estacionamento.cadastrarVaga(new Vaga(numero, tamanhoVaga));
                    break;
                case 2:
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho (pequeno-médio-grande): ");
                    String tamanhoVeiculo = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanhoVeiculo, LocalDateTime.now());
                    estacionamento.registrarEntrada(veiculo);
                    break;
                case 3:
                    System.out.print("Placa do Veículo para saída: ");
                    String placaSaida = scanner.nextLine();
                    estacionamento.registrarSaida(placaSaida);
                    break;
                case 4:
                    estacionamento.gerarRelatorioVagasOcupadas();
                    break;
                case 5:
                    estacionamento.gerarHistoricoVeiculos();
                    break;
                case 6:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}