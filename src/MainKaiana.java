package src;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainKaiana {
    public static void main(String[] args) {
        cadastrarProduto();
        cadastrarServiço();
    }

    public static void cadastrarProduto() {

        Marca nowMarca = new Marca (
                1,
                JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro da Marca", JOptionPane.QUESTION_MESSAGE)
        );

        Produto nowProduto = new Produto (
                1,
                JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                JOptionPane.showInputDialog(null,"Tipo: ", "Cadastro de Produto", JOptionPane.QUESTION_MESSAGE),
                nowMarca
        );
    }

    public static void cadastrarServiço() {
        BigDecimal valor;
        Servico nowServico = new Servico (
                1,
                JOptionPane.showInputDialog(null,"Descrição: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE),
                LocalDate.parse(JOptionPane.showInputDialog(null,"Tempo Médio: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                valor = new BigDecimal(JOptionPane.showInputDialog(null,"Valor: ", "Cadastro de Serviço", JOptionPane.QUESTION_MESSAGE))
        );
    }
}
