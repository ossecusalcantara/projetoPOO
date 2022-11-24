package src.repository;

import src.Cliente;
import src.OrdemDeServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO {
    static List<OrdemDeServico> ordens = new ArrayList<>();

    public static void salvar(OrdemDeServico ordem) {
        ordens.add(ordem);
    }


    public static List<OrdemDeServico> buscarTodos() {
        System.out.println(ordens);
        return ordens;
    }

    public static List<OrdemDeServico> buscarPorNome(String ordemID){
        List<OrdemDeServico> ordensFiltrados = new ArrayList<>();
        for (OrdemDeServico ordem : ordens) {
            if(ordem.getId().equals(ordemID)) {
                ordensFiltrados.add(ordem);
            }
        }
        return  ordensFiltrados;
    }

    public static Object[] findOrdemInArray() {
        List<OrdemDeServico> ordens = OrdemDeServicoDAO.buscarTodos();
        List<Integer> ordensID = new ArrayList<>();

        for(OrdemDeServico ordem : ordens) {
            ordensID.add(ordem.getId());
        }
        return ordensID.toArray();
    }
}
