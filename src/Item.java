package src;
import java.math.BigDecimal;

public class Item {
    private Integer id;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private BigDecimal desconto; //desconto total
    private TipoItem tipoItem;

    public Item(Integer id, Integer quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, BigDecimal desconto, TipoItem tipoItem) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.tipoItem = tipoItem;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
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
