package src;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PessoaJuridica extends Pessoa{
    private String razaoSocial;
    private String cnpj;
    private LocalDate dataAbertura;
    private String cnae;

    public PessoaJuridica( String nome, String telefone, String email, String razaoSocial, String cnpj, String cnae, String dataAbertura) {
        super( nome, telefone, email);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnae = cnae;
        //Conversor de Data em String para Local Date
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataAbertura = LocalDate.parse(dataAbertura, formatadorBarra);
    }

    public PessoaJuridica( String nome, String telefone, String email, String razaoSocial, String cnpj, String cnae) {
        super( nome, telefone, email);
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.cnae = cnae;
    }

    @Override
    public void setData(String dataAbertura) {
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataAbertura = LocalDate.parse(dataAbertura, formatadorBarra);
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
