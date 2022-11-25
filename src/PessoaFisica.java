package src;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Pessoa{

    private String cpf;
    private LocalDate dataDeNascimento;


    public PessoaFisica( String nome, String telefone, String email, String cpf, String dataNascimento) {
        super( nome, telefone, email);
        this.cpf = cpf;
        //Conversor de Data em String para Local Date
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDeNascimento = LocalDate.parse(dataNascimento, formatadorBarra);
    }

    public PessoaFisica(String nome, String telefone, String email, String cpf) {
        super( nome, telefone, email);
        this.cpf = cpf;
    }

    @Override
    public void setData(String dataNascimento) {
        DateTimeFormatter formatadorBarra = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDeNascimento = LocalDate.parse(dataNascimento, formatadorBarra);
    }

    @Override
    public String getDocumentoPrincipal() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
}
