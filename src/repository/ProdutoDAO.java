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

        return produtoList;
    }

    public static void salvar(Produto produto) {
        produto.setId(produtos.size() + 1);
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
            if (busca.equals(produto.getDescricao())) {
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

    public static void IniciarDadosProduto() {
        Produto produto1 = new Produto( "Galaxy s20", 10, Marca.SAMSUNG);
        produto1.setId(1);
        Produto produto2 = new Produto( "SmarthWatch", 10, Marca.LG);
        produto2.setId(2);
        Produto produto3 = new Produto( "iPhone", 10, Marca.APPLE);
        produto3.setId(3);
        Produto produto4 = new Produto( "Edge 20", 10, Marca.MOTOROLLA);
        produto4.setId(4);
        Produto produto5 = new Produto( "Honor x-8", 10, Marca.HUAWEI);
        produto5.setId(5);

        ProdutoDAO.salvar(produto1);
        ProdutoDAO.salvar(produto2);
        ProdutoDAO.salvar(produto3);
        ProdutoDAO.salvar(produto4);
        ProdutoDAO.salvar(produto5);
    }

}
