package src;

public class Usuario {
    private String login;
    private String senha;
    private PessoaJuridica minhaEmpres;
    //Cadastro Da nossa empresa se quiser buscar nossas informações

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public PessoaJuridica getMinhaEmpres() {
        return minhaEmpres;
    }

    public void setMinhaEmpres(PessoaJuridica minhaEmpres) {
        this.minhaEmpres = minhaEmpres;
    }
}
