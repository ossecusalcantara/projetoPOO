package src;
import src.form.RelatorioPessoaForm;
import src.form.RelatorioProdutoForm;
import src.repository.ClienteDAO;
import src.repository.OrdemDeServicoDAO;
import src.repository.ProdutoDAO;
import src.repository.ServicoDAO;

import javax.swing.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static src.AppMain.iniciarMenuPrincipal;

public class AppFuncoesCadastro {
    public static void main(String[] args) {

    }

        public static void escolherTipoCliente() throws ParseException, ClassNotFoundException {
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
        //Funções de cadastro
        public static Cliente cadastrarPessoa(int resposta) {
            System.out.println(resposta);
            Pessoa nowPessoa;

            //If para decidir qual tipo de cliente cadastrar
            if (resposta == 0 ) {
                //Cadastro Cliente Pessoa Física
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
                //Cadastro Cliente Pessoa Juridica
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

            //Cadastro de Endereço do Cliente
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

            // Atribuição do endereço ao cliente e retorno
            nowPessoa.setEndereco(nowEndereco);
            Cliente nowCliente = new Cliente(nowPessoa);

            return nowCliente;

        }



        public static Produto cadastrarProduto() {

            Produto nowProduto = new Produto (
                    JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                    Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)),
                    chamaSelecaoMarca()
            );

            //Processo para adicionar estoque ass: Adson
//            Estoque estoque = new Estoque(
//                    1 // Id Teste
//                    , nowProduto
//                    , Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade do Produto para Estoque: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE))
//            );

            return nowProduto;

        }

        public static Servico cadastrarServico() throws ParseException {
            BigDecimal valor;
            Servico nowServico = new Servico (
                    JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE)
            );

