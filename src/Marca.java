package src;

public class Marca {
    private Integer id;
    private String marca;

    public Marca(Integer id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }
}
