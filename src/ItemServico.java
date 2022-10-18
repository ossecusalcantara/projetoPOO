package src;

import java.math.BigDecimal;

public class ItemServico extends Item{
    private Servico servico;

    public ItemServico(Integer id, Integer quantidade, BigDecimal valorUnitario, BigDecimal valorTotal, BigDecimal desconto, TipoItem tipoItem, Servico servico) {
        super(id, quantidade, valorUnitario, valorTotal, desconto, TipoItem.SERVICO);
        this.servico = servico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
