package src;
import src.repository.ClienteDAO;

import javax.swing.*;

import java.util.List;

import static src.Main.iniciarMenuPrincipal;

public class MainAdson {
    public static void main(String[] args) {

    }

        public static void escolherTipoCliente() {
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
//            String[] opcoes;
//            opcoes = new String[]{"Cli. Pessoa Fisíca","Cli. Pessoa Juridica" }; //Array com as opções de botões que ira aparecer
//
//            //Varialvel resposta vai receber um Int de acordo com a ordem dos botôes Ex: 0,1,2
//            int resposta = JOptionPane.showOptionDialog(
//                    null
//                    , "Que Tipo de cliente você deseja cadastrar? ?" // Mensagem
//                    , "Cadastro de Cliente"   // Titulo
//                    , JOptionPane.YES_NO_OPTION // Estilo da caixinha que ira aparecer
//                    , JOptionPane.PLAIN_MESSAGE
//                    , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência/Endereço da pasta
//                    , opcoes// Array de strings com os valores de cada botão.
//                    , "Botao 3"  // Label do botão Default
//            );

            System.out.println(resposta);

            //Estrutura para cadastro de endereço
            //Foi colocado fora do If pois seria o mesmo tanto ara pessoa fisica quanto juridica
            Endereco nowEndereco = new Endereco(
                    1, //ID por default 1 pois não sei como será incrementa os id's
                    JOptionPane.showInputDialog(null,"Rua: ", "Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
                    Integer.parseInt(JOptionPane.showInputDialog(null,"Número: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)),
                    JOptionPane.showInputDialog(null,"Bairro: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(null,"Cidade: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(null,"CEP: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)
            );

            //If para decidir qual tipo de cliente cadastrar
            if (resposta == 0 ) {
                //Construtores recebendo informações através de cada JOptionPane
                PessoaFisica nowPessoa = new PessoaFisica(
                        1
                        , JOptionPane.showInputDialog(null, "Nome: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , nowEndereco
                        , JOptionPane.showInputDialog(null,"Telefone: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"E-mail: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"CPF: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"Data de Nascimento: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                );

                Cliente nowCliente = new Cliente(nowPessoa);
                return nowCliente;
//                JOptionPane.showMessageDialog(null,"Cadastro Efetuado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
//                System.exit(0);

            } else {

                PessoaJuridica nowPessoa = new PessoaJuridica(
                        1
                        , JOptionPane.showInputDialog(null,"Nome: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , nowEndereco
                        , JOptionPane.showInputDialog(null,"Telefone: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"E-mail: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"Razão Social: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"CNPJ: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"CENAE: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                        , JOptionPane.showInputDialog(null,"Data de Abertura: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                );

                Cliente nowCliente = new Cliente(nowPessoa);
                return nowCliente;
            }
            //System.exit(0);
            //int resposta = JOptionPane.showConfirmDialog(frame,"escolha um", "escolha dois", JOptionPane.YES_NO_OPTION);

        }

        static void chamaRelatorioPessoa() {
            List<Cliente> clientes = ClienteDAO.buscarTodos();
            String listaClientes = "Lista de Pessoas";
            for (Cliente cliente : clientes) {
                listaClientes += "\n" + cliente.getPessoa().getNome() + "  email: " + cliente.getPessoa().getEmail() + "   documento: " + cliente.getPessoa().getDocumentoPrincipal();
            }
            JOptionPane.showMessageDialog(null, listaClientes);
        }

        public static void cadastrarMinhaEmprea() {
        //Função para cadastrar a empresa em que o sistema esta sendo usado

            Endereco nowEndereco = new Endereco(
                    1, //ID por default 1 pois não sei como será incrementa os id's
                    JOptionPane.showInputDialog(null,"Rua: ", "Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
                    Integer.parseInt(JOptionPane.showInputDialog(null,"Número: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)),
                    JOptionPane.showInputDialog(null,"Bairro: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(null,"Cidade: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE),
                    JOptionPane.showInputDialog(null,"CEP: ","Cadastro de Endereço", JOptionPane.QUESTION_MESSAGE)
            );

            PessoaJuridica nowPessoa = new PessoaJuridica(
                    1
                    , JOptionPane.showInputDialog(null,"Nome: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                    , nowEndereco
                    , JOptionPane.showInputDialog(null,"Telefone: ", "Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                    , JOptionPane.showInputDialog(null,"E-mail: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                    , JOptionPane.showInputDialog(null,"Razão Social: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                    , JOptionPane.showInputDialog(null,"CNPJ: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                    , JOptionPane.showInputDialog(null,"CENAE: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
                    , JOptionPane.showInputDialog(null,"Data de Abertura: ","Cadastro de Clientes",JOptionPane.QUESTION_MESSAGE)
            );

            Cliente nowCliente = new Cliente(nowPessoa);
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!","Aviso",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        }



}




