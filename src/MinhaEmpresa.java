package src;

public class MinhaEmpresa {
    public static void main(String[] args) {
        Pessoa dadosMinhaEmpresa = new PessoaJuridica();
        dadosMinhaEmpresa.setId(1);
        dadosMinhaEmpresa.setNome("Minha Loja");
        dadosMinhaEmpresa.setData("10/10/2022");
        dadosMinhaEmpresa.setEmail("minhaEmpresa@email.com");
        dadosMinhaEmpresa.setTelefone("9999-88888");
    }
}
