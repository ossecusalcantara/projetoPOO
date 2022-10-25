package src;

import src.repository.ClienteDAO;
import src.repository.UsuarioDAO;

import javax.swing.*;

import static src.MainAdson.*;

public class Main {
    public static void main(String[] args) {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);

    }

    public static void iniciarMenuPrincipal() {
        String[] opcoes;
        opcoes = new String[]{"Cadastros", "Serviço", "Relatório",  "Minha Empresa","Sair"}; //Array com as opções de botões que ira aparecer

        int resposta = JOptionPane.showOptionDialog(
                null
                , "Escolha uma opção:" // Mensagem
                , "Inicio"  // Titulo
                , JOptionPane.YES_NO_OPTION // Estilo da caixinha que ira aparecer
                , JOptionPane.PLAIN_MESSAGE
                , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência/Endereço da pasta
                , opcoes// Array de strings com os valores de cada botão.
                , "Botao 3"  // Label do botão Default
        );

        switch (resposta) {
            case 0:
                chamarMenuCadastros();
                break;
            case 1: //Seguradoras
                chamarMenuRelatorio();
                break;
            case 2: //Seguro
                chamarMenuRelatorio();
                break;
            case 3: //SAIR

                break;
        }

    }

    public static void chamarMenuCadastros() {
        String[] opcoes;
        opcoes = new String[]{"Cliente", "Produto", "Serviço","Sair"}; //Array com as opções de botões que ira aparecer

        int resposta = JOptionPane.showOptionDialog(
                null
                , "Escolha uma opção:" // Mensagem
                , "Inicio"  // Titulo
                , JOptionPane.YES_NO_OPTION // Estilo da caixinha que ira aparecer
                , JOptionPane.PLAIN_MESSAGE
                , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência/Endereço da pasta
                , opcoes// Array de strings com os valores de cada botão.
                , "Botao 3"  // Label do botão Default
        );

        switch (resposta) {
            case 0: // Cadastrar Cliente
                escolherTipoCliente();
              break;
            case 1: // Cadastrar Produto
//                Produto produto = cadastrarProduto();
//                ProdutoDao.salvar(produto);
//                chamaMenuCadastros();
                break;
            case 2: // Cadastro de Serviço
//                  Servico servico = casdatrarServico();
//                  ServicoDAO.salvar(servico);
//                  chamaMenuCadastros();
                break;
            case 3: //SAIR
                    iniciarMenuPrincipal();
                break;
        }

    }

    public static void chamarMenuRelatorio() {
        String[] opcoes;
        opcoes = new String[]{"Cliente", "Produtos","Sair"}; //Array com as opções de botões que ira aparecer

        int resposta = JOptionPane.showOptionDialog(
                null
                , "Escolha uma opção:" // Mensagem
                , "Inicio"  // Titulo
                , JOptionPane.YES_NO_OPTION
                , JOptionPane.PLAIN_MESSAGE
                , null
                , opcoes
                , "Botao 3"  // Label do botão Default
        );

        switch (resposta) {
            case 0: // Mostrar Relatório de Cliente
                chamaRelatorioPessoa();
                iniciarMenuPrincipal();
                break;
            case 1: // Cadastrar Produto
//                Produto produto = cadastrarProduto();
//                ProdutoDao.salvar(produto);
//                chamaMenuCadastros();
                break;
            case 2: //SAIR
                iniciarMenuPrincipal();
                break;
        }

    }

    private static void checaSenhaUsuario(Object usuarioLogado) {
        String senhaDigitada = JOptionPane.showInputDialog(null, "Informe a senha do usuario (" + usuarioLogado + ")");
        Usuario usuarioByLogin = UsuarioDAO.findUsuarioByLogin((String) usuarioLogado);

        if (usuarioByLogin.getSenha().equals(senhaDigitada)) {
            iniciarMenuPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!");
            checaSenhaUsuario(usuarioLogado);
        }
    }

    private static Object chamaSelecaoUsuario() {
        Object[] selectionValues = UsuarioDAO.findUsuariosSistemaInArray();
        String initialSelection = (String) selectionValues[0];
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usuario?",
                "SeguradoraAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return selection;
    }
}
