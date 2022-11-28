package src;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeServico {
    private Integer id;
    private LocalDate dataEntrada;
    private LocalDate dataLimite;
    private String titulo;
    private String condicao;
    private List<Item> itens = new ArrayList<>();
    private BigDecimal valorTotal;

    public OrdemDeServico(){}

    public OrdemDeServico( String dataEntrada, String dataLimite, String condicao, List<Item> itensOrdem, BigDecimal valorTotal) {
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEntrada = LocalDate.parse(dataEntrada, formatadorBarra);
        this.dataLimite = LocalDate.parse(dataLimite, formatadorBarra);
        this.condicao = condicao;
        this.valorTotal = calculaValorTotalProdutos(itensOrdem);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataFormatada(String data, int tipoData) {
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(tipoData == 1) {
            this.dataEntrada = LocalDate.parse(data, formatadorBarra);
        } else {
            this.dataLimite = LocalDate.parse(data, formatadorBarra);
        }
    }

    public String getDataFormatada(int tipoData) {
        String data = null;
        if(tipoData == 1) {
            Date date = Date.valueOf(dataEntrada);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            data = format.format(date);
            return data;
        } else {
            Date date = Date.valueOf(dataLimite);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            data = format.format(date);
            return data;
        }
    }

    public BigDecimal getSomaValorTOtalItensOS(){
        BigDecimal soma = new BigDecimal(0);

        for (Item itemValor : itens) {
            soma = soma.add(itemValor.getValorTotal());
            System.out.println("soma: " + soma);
        }
        System.out.println("somaTotal: " + soma);
        return soma;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setItemAdd(Item item) {
        this.itens.add(item);
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

    public void setValorTotal() {
        BigDecimal valorTotal = new BigDecimal(0);

        for (Item itemValor : itens) {
            valorTotal = valorTotal.add(itemValor.getValorTotal());
        }
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    private BigDecimal calculaValorTotalProdutos(List<Item> itensOrdem) {
        BigDecimal somaValorTotalProdutos = BigDecimal.valueOf(0);
        for (Item valorTotal : itensOrdem){
            somaValorTotalProdutos = somaValorTotalProdutos.add(valorTotal.getValorTotal());
        }
        return somaValorTotalProdutos;
    }
}






