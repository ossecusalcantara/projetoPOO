package src;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    private Integer id;
    private LocalDate dataEmissao;
    private TipoNota tipoNota; // Atributo verificador se Nota é entrada ou sida
    private Integer numeroNota;
    private BigDecimal desconto;
    private List<Item> itens = new ArrayList<>();
    private BigDecimal valorBruto;
    private BigDecimal valorLiquido;
    private BigDecimal bcIss;
    private BigDecimal iss;
    private BigDecimal bcIcms;
    private BigDecimal icms;


    public void setValorTotalItens() {
        BigDecimal somaValorServicos = new BigDecimal(0);
        BigDecimal somaValorProdutos = new BigDecimal(0);

        for (Item itemValor : itens) {
            if(itemValor.getTipoItem() == TipoItem.PRODUTO) {
                somaValorProdutos = somaValorProdutos.add(itemValor.getValorTotal());
            } else {
                somaValorServicos = somaValorServicos.add(itemValor.getValorTotal());
            }
        }
        this.bcIss = somaValorServicos;
        this.bcIcms = somaValorProdutos;

    }

    public  NotaFiscal() {}

    public NotaFiscal(Integer id, LocalDate dataEmissao,  TipoNota tipoNota, Integer numeroNota, BigDecimal desconto, List<Item> itens, BigDecimal valorBruto, BigDecimal valorLiquido, BigDecimal bcIcms, BigDecimal icms) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.tipoNota = tipoNota;
        this.numeroNota = numeroNota;
        this.desconto = desconto;
        this.itens = itens;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.bcIcms = bcIcms;
        this.icms = icms;
    }

    public NotaFiscal(Integer id, TipoNota tipoNota, LocalDate dataEmissao, Integer numeroNota, BigDecimal desconto, List<Item> itens, BigDecimal valorBruto, BigDecimal valorLiquido, BigDecimal bcIss, BigDecimal iss) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.tipoNota = tipoNota;
        this.numeroNota = numeroNota;
        this.desconto = desconto;
        this.itens = itens;
        this.valorBruto = valorBruto;
        this.valorLiquido = valorLiquido;
        this.bcIss = bcIss;
        this.iss = iss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataEmissaoFormatadaBr() {
        Date date = Date.valueOf(dataEmissao);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String data = format.format(date);
        return data;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public TipoNota getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(TipoNota tipoNota) {
        this.tipoNota = tipoNota;
    }

    public Integer getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Integer numeroNota) {
        this.numeroNota = numeroNota;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public BigDecimal getBcIss() {
        return bcIss;
    }

    public void setBcIss(BigDecimal bcIss) {
        this.bcIss = bcIss;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public BigDecimal getBcIcms() {
        return bcIcms;
    }

    public void setBcIcms(BigDecimal bcIcms) {
        this.bcIcms = bcIcms;
    }

    public BigDecimal getIcms() {
        return icms;
    }

    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    public void setIcms() {
        this.icms = bcIcms.multiply(BigDecimal.valueOf(0.17));
        System.out.println(icms);
    }

    public void setIss() {
        this.iss = bcIss.multiply(BigDecimal.valueOf(0.03));
        System.out.println(iss);
    }

    public BigDecimal getValorContabil() {
        BigDecimal valorContabil = new BigDecimal(0);

        valorContabil = valorBruto;
        valorContabil = valorContabil.add(iss);
        valorContabil = valorContabil.subtract(desconto);
        return valorContabil;
    }

    public void setValorLiquido() {
        BigDecimal valor = new BigDecimal(0);
        valor = valorBruto;
        valor = valor.subtract(desconto);
        valor = valor.add(iss);
        this.valorLiquido = valor;
        System.out.println(valor);
    }
}
