package src;
import java.util.List;

public abstract class Pessoa {
    private Integer id;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private String email;

    public Pessoa() {}

    public Pessoa( String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public void setData() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public abstract void setData(String dataNascimento);

    public String getDocumentoPrincipal(){
        return "";
    }
}
