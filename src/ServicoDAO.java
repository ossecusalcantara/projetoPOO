package src;

import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    static List<Servico> servicos = new ArrayList<>();

    public static void salvar(Servico servico) {
        servicos.add(servico);
    }

    public static List<Servico> buscarTodos() {
        System.out.println(servicos);
        return servicos;
    }

    public static List<Servico> buscarPorDescricao (String descricao) {
        List<Servico> filtrado = new ArrayList<>();
        for (Servico servico : servicos) {
            if (servico.getDescricao().contains(descricao)) {
                filtrado.add(servico);
            }
        }

        return filtrado;
    }

    public static Object[] findServicosInArray () {
        List<String> servicosNomes = new ArrayList<>();

        for (Servico servico : servicos) {
            servicosNomes.add(servico.getDescricao());
        }

        return servicosNomes.toArray();
    }


}
