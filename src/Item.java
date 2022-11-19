package src;
import java.math.BigDecimal;
import java.util.Collection;

public abstract class Item {
    private Integer id;
    private Integer quantidade;

    private String descricao;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private BigDecimal desconto; //desconto total
    private TipoItem tipoItem;

    public Item(Integer id, Integer quantidade, String descricao, BigDecimal valorUnitario, BigDecimal valorTotal, BigDecimal desconto, TipoItem tipoItem) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.tipoItem = tipoItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    private BigDecimal calcularValorTotal() {
        valorTotal = (this.valorUnitario.multiply(BigDecimal.valueOf(quantidade)).subtract(desconto)) ;
        return valorTotal;
    }

}
