package src;
import java.time.LocalDate;
import java.util.List;

public class PessoaFisica extends Pessoa{

    private String cpf;
    private LocalDate dataDeNascimento;

    public PessoaFisica(Integer id, String nome, Endereco endereco, String telefone, String email) {
        super(id, nome, endereco, telefone, email);
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
