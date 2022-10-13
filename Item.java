import java.math.BigDecimal;

public class Item {
    private Integer id;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private BigDecimal desconto; //desconto total

    private BigDecimal calcularValorTotal() {
        valorTotal = (this.valorUnitario.multiply(BigDecimal.valueOf(quantidade)).subtract(desconto)) ;
        return valorTotal;
    }


}
