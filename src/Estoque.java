import java.math.BigDecimal;

public class Estoque {
    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal custoUnitario;
    private BigDecimal custoTotal;
    private BigDecimal valorUnitario; //Valor de venda
    private BigDecimal valorTotal; //Valor de venda

    private BigDecimal calcularCustoTotal() {
        custoTotal = this.custoUnitario.multiply(BigDecimal.valueOf(quantidade));
        return custoTotal;
    }

    private BigDecimal calcularValorTotal() {
        valorTotal = this.valorUnitario.multiply(BigDecimal.valueOf(quantidade));
        return valorTotal;
    }

}
