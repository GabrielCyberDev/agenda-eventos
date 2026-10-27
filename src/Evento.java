import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    public static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private String nome;
    private LocalDateTime dataHora;
    private DiaDaSemana diaDaSemana;

    public Evento(String nome, LocalDateTime dataHora, DiaDaSemana diaDaSemana) {
        this.nome = nome;
        this.dataHora = dataHora;
        this.diaDaSemana = diaDaSemana;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public void exibirEvento() {
        System.out.println("Evento: " + nome);
        System.out.println("Data e hora: " + dataHora.format(FORMATO));
        System.out.println("Dia da semana: " + diaDaSemana);
    }
}
