package src.repository;

import src.Estoque;
import src.OrdemDeServico;
import src.Servico;

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

    public static OrdemDeServico findOsByTitulo(String busca) {
        List<OrdemDeServico> ordens = buscarTodos();

        for (OrdemDeServico os : ordens) {
            if (busca.equals(os.getTitulo())) {
                return os;
            }
        }
        return null;
    }

    public static Object[] findListaOsInArray() {
        List<OrdemDeServico> ordemDeServicos = OrdemDeServicoDAO.buscarTodos();
        List<String> servicoTitulo = new ArrayList<>();

        for(OrdemDeServico ordemDeServico : ordemDeServicos) {
            servicoTitulo.add(ordemDeServico.getTitulo());
        }

        return servicoTitulo.toArray();
    }
}
