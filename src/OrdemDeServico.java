package src;
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
    private BigDecimal valorTotal ;

    public OrdemDeServico(Integer id, LocalDate dataEntrada, LocalDate dataEntrega, String condicao, List<ItemProduto> itensProdutos, List<ItemServico> itensServicos, BigDecimal valorTotal) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataEntrega = dataEntrega;
        this.condicao = condicao;
        this.itensProdutos = itensProdutos;
        this.itensServicos = itensServicos;
        this.valorTotal = calculaValorTotalProdutos(itensProdutos);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public void setItensProdutos(List<ItemProduto> itensProdutos) {
        this.itensProdutos = itensProdutos;
    }

    public void setItensServicos(List<ItemServico> itensServicos) {
        this.itensServicos = itensServicos;
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

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public String getCondicao() {
        return condicao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    private BigDecimal calculaValorTotalProdutos(List<ItemProduto> itensProdutos) {
        BigDecimal somaValorTotalProdutos = BigDecimal.valueOf(0);
        for (ItemProduto valorTotal : itensProdutos){
            somaValorTotalProdutos = somaValorTotalProdutos.add(valorTotal.getValorTotal());
        }
        return somaValorTotalProdutos;
    }
}






