package src.repository;

import src.Item;
import src.Produto;

import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    static List<Item> itens = new ArrayList<>();

    public static void salvar(Item item) {itens.add(item);}

    public static List<Item> buscarTodos() {
        System.out.println(itens);
        return itens;
    }

    public static List<Item> buscarPorNome(String nome){
        List<Item> itensFiltrados = new ArrayList<>();
        for (Item item : itens) {
            if(item.getDescricao().contains(nome)) {
                itensFiltrados.add(item);
            }
        }
        return itensFiltrados;
    }

    public static Object[] findListaItensInArray(){
        List<Item> itens = ItemDAO.buscarTodos();
        List<String> itemNomes = new ArrayList<>();

        for(Item item : itens){
            itemNomes.add(item.getDescricao());
        }
        return itemNomes.toArray();
    }
}
