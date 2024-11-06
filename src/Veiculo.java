import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Veiculo(String placa, String modelo, String tamanho, LocalDateTime horaEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.horaEntrada = horaEntrada;
    }

    public String getPlaca() { return placa; }
    public String getTamanho() { return tamanho; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public void setHoraSaida(LocalDateTime horaSaida) { this.horaSaida = horaSaida; }
    public LocalDateTime getHoraSaida() { return horaSaida; }
}