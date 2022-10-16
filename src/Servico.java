package src;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Servico {
    private Integer id;
    private String descricao;
    private LocalDate tempo;
    private BigDecimal valor;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTempo(LocalDate tempo) {
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

    public LocalDate getTempo() {
        return tempo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
