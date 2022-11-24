package src.repository;

import src.Estoque;
import src.Marca;
import src.Produto;
import src.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    static List<Produto> produtos = new ArrayList<>();

    public static List<Produto> findUProdutos() {
        List<Produto> produtoList = new ArrayList<>();

        Produto produto1 = new Produto(1, "Celular", "Smarthphone", Marca.SAMSUNG);
        Produto produto2 = new Produto(2, "Celular", "Smarthphone", Marca.SAMSUNG);
        Produto produto3 = new Produto(3, "Celular", "Smarthphone", Marca.SAMSUNG);
        Produto produto4 = new Produto(4, "Celular", "Smarthphone", Marca.SAMSUNG);
        Produto produto5 = new Produto(5, "Celular", "Smarthphone", Marca.SAMSUNG);
        produtoList.add(produto1);
        produtoList.add(produto2);
        produtoList.add(produto3);
        produtoList.add(produto4);
        produtoList.add(produto5);

        return produtoList;
    }

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

    public static Produto findProdutoByDescricao(String busca) {
        List<Produto> produtos = buscarTodos();

        for (Produto produto : produtos) {
            if (busca.equals(produto)) {
                return produto;
            }
        }
        return null;
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
