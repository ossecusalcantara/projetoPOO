package src;
import java.math.BigDecimal;

public class Estoque {
    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal custoUnitario;
    private BigDecimal custoTotal;
    private BigDecimal valorUnitario; //Valor de venda
    private BigDecimal valorTotal; //Valor de venda

    public Estoque(Integer id, Produto produto, Integer quantidade, BigDecimal custoUnitario, BigDecimal custoTotal, BigDecimal valorUnitario, BigDecimal valorTotal) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.custoUnitario = custoUnitario;
        this.custoTotal = custoTotal;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setCustoUnitario(BigDecimal custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public void setCustoTotal(BigDecimal custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getCustoUnitario() {
        return custoUnitario;
    }

    public BigDecimal getCustoTotal() {
        return custoTotal;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    private BigDecimal calcularCustoTotal() {
        custoTotal = this.custoUnitario.multiply(BigDecimal.valueOf(quantidade));
        return custoTotal;
    }

    private BigDecimal calcularValorTotal() {
        valorTotal = this.valorUnitario.multiply(BigDecimal.valueOf(quantidade));
        return valorTotal;
    }

}
