package src;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class NotaFiscalServico extends NotaFiscal{
    private LocalDate dataFatorGerado;
    private List<ItemServico> itensServicos;
    private BigDecimal valorBruto;
    private BigDecimal valorLiquido;
    private BigDecimal bcIss;
    private BigDecimal iss;

}
