package src.repository;

import src.Cliente;
import src.Estoque;

import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    static List<Estoque> estoques = new ArrayList<>();

    public static void salvar(Estoque dadoestoque) {
        estoques.add(dadoestoque);
    }

    public static List<Estoque> buscarTodos() {
        System.out.println(estoques);
        return estoques;
    }

    public static List<Estoque> buscarPorNome(String busca){
        List<Estoque> estoqueFiltrados = new ArrayList<>();
        for (Estoque estoque : estoques) {
            if(estoque.getProduto().getDescricao() .contains(busca)) {
                estoqueFiltrados.add(estoque);
            }
        }
        return estoqueFiltrados;
    }

    public static Object[] findListaEstoqueInArray() {
        List<Estoque> estoques = EstoqueDAO.buscarTodos();
        List<String> produtoNomes = new ArrayList<>();

        for(Estoque estoque : estoques) {
            produtoNomes.add(estoque.getProduto().getDescricao());
        }

        return produtoNomes.toArray();
    }
}
