import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Veiculo> historico;

    public Estacionamento() {
        vagas = new ArrayList<>();
        historico = new ArrayList<>();
    }

    public void cadastrarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public void registrarEntrada(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(veiculo.getTamanho())) {
                vaga.ocuparVaga();
                historico.add(veiculo);
                System.out.println("Veículo estacionado na vaga número " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Não há vaga disponível para o veículo.");
    }

    public void registrarSaida(String placa) {
        Veiculo veiculoSaida = null;
        for (Veiculo veiculo : historico) {
            if (veiculo.getPlaca().equals(placa) && veiculo.getHoraSaida() == null) {
                veiculo.setHoraSaida(LocalDateTime.now());
                veiculoSaida = veiculo;
                break;
            }
        }

        if (veiculoSaida == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        Duration duracao = Duration.between(veiculoSaida.getHoraEntrada(), veiculoSaida.getHoraSaida());
        double valorPago = calcularValor(duracao.toHours());

        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(veiculoSaida.getTamanho())) {
                vaga.liberarVaga();
                System.out.println("Veículo saiu da vaga número " + vaga.getNumero() + ". Valor a pagar: R$ " + valorPago);
                return;
            }
        }
    }

    private double calcularValor(long horas) {
        if (horas <= 1) {
            return 5.0;
        } else if (horas <= 3) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    public void gerarRelatorioVagasOcupadas() {
        System.out.println("Relatório de Vagas Ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " - Tamanho: " + vaga.getTamanho());
            }
        }
    }

    public void gerarHistoricoVeiculos() {
        System.out.println("Histórico de Permanência dos Veículos:");
        for (Veiculo veiculo : historico) {
            if (veiculo.getHoraSaida() != null) {
                Duration duracao = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
                double valorPago = calcularValor(duracao.toHours());
                System.out.println("Placa: " + veiculo.getPlaca() +
                        ", Tempo: " + duracao.toHours() + " horas" +
                        ", Valor Pago: R$ " + valorPago);
            }
        }
    }
}
