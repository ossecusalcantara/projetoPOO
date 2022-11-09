package src;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servico {
    private Integer id;
    private String descricao;
    private LocalDateTime tempo;
    private BigDecimal valor;

    public Servico(Integer id, String descricao, String tempo, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        DateTimeFormatter formatadorTempo = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.tempo = LocalDateTime.parse(tempo, formatadorTempo);
        this.valor = valor;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
