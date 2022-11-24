package src;

import src.repository.ClienteDAO;
import src.repository.UsuarioDAO;

import javax.swing.*;

import java.text.ParseException;

import static src.MainAdson.*;
import static src.MainKaiana.cadastrarProduto;
import static src.MainKaiana.cadastrarServico;

public class Main {
    public static void main(String[] args) throws ParseException {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);

    }

    //Função MenuPrincipal
    public static void iniciarMenuPrincipal() throws ParseException {
        String[] opcoes;
        opcoes = new String[]{"Cadastros", "Ordem de Serviço", "Relatório",  "Gerar Nota Fiscal","Sair"}; //Array com as opções de botões que ira aparecer

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
            case 2: //Notas
                //gerarNotaFiscal();
                break;
            case 3: //SAIR

                break;
        }

    }

    //Função com opções de Cadastro
    public static void chamarMenuCadastros() throws ParseException {
        String[] opcoes;
        opcoes = new String[]{"Cliente", "Produto", "Serviço","Voltar"}; //Array com as opções de botões que ira aparecer

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
                    Produto produto = cadastrarProduto();
                    //ProdutoDAO.salvar(produto)
                    iniciarMenuPrincipal();
                break;
            case 2: // Cadastro de Serviço
                    Servico servico = cadastrarServico();
                    src.ServicoDAO.salvar(servico);
                    iniciarMenuPrincipal();
                break;
            case 3: //SAIR
                    iniciarMenuPrincipal();
                break;
        }

    }

    public static void chamarMenuRelatorio() throws ParseException {
        String[] opcoes;
        opcoes = new String[]{"Cliente", "Produtos", "Serviço","Voltar"}; //Array com as opções de botões que ira aparecer

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
                // chamaRelatorioProduto();
                iniciarMenuPrincipal();
                break;
            case 2: // Cadastrar Produto
                // chamaRelatorioProduto();
                iniciarMenuPrincipal();
                break;
            case 3: //SAIR
                iniciarMenuPrincipal();
                break;
        }

    }

    private static void checaSenhaUsuario(Object usuarioLogado) throws ParseException {
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
