package src;
import java.time.LocalDate;
import java.util.List;

public class PessoaJuridica extends Pessoa{
    private String razaoSocial;
    private String cnpj;
    private LocalDate dataAbertura;
    private String cnae;

    public PessoaJuridica(Integer id, String nome, Endereco endereco, String telefone, String email) {
        super(id, nome, endereco, telefone, email);
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.cnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public String getCnae() {
        return cnae;
    }
}
