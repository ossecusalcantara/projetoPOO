package src.repository;

import src.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    static  List<Cliente> clientes = new ArrayList<>();

    public static void salvar(Cliente cliente) {
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

}
