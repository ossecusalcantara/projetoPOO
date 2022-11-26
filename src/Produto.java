package src;

public class Produto implements ItemVendavel {
    private Integer id;
    private String descricao;
    private Integer quantidade;
    private Marca marca;

    public Produto() {}

    public Produto( String descricao, Integer quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Produto( String descricao, Integer quantidade, Marca marca) {
        this.descricao = descricao;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
