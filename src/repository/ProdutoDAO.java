package src.repository;

import src.Estoque;
import src.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    static List<Produto> produtos = new ArrayList<>();

    public static void salvar(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> buscarTodos() {
        System.out.println(produtos);
        return produtos;
    }

    public static List<Produto> buscarPorNome(String nome){
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if(produto.getDescricao().contains(nome)) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    public static Object[] findListaProdutoInArray() {
        List<Produto> produtos = ProdutoDAO.buscarTodos();
        List<String> produtoNomes = new ArrayList<>();

        for(Produto produto : produtos) {
            produtoNomes.add(produto.getDescricao());
        }

        return produtoNomes.toArray();
    }

}
