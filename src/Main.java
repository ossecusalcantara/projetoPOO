package src;

import src.repository.UsuarioDAO;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Object usuarioLogado = chamaSelecaoUsuario();
        checaSenhaUsuario(usuarioLogado);

    }

    public static void iniciarMenuPrincipal() {
        String[] opcoes;
        opcoes = new String[]{"Cadastrar Cliente", "Ordem de Serviço", "Gerar Relatório", "Gerar Nota Fiscal", "Minha Empresa","Sair"}; //Array com as opções de botões que ira aparecer

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
            case 0: //Pessoa
//                Pessoa pessoa = chamaCadastroPessoa();
//                PessoaDAO.salvar(pessoa);
//                chamaMenuCadastros();
                break;
            case 1: //Seguradoras
//                Seguradora seguradora = chamaCadastroSeguradora();
//                SeguradoraDAO.salvar(seguradora);
//                chamaMenuCadastros();
                break;
            case 2: //Seguro

                break;
            case 3: //SAIR

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
