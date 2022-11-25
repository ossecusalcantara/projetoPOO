package src;

public class Produto implements ItemVendavel {
    private Integer id;
    private String descricao;
    private String tipo;
    private Marca marca;

    public Produto() {}

    public Produto( String descricao, String tipo, Marca marca) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.marca = marca;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public Marca getMarca() {
        return marca;
    }
}
