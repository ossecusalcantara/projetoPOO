package src;

import src.repository.*;

import javax.swing.*;

import java.text.ParseException;
import java.util.List;

import static src.AppFuncoesCadastro.*;
import static src.repository.ProdutoDAO.getProdutoDAO;
import static src.repository.ServicoDAO.getServicoDAO;

public class AppMain {
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        ClienteDAO.iniciarDadosCliente();
        ProdutoDAO.IniciarDadosProduto();
        ServicoDAO.iniciarDadosServico();
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);

    }

    //Função MenuPrincipal
    public static void iniciarMenuPrincipal() throws ParseException, ClassNotFoundException {

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
                NotaFiscal nota = gerarNotaFiscal();
                NotaFiscalDAO.salvar(nota);
                iniciarMenuPrincipal();
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
//                    Produto produto = cadastrarProduto();
//                    ProdutoDAO.salvar(produto);
//                    iniciarMenuPrincipal();
                    chamaCadastroProduto();
                break;
            case 2: // Cadastro de Serviço
//                    Servico servico = cadastrarServico();
//                    ServicoDAO.salvar(servico);
//                    iniciarMenuPrincipal();
                    chamaCadastroServico();
                break;
            case 3: //SAIR
                    iniciarMenuPrincipal();
                break;
        }

    }

    private static Produto chamaCadastroProduto() throws ParseException, ClassNotFoundException {
        Integer OpcoesCrud = chamaOpcoesCrud();
        Produto produto = null;
        switch (OpcoesCrud) {
            case 0: //Inserção de produto
                produto = cadastrarProduto();
                ProdutoDAO.salvar(produto);
                chamarMenuCadastros();
                break;
            case 1: //Alteração de produto
                produto = SelecionaProduto();
                produto = editaProduto(produto);
                chamarMenuCadastros();
                break;
            case 2: //Exclusão de produto
                produto = SelecionaProduto();
                getProdutoDAO().remover(produto);
                produto = null;
                chamarMenuCadastros();
        }

        return produto;
    }

    private static Servico chamaCadastroServico() throws ParseException, ClassNotFoundException {
        Integer OpcoesCrud = chamaOpcoesCrud();
        Servico servico = null;
        switch (OpcoesCrud) {
            case 0: //Inserção de Servico
                servico = cadastrarServico();
                ServicoDAO.salvar(servico);
                chamarMenuCadastros();
                break;
            case 1: //Alteração de Servico
                servico = SelecionaServico();
                servico = editaServico(servico);
                chamarMenuCadastros();
                break;
            case 2: //Exclusão de Servico
                servico = SelecionaServico();
                getServicoDAO().remover(servico);
                servico = null;
                chamarMenuCadastros();
        }

        return servico;
    }

    public static void chamarMenuRelatorio() throws  ClassNotFoundException, ParseException {
        String[] opcoes;
        opcoes = new String[]{"Clientes", "Produtos", "Serviços","Nota Fiscais","Ordem de Serviço","Voltar"}; //Array com as opções de botões que ira aparecer

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
                //iniciarMenuPrincipal();
                break;
            case 1: //Mostrar Relatório de Produto
                chamaRelatorioProduto();
                //iniciarMenuPrincipal();
                break;
            case 2: // Mostrar Relatorio Serviços
                chamaRelatorioServicos();
                //iniciarMenuPrincipal();
                break;
            case 3: // Mostrar Relatorio Notas Fiscais
                chamaRelatorioNotas();
                //iniciarMenuPrincipal(); chamaRelatorioOS()
                break;
            case 4: // Mostrar Relatorio OS
                chamaRelatorioOS();
                //iniciarMenuPrincipal();
                break;
            case 5: //SAIR
                iniciarMenuPrincipal();
                break;
        }

    }

    private static Integer chamaOpcoesCrud() {
        String[] opcoes = {"Inclusão", "Alteração", "Exclusão"};
        int opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção: ", "Operação no cadastro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        return opcao;
    }

    private static Produto SelecionaProduto() {
        Object[] selectionValuesProduto = getProdutoDAO().findListaProdutoInArray();
        String initialSelectionProduto = (String) selectionValuesProduto[0];
        Object selectionProduto = JOptionPane.showInputDialog(null, "Selecione o produto: ",
                "Produtos", JOptionPane.QUESTION_MESSAGE, null, selectionValuesProduto, initialSelectionProduto);
        List<Produto> produtos = getProdutoDAO().buscarPorNome((String) selectionProduto);
        return produtos.get(0);
    }

    private static Servico SelecionaServico() {
        Object[] selectionValuesServico = getServicoDAO().findListaServicoInArray();
        String initialSelectionServico = (String) selectionValuesServico[0];
        Object selectionServico = JOptionPane.showInputDialog(null, "Selecione o servico: ",
                "Servicos", JOptionPane.QUESTION_MESSAGE, null, selectionValuesServico, initialSelectionServico);
        List<Servico> servicos = getServicoDAO().buscarPorDescricao((String) selectionServico);
        return servicos.get(0);
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
