package src;

import javax.swing.*;

public class MainAdson {
    public static void main(String[] args) {
        iniciarPrograma();
    }

        public static void cadastrarPessoa() {
            String[] opcoes;
            opcoes = new String[]{"Cli. Pessoa Fisíca","Cli. Pessoa Juridica" }; //Array com as opções de botões que ira aparecer

            //Varialvel resposta vai receber um Int de acordo com a ordem dos botôes Ex: 0,1,2
            int resposta = JOptionPane.showOptionDialog(
                    null
                    , "Que Tipo de cliente você deseja cadastrar? ?" // Mensagem
                    , "Cadastro de Cliente"   // Titulo
                    , JOptionPane.YES_NO_OPTION // Estilo da caixinha que ira aparecer
                    , JOptionPane.PLAIN_MESSAGE
                    , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência/Endereço da pasta
                    , opcoes// Array de strings com os valores de cada botão.
                    , "Botao 3"  // Label do botão Default
            );

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

                JOptionPane.showMessageDialog(null,"Cadastro Efetuado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);

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
                JOptionPane.showMessageDialog(null, "Cadastro Efetuado!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);

            }


            //System.exit(0);
            //int resposta = JOptionPane.showConfirmDialog(frame,"escolha um", "escolha dois", JOptionPane.YES_NO_OPTION);
            //verfica se a resposta é verdadeira

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

        //Função que podera ser usada na entrada do programa no nosso Main Opções de Atividade a ser feita
        public static void iniciarPrograma() {
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

            if (resposta == 0) {
                cadastrarPessoa();
            } else if (resposta == 1) {
                //Função ordem de Serviço
            } else if (resposta == 2) {
                //Função de gerar relatório
            } else if (resposta == 3) {
                // Função de gerar nota
            } else if(resposta == 4) {
                cadastrarMinhaEmprea();
            } else {
                System.exit(0);
            }

        }

}




