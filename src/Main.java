import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        // Evento com a data e hora atuais
        LocalDateTime agora = LocalDateTime.now();
        // DayOfWeek vai de 1 (segunda) a 7 (domingo), na mesma ordem do enum
        DiaDaSemana dia = DiaDaSemana.values()[agora.getDayOfWeek().getValue() - 1];

        Evento evento = new Evento("Reunião de Planejamento", agora, dia);
        evento.exibirEvento();

        // plusDays(5)
        LocalDateTime maisCinco = evento.getDataHora().plusDays(5);
        System.out.println();
        System.out.println("Data e hora +5 dias: " + maisCinco.format(Evento.FORMATO));

        // Conversão de fuso: considera o fuso do seu computador como origem
        ZonedDateTime origem = evento.getDataHora().atZone(ZoneId.systemDefault());
        ZonedDateTime saoPaulo = origem.withZoneSameInstant(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime gmt = origem.withZoneSameInstant(ZoneId.of("GMT"));

        System.out.println();
        System.out.println("São Paulo (BRT): " + saoPaulo.format(Evento.FORMATO)
                + " [" + saoPaulo.getZone() + "]");
        System.out.println("GMT: " + gmt.format(Evento.FORMATO)
                + " [" + gmt.getZone() + "]");
    }
}
