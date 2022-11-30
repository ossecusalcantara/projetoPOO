package src.repository;

import src.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public static void IniciarDadosOrdemServico() {
        OrdemDeServico os1 = new OrdemDeServico();
        os1.setDataEntrada(LocalDate.now());
        os1.setDataLimite(LocalDate.now());
        os1.setTitulo("Manutenção Smartphone");
        ItemServico item1 = new ItemServico();
        item1.setQuantidade(1);
        Servico servico = ServicoDAO.findServicoByDescricao("Manutenção");
        BigDecimal valorServico = servico.getValor();
        item1.setValorUnitario(valorServico);
        item1.setValorTotal(valorServico);
        item1.setServico(servico);
        item1.setTipoItem(TipoItem.SERVICO);
        os1.setItemAdd(item1);
        os1.setValorTotal();

        OrdemDeServico os2 = new OrdemDeServico();
        os2.setDataEntrada(LocalDate.now());
        os2.setDataLimite(LocalDate.now());
        os2.setTitulo("Limpeza de Notebook");
        ItemServico item2 = new ItemServico();
        item2.setQuantidade(1);
        Servico servico2 = ServicoDAO.findServicoByDescricao("Limpeza");
        BigDecimal valorServico2 = servico.getValor();
        item2.setValorUnitario(valorServico2);
        item2.setValorTotal(valorServico2);
        item2.setServico(servico2);
        item2.setTipoItem(TipoItem.SERVICO);
        os2.setItemAdd(item2);
        os2.setValorTotal();

        OrdemDeServico os3 = new OrdemDeServico();
        os3.setDataEntrada(LocalDate.now());
        os3.setDataLimite(LocalDate.now());
        os3.setTitulo("Manutenção e Limpeza");
        ItemServico item3 = new ItemServico();
        item3.setQuantidade(1);
        Servico servico3 = ServicoDAO.findServicoByDescricao("Limpeza");
        BigDecimal valorServico3 = servico3.getValor();
        item3.setValorUnitario(valorServico3);
        item3.setValorTotal(valorServico3);
        item3.setServico(servico3);
        item3.setTipoItem(TipoItem.SERVICO);
        os3.setItemAdd(item3);
        os3.setValorTotal();

        ItemServico item4 = new ItemServico();
        item4.setQuantidade(1);
        Servico servico4 = ServicoDAO.findServicoByDescricao("Formatação");
        BigDecimal valorServico4 = servico4.getValor();
        item4.setValorUnitario(valorServico4);
        item4.setValorTotal(valorServico4);
        item4.setServico(servico4);
        item4.setTipoItem(TipoItem.SERVICO);
        os3.setItemAdd(item4);
        os3.setValorTotal();
        OrdemDeServicoDAO.salvar(os1);
        OrdemDeServicoDAO.salvar(os2);
        OrdemDeServicoDAO.salvar(os3);

    }
}
