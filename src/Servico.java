package src;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servico implements ItemVendavel{
    private Integer id;
    private String descricao;
    private Date tempo;
    private BigDecimal valor;

    public Servico() {}

    public Servico( String descricao, String tempo, BigDecimal valor) throws ParseException {
        this.descricao = descricao;
        DateFormat formatador = new SimpleDateFormat("HH:mm");
        this.tempo = formatador.parse(tempo);
        this.valor = valor;
    }

    public Servico( String descricao) throws ParseException {
        this.descricao = descricao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTempo(Date tempo) { this.tempo = tempo;}

    public void setTempo(String tempo) throws ParseException {
        DateFormat formatador = new SimpleDateFormat("HH:mm");
        this.tempo = formatador.parse(tempo);
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

    public Date getTempo() {
        return tempo;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
