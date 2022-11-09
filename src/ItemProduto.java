package src;

import java.math.BigDecimal;

public class ItemProduto extends Item{
    private Produto produto;

    public ItemProduto(Integer id, Integer quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, BigDecimal desconto, TipoItem tipoItem, Produto produto) {
        super(id, quantidade, valorUnitario, valorTotal, desconto, TipoItem.PRODUTO);
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
