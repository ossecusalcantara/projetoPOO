package src;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrdemDeServico {
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataLimite;
    private String condicao;
    private List<Item> itens;
    private BigDecimal valorTotal;

    public OrdemDeServico(Integer id, LocalDate dataEntrada, LocalDate dataLimite, String condicao, List<ItemProduto> itensProdutos, List<Item> itens, BigDecimal valorTotal) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataLimite = dataLimite;
        this.condicao = condicao;
        this.itens = itens;
        this.valorTotal = calculaValorTotalProdutos(itensProdutos);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public void setItensProdutos(List<ItemProduto> itensProdutos) {
        this.itens = itens;
    }

    public void setItensServicos(List<ItemServico> itensServicos) {
        this.itens = itens;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public String getCondicao() {
        return condicao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

//    private BigDecimal calculaValorTotalProdutos(List<ItemProduto> itensProdutos) {
//        BigDecimal somaValorTotalProdutos = BigDecimal.valueOf(0);
//        for (ItemProduto valorTotal : itensProdutos){
//            somaValorTotalProdutos = somaValorTotalProdutos.add(valorTotal.getValorTotal());
//        }
//        return somaValorTotalProdutos;
//    }
}






