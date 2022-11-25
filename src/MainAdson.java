package src;
import src.repository.ClienteDAO;
import src.repository.ProdutoDAO;
import src.repository.UsuarioDAO;

import javax.swing.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

import static src.Main.iniciarMenuPrincipal;

public class MainAdson {
    public static void main(String[] args) {

    }

        public static void escolherTipoCliente() throws ParseException {
            String[] opcoes;
            opcoes = new String[]{"Cli. Pessoa Fisíca","Cli. Pessoa Juridica","Voltar" };

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
                case 0: // Cadastrar Pessoa Fisica
                        Cliente cliente0 = cadastrarPessoa(0);
                        ClienteDAO.salvar(cliente0);
                        iniciarMenuPrincipal();
                    break;
                case 1: // Cadastrar Pessoa Juridica
                        Cliente cliente1 = cadastrarPessoa(1);
                        ClienteDAO.salvar(cliente1);
                        iniciarMenuPrincipal();
                    break;
                case 2: //SAIR
                        iniciarMenuPrincipal();
                    break;
            }
        }

        public static Cliente cadastrarPessoa(int resposta) {
            System.out.println(resposta);
            Pessoa nowPessoa;

            //If para decidir qual tipo de cliente cadastrar
            if (resposta == 0 ) {
                //Construtores recebendo informações através de cada JOptionPane
                nowPessoa = new PessoaFisica(
                        JOptionPane.showInputDialog(null, "Nome: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"Telefone: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"E-mail: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"CPF: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                );

                try {
                    nowPessoa.setData(JOptionPane.showInputDialog(null,"Data de Nascimento: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Digite a data (dd/mm/yyyy)","Erro", JOptionPane.ERROR_MESSAGE);
                    nowPessoa.setData(JOptionPane.showInputDialog(null,"Data de Nascimento: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE));
                }

            } else {

                nowPessoa = new PessoaJuridica(
                        JOptionPane.showInputDialog(null,"Nome: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"Telefone: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"E-mail: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"Razão Social: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"CNPJ: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"CENAE: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                );

                try {
                    nowPessoa.setData(JOptionPane.showInputDialog(null,"Data de Abertura: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Digite a data (dd/mm/yyyy)","Erro", JOptionPane.ERROR_MESSAGE);
                    nowPessoa.setData(JOptionPane.showInputDialog(null,"Data de Abertura: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE));
                }

            }

            Endereco nowEndereco = new Endereco();

            nowEndereco.setLogradouro(JOptionPane.showInputDialog(null,"Rua: ", "Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE));
            try {
                nowEndereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null,"Número: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Digite apenas números inteiros!!","Erro", JOptionPane.ERROR_MESSAGE);
                nowEndereco.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null,"Número: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)));
            }
            nowEndereco.setBairro(JOptionPane.showInputDialog(null,"Bairro: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE));
            nowEndereco.setCidade(JOptionPane.showInputDialog(null,"Cidade: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE));
            nowEndereco.setCep(JOptionPane.showInputDialog(null,"CEP: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE));

            nowPessoa.setEndereco(nowEndereco);
            Cliente nowCliente = new Cliente(nowPessoa);

            return nowCliente;

        }

        static void chamaRelatorioPessoa() {
            List<Cliente> clientes = ClienteDAO.buscarTodos();
            String listaClientes = "Lista de Pessoas";
            for (Cliente cliente : clientes) {
                listaClientes += "\n Id" + Integer.toString(cliente.getPessoa().getId()) + "Nome: " + cliente.getPessoa().getNome() + "  email: " + cliente.getPessoa().getEmail() + "   documento: " + cliente.getPessoa().getDocumentoPrincipal();
            }
            JOptionPane.showMessageDialog(null, listaClientes);
        }

//        public static PessoaJuridica cadastrarMinhaEmprea() {
//        //Função para cadastrar a empresa em que o sistema esta sendo usado
//
//            Endereco nowEndereco = new Endereco(
//                    1, //ID por default 1 pois não sei como será incrementa os id's
//                    JOptionPane.showInputDialog(null,"Rua: ", "Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
//                    Integer.parseInt(JOptionPane.showInputDialog(null,"Número: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)),
//                    JOptionPane.showInputDialog(null,"Bairro: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
//                    JOptionPane.showInputDialog(null,"Cidade: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
//                    JOptionPane.showInputDialog(null,"CEP: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)
//            );
//
//            PessoaJuridica nowPessoa = new PessoaJuridica(
//                    1
//                    , JOptionPane.showInputDialog(null,"Nome: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//                    , nowEndereco
//                    , JOptionPane.showInputDialog(null,"Telefone: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//                    , JOptionPane.showInputDialog(null,"E-mail: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//                    , JOptionPane.showInputDialog(null,"Razão Social: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//                    , JOptionPane.showInputDialog(null,"CNPJ: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//                    , JOptionPane.showInputDialog(null,"CENAE: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//                    , JOptionPane.showInputDialog(null,"Data de Abertura: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
//            );
//
//            return nowPessoa;
//        }

        private static Object chamaSelecaoProduto() {
            // Select para escolher o produto
            Object[] selectionValues = ProdutoDAO.findListaProdutoInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o usuario?",
                    "SeguradoraAPP", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            return selection;
        }

//        public static NotaFiscal gerarNotaFiscal() {
//            BigDecimal valor;
//            // List que ira conter itens da nota
//            List<Item> itensNota = new ArrayList<>();
//
//            Object opcaoSelecionada = chamaSelecaoProduto();
//
//            Produto produtoSelecionado = ProdutoDAO.findProdutoByDescricao((String) opcaoSelecionada);
//            Item newItem = new ItemProduto(
//                    1,
//                    2 ,
//                    new BigDecimal("10"),
//                    new BigDecimal("10"),
//                    new BigDecimal("10"),
//                    TipoItem.PRODUTO,
//                    produtoSelecionado
//                    );
//
//            itensNota.add(newItem);
//
//            NotaFiscal nowNota = new NotaFiscal(
//                    1
//                    , new Date()
//                    , TipoNota.ENTRADA
//                    , 123456
//                    , valor = new BigDecimal(123)
//                    ,
//            );
//
//            return nowNota;
//        }



}




