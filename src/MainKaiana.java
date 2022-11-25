package src;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainKaiana {
    public static void main(String[] args) throws ParseException {
        cadastrarProduto();
        cadastrarServico();

    }

    public static Produto cadastrarProduto() {

//        Marca nowMarca = new Marca (
//                1,
//                JOptionPane.showInputDialog(null,"Marca: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)
//        );


        Produto nowProduto = new Produto (
                JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(null,"Tipo: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                Marca.SAMSUNG
        );

        //Processo para adicionar estoque ass: Adson
        Estoque estoque = new Estoque(
                      1 // Id Teste
                    , nowProduto
                    , Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade do Produto para Estoque: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE))
        );

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

//    anotação: Esta função poderia ser para editar o estoque mas primeiro é nescessario fazer o DAO
//    public static void  cadastrarEstoque() {
//        BigDecimal custoTot;
//        int quantidade;
//        BigDecimal custoUnit;
//        Estoque nowEstoque = new Estoque (
//                1,
//                nowProduto, //como chamar meu produto já cadastrado
//                quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)), //verificar como vamos controlar a quantidade no estoque
//                custoUnit =  new BigDecimal(JOptionPane.showInputDialog(null,"Valor Unitário: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)),
//                custoTot = new BigDecimal(JOptionPane.showInputDialog(null,"Valor Total: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE))
//        );
//    }

}
