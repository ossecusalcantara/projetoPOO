package src;

import src.repository.*;

import javax.swing.*;

import java.text.ParseException;

import static src.AppFuncoesCadastro.*;

public class AppMain {
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);

    }

    //Função MenuPrincipal
    public static void iniciarMenuPrincipal() throws ParseException, ClassNotFoundException {
        ClienteDAO.iniciarDadosCliente();
        ProdutoDAO.IniciarDadosProduto();
        ServicoDAO.iniciarDadosServico();

        String[] opcoes;
        opcoes = new String[]{"Cadastros", "Ordem de Serviço", "Relatório",  "Gerar Nota Fiscal","Sair"}; //Array com as opções de botões que ira aparecer

        int resposta = JOptionPane.showOptionDialog(
                null
                , "Escolha uma opção:" // Mensagem
                , "Menu"  // Titulo
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
            case 1: //Ordem de Serviço
                OrdemDeServico servico = cadastrarOS();
                OrdemDeServicoDAO.salvar(servico);
                iniciarMenuPrincipal();
                break;
            case 2: //Relatorios
                chamarMenuRelatorio();
                break;
            case 3: //Relatorios
                //chamarGerarNotaFical();
                break;
            case 4: //SAIR
                System.exit(0);
                break;
        }

    }

    //Função com opções de Cadastro
    public static void chamarMenuCadastros() throws ParseException, ClassNotFoundException {
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
                    ProdutoDAO.salvar(produto);
                    iniciarMenuPrincipal();
                break;
            case 2: // Cadastro de Serviço
                    Servico servico = cadastrarServico();
                    ServicoDAO.salvar(servico);
                    iniciarMenuPrincipal();
                break;
            case 3: //SAIR
                    iniciarMenuPrincipal();
                break;
        }

    }

    public static void chamarMenuRelatorio() throws  ClassNotFoundException, ParseException {
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
                chamaRelatorioProduto();
                iniciarMenuPrincipal();
                break;
            case 2: // Cadastrar Produto
                // chamaRelatorioServico();
                iniciarMenuPrincipal();
                break;
            case 3: //SAIR
                iniciarMenuPrincipal();
                break;
        }

    }

    private static void checaSenhaUsuario(Object usuarioLogado) throws ParseException, ClassNotFoundException {
        String senhaDigitada = JOptionPane.showInputDialog(null, "Digite a senha (" + usuarioLogado + ")", "Login", JOptionPane.QUESTION_MESSAGE);
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
        Object selection = JOptionPane.showInputDialog(null, "Selecione o usúario:",
                "Login", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        return selection;
    }
}
