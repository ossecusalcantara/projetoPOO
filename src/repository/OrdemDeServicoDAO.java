package src.repository;

import src.Estoque;
import src.OrdemDeServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO {
    static List<OrdemDeServico> ordemservico = new ArrayList<>();

    public static void salvar(OrdemDeServico dadoservico) {

        dadoservico.setId(ordemservico.size() +1);
        ordemservico.add(dadoservico);
    }

    public static List<OrdemDeServico> buscarTodos() {
        System.out.println(ordemservico);
        return ordemservico;
    }

    public static List<OrdemDeServico> buscarPorNome(String numero){
        Integer numeroInt = Integer.parseInt(numero);
        List<OrdemDeServico> servicoFiltrados = new ArrayList<>();
        for (OrdemDeServico ordemservico : ordemservico) {
            if(ordemservico.getId() == numeroInt) {
                servicoFiltrados.add(ordemservico);
            }
        }
        return servicoFiltrados;
    }

    public static Object[] findListaEstoqueInArray() {
        List<OrdemDeServico> ordemDeServicos = OrdemDeServicoDAO.buscarTodos();
        List<Integer> servicoId = new ArrayList<>();

        for(OrdemDeServico ordemDeServico : ordemDeServicos) {
            servicoId.add(ordemDeServico.getId());
        }

        return servicoId.toArray();
    }
}
