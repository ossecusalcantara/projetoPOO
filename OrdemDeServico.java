import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrdemDeServico {
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataEntrega;
    private String condicao;
    private List<ItemProduto> itensProdutos;
    private List<ItemServico> itensServicos;
    private BigDecimal valorTotal;

    private BigDecimal calculaValorTotalProdutos () {
        BigDecimal somaValorTotalProdutos;
        for (ItemProduto valorTotal : itensProdutos){
            somaValorTotalProdutos = somaValorTotalProdutos.add(valorTotal.getValorTotal());
        }
        return somaValorTotalProdutos;
    }
}






