package src;
import java.math.BigDecimal;

public class Estoque {
    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal custoUnitario;
    private BigDecimal custoTotal;


    public Estoque(Integer id, Produto produto, Integer quantidade, BigDecimal custoUnitario, BigDecimal custoTotal) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.custoUnitario = custoUnitario;
        this.custoTotal = custoTotal;

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

    public BigDecimal calcularCustoUnitario() {
        custoUnitario = this.custoTotal.divide(BigDecimal.valueOf(quantidade));
        return custoUnitario;
    }

}
