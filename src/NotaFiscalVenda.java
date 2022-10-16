package src;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NotaFiscalVenda extends NotaFiscal{
    private LocalDate dataSaida;
    private List<ItemProduto> itensProdutos;
    private BigDecimal valorTotalProd;
    private BigDecimal valorTotalNota;
    private BigDecimal bcIcms;
    private BigDecimal icms;
    private BigDecimal desconto;
}