            try {
                nowServico.setTempo(JOptionPane.showInputDialog(null,"Tempo Médio(HH:mm): ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE));
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null,"Formato de tempo incorreto!!","Erro", JOptionPane.ERROR_MESSAGE);
                nowServico.setTempo(JOptionPane.showInputDialog(null,"Tempo Médio(HH:mm): ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE));
            }

            try {
                valor = new BigDecimal(JOptionPane.showInputDialog(null,"Valor: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE));
                nowServico.setValor(valor);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"ERRO!!","Erro", JOptionPane.ERROR_MESSAGE);
                valor = new BigDecimal(JOptionPane.showInputDialog(null,"Valor: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE));
                nowServico.setValor(valor);
            }

            return nowServico;
        }

        public static OrdemDeServico cadastrarOS() {
            OrdemDeServico nowOrdem = new OrdemDeServico();

            nowOrdem.setTitulo(JOptionPane.showInputDialog(null,"Titulo: ", "Cadastro de OS", JOptionPane.QUESTION_MESSAGE));
            nowOrdem.setCondicao(JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de OS", JOptionPane.QUESTION_MESSAGE));
            nowOrdem.setDataEntrada(LocalDate.now());

            try {
                nowOrdem.setDataFormatada(JOptionPane.showInputDialog(null,"Data Limite (para conclusão): ","Cadastro de OS",JOptionPane.QUESTION_MESSAGE), 2);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Digite a data (dd/mm/yyyy)","Erro", JOptionPane.ERROR_MESSAGE);
                nowOrdem.setDataFormatada(JOptionPane.showInputDialog(null,"Data Limite (para conclusão): ","Cadastro de OS",JOptionPane.QUESTION_MESSAGE), 2);
            }

            boolean verifica = true;
            do {

                String[] opcoes;
                opcoes = new String[]{"Serviços", "Produtos", "Voltar"}; //Array com as opções de botões que ira aparecer

                int resposta = JOptionPane.showOptionDialog(
                        null
                        , "Escolha uma opção para adicionar:" // Mensagem
                        , "Cadastro de OS"  // Titulo
                        , JOptionPane.YES_NO_OPTION // Estilo da caixinha que ira aparecer
                        , JOptionPane.PLAIN_MESSAGE
                        , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência/Endereço da pasta
                        , opcoes// Array de strings com os valores de cada botão.
                        , "Botao 3"  // Label do botão Default
                );

                switch (resposta) {
                    case 0: //Adicionando Serviço
                        Object ServicoSelecionado = chamaSelecaoServico();
                        Servico servico = ServicoDAO.findServicoByDescricao((String) ServicoSelecionado);
                        ItemServico nowItemS = new ItemServico();
                        nowItemS.setValorTotal(servico.getValor());
                        nowItemS.setServico(servico);
                        nowOrdem.setItemAdd(nowItemS);
                        break;
                    case 1: //Adicionando Produto
                        Object produtoSelecionado = chamaSelecaoProduto();
                        ItemProduto nowItemP = new ItemProduto();
                        nowItemP.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade: ", "Cadastro de OS", JOptionPane.QUESTION_MESSAGE)));
                        nowItemP.setValorUnitario(new BigDecimal(JOptionPane.showInputDialog(null,"Valor Unitario: ", "Cadastro de OS", JOptionPane.QUESTION_MESSAGE)));
                        BigDecimal qtd = new BigDecimal(nowItemP.getQuantidade());
                        nowItemP.setValorTotal(qtd.multiply(nowItemP.getValorUnitario()));
                        nowItemP.setProduto(ProdutoDAO.findProdutoByDescricao((String) produtoSelecionado));
                        nowOrdem.setItemAdd(nowItemP);
                        break;
                    case 2: //SAIR
                        System.exit(0);
                        break;
                }

                String[] confirm;
                confirm = new String[]{"Sim", "Não"}; //Array com as opções de botões que ira aparecer

                int valor = JOptionPane.showOptionDialog(
                        null
                        , "Deseja adicionar outro item:" // Mensagem
                        , "Cadastro de OS"  // Titulo
                        , JOptionPane.YES_NO_OPTION // Estilo da caixinha que ira aparecer
                        , JOptionPane.PLAIN_MESSAGE
                        , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência/Endereço da pasta
                        , confirm// Array de strings com os valores de cada botão.
                        , "Botao 3"  // Label do botão Default
                );

                if (valor == 1 ){
                    verifica = false;
                }

            } while (verifica);

            return nowOrdem;
        }

        public static NotaFiscal gerarNotaFiscal() {
            Random random = new Random();
            NotaFiscal nowNota = new NotaFiscal();

            Object ServicoSelecionado = chamaSelecaoOS();
            OrdemDeServico nowOS = OrdemDeServicoDAO.findOsByTitulo((String) ServicoSelecionado);
            nowNota.setDataEmissao(LocalDate.now());
            nowNota.setTipoNota(TipoNota.SAIDA);
            //Gerar número da nota
                LocalDate localDate = LocalDate.now();
                Date date = Date.valueOf(localDate);
                SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
                String data = format.format(date);
                Integer numeroDaNota = Integer.parseInt(data) + random.nextInt(10);

            nowNota.setNumeroNota(numeroDaNota);

            return nowNota;
        }

        //Funões para esolher opções
        private static Object chamaSelecaoOS() {
            Object[] selectionValues = OrdemDeServicoDAO.findListaOsInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione a OS: ",
                    "Gerar Nota Fiscal", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            return selection;
        }

        private static Object chamaSelecaoServico() {
            Object[] selectionValues = ServicoDAO.findListaServicoInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o servico: ",
                    "Cadastro de OS", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            return selection;
        }

        private static Object chamaSelecaoProduto() {
            Object[] selectionValues = ProdutoDAO.findListaProdutoInArray();
            String initialSelection = (String) selectionValues[0];
            Object selection = JOptionPane.showInputDialog(null, "Selecione o produto: ",
                    "Cadastro de OS", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            return selection;
        }

        private static Marca chamaSelecaoMarca() {
            String codigo = JOptionPane.showInputDialog(
                    null,
                    "Marcas: \n 01.SAMSUNG \n 02.LG \n 03.APPLE \n " +
                            "04.XIAOMI \n 05.HUAWEI \n 06.MOTOROLLA",
                    "Cadastro de Produto",
                    JOptionPane.QUESTION_MESSAGE);

            if(codigo.equals("01")) {
                return Marca.SAMSUNG;
            } else if(codigo.equals("02")) {
                return Marca.LG;
            } else if(codigo.equals("03")) {
                return Marca.APPLE;
            } else if(codigo.equals("04")) {
                return Marca.XIAOMI;
            } else if(codigo.equals("05")) {
                return Marca.HUAWEI;
            } else if(codigo.equals("06")) {
                return Marca.MOTOROLLA;
            } else {
                JOptionPane.showMessageDialog(null,"Codigo da marca inválido!!","Erro", JOptionPane.ERROR_MESSAGE);
                chamaSelecaoMarca();
            }
            return null;
        }

        //Funções de Chamar Relatorio
        static void chamaRelatorioPessoa() {
            List<Cliente> clientes = ClienteDAO.buscarTodos();
            RelatorioPessoaForm.emitirRelatorioCliente(clientes);
        }

        public static void chamaRelatorioProduto() {
            List<Produto> produtos = ProdutoDAO.buscarTodos();
            RelatorioProdutoForm.emitirRelatorioProduto(produtos);
        }







}




