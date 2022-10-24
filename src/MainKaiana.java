package src;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainKaiana {
    public static void main(String[] args) {
        cadastrarProduto();
        //cadastrarServico();

    }

    public static void cadastrarProduto() {

        Marca nowMarca = new Marca (
                1,
                JOptionPane.showInputDialog(null,"Marca: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)
        );

        Produto nowProduto = new Produto (
                1,
                JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(null,"Tipo: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                nowMarca
        );


        //rever se estoque realmente vai ficar dentro do cadastrarProduto
        BigDecimal custoTot;
        int quantidade;
        BigDecimal custoUnit;
        Estoque nowEstoque = new Estoque (
                1,
                nowProduto,
                quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantidade: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)), //verificar como vamos controlar a quantidade no estoque
                custoTot = new BigDecimal(JOptionPane.showInputDialog(null,"Valor Total: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE)),
                custoUnit = custoTot.divide(BigDecimal.valueOf(quantidade)) //não consegui puxar a função da classe estoque
        );
    }

    public static void cadastrarServico() {
        BigDecimal valor;
        Servico nowServico = new Servico (
                1,
                JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE),
                LocalDate.parse(JOptionPane.showInputDialog(null,"Tempo Médio: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                valor = new BigDecimal(JOptionPane.showInputDialog(null,"Valor: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE))
        );
    }
}
