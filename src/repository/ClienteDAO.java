package src.repository;

import src.Cliente;
import src.Pessoa;
import src.PessoaFisica;
import src.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    static  List<Cliente> clientes = new ArrayList<>();

    public static void salvar(Cliente cliente) {

        cliente.getPessoa().setId(clientes.size() + 1);
        clientes.add(cliente);
    }


    public static List<Cliente> buscarTodos() {
        System.out.println(clientes);
        return clientes;
    }

    public static List<Cliente> buscarPorNome(String nome){
        List<Cliente> clientesFiltrados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if(cliente.getPessoa().getNome().contains(nome)) {
                clientesFiltrados.add(cliente);
            }
        }
        return  clientesFiltrados;
    }

    public static Object[] findPessoasInArray() {
        List<Cliente> clientes = ClienteDAO.buscarTodos();
        List<String> clientesNomes = new ArrayList<>();

        for(Cliente cliente : clientes) {
            clientesNomes.add(cliente.getPessoa().getNome());
        }

        return clientesNomes.toArray();
    }

    public static void iniciarDadosCliente() {
        Pessoa cliente1 = new PessoaJuridica("Senac","8888-9999","senac@email.com.br","","26.816.258/0001-54","8020-5/00");
        cliente1.setData("18/10/1998");
        Pessoa cliente2 = new PessoaJuridica("Maré Soul","9999-8888","mare.soul@contato.com.br","Maré Soul Ltda.","26.816.258/0001-54","7020-4/00");
        cliente2.setData("23/02/1990");
        Pessoa cliente3 = new PessoaJuridica("Encantus","9999-7777","encantus@contato.com.br","Encantus Empreendimentos","15.987.234/0033-54","6080-5/00");
        cliente3.setData("15/02/2005");
        Pessoa cliente4 = new PessoaFisica("Adson Alcantara","9855-0987","adson.alcantara@email.com","123.222.333-87","23/02/1998");
        Pessoa cliente5 = new PessoaFisica("Kaiana Miguel","8137-1170","kaina.miguel@email.com","111.111.111-11","12/10/1998");

        ClienteDAO.salvar(new Cliente(cliente1));
        ClienteDAO.salvar(new Cliente(cliente2));
        ClienteDAO.salvar(new Cliente(cliente3));
        ClienteDAO.salvar(new Cliente(cliente4));
        ClienteDAO.salvar(new Cliente(cliente5));
    }
}
