package src.repository;

import src.Produto;
import src.Servico;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {
    static List<Servico> servicos = new ArrayList<>();

    public static void salvar(Servico servico) {
        servico.setId(servicos.size() + 1);
        servicos.add(servico);
    }

    public static List<Servico> buscarTodos() {
        System.out.println(servicos);
        return servicos;
    }

    public static List<Servico> buscarPorDescricao(String descricao) {
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

    public static Servico findServicoByDescricao(String busca) {
        List<Servico> servicos = buscarTodos();

        for (Servico servico : servicos) {
            if (busca.equals(servico.getDescricao())) {
                return servico;
            }
        }
        return null;
    }

    public static Object[] findListaServicoInArray() {
        List<Servico> servicos = ServicoDAO.buscarTodos();
        List<String> servicoNomes = new ArrayList<>();

        for(Servico servico : servicos) {
            servicoNomes.add(servico.getDescricao());
        }

        return servicoNomes.toArray();
    }

    public static void iniciarDadosServico() throws ParseException {
        Servico servico1 = new Servico("Manutenção", "01:30", new BigDecimal(100.00));
        Servico servico2 = new Servico("Limpeza", "01:00", new BigDecimal(100.00));
        Servico servico3 = new Servico("Formatação", "01:00", new BigDecimal(100.00));
        Servico servico4 = new Servico("Troca de Peça", "02:00", new BigDecimal(200.00));

        ServicoDAO.salvar(servico1);
        ServicoDAO.salvar(servico2);
        ServicoDAO.salvar(servico3);
        ServicoDAO.salvar(servico4);
    }
}
