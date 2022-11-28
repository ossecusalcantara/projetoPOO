package src.repository;

import src.Item;
import src.NotaFiscal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDAO {
    static List<NotaFiscal> notas = new ArrayList<>();

    public static void salvar(NotaFiscal nota) {
        nota.setId(notas.size() +1);
        nota.setNumeroNota(notas.size() +1);
        notas.add(nota);
        getDadosNotaRelatorio(nota);
    }

    public static List<NotaFiscal> buscarTodos() {
        System.out.println(notas);
        return notas;
    }

    public static List<NotaFiscal> buscarPorNome(String numero){
        Integer numeroInt = Integer.parseInt(numero);
        List<NotaFiscal> notasFiltradas = new ArrayList<>();
        for (NotaFiscal nota : notas) {
            if(nota.getNumeroNota() == numeroInt) {
                notasFiltradas.add(nota);
            }
        }
        return notasFiltradas;
    }

    public static Object[] findListaNotaInArray() {
        List<NotaFiscal> notas = NotaFiscalDAO.buscarTodos();
        List<Integer> notasNumero = new ArrayList<>();

        for(NotaFiscal nota : notas) {
            notasNumero.add(nota.getNumeroNota());
        }

        return notasNumero.toArray();
    }

    public static void getDadosNotaRelatorio(NotaFiscal nota) {
        String menssagem = "";
        menssagem = "Nota egrada com sucesso!! \n" +
                    "Dados da Nota \n" +
                    "\n Numero: " + nota.getNumeroNota() +
                    "\n Data Emissão: " + nota.getDataEmissaoFormatadaBr() +
                    "\n Desconto (R$): " + nota.getDesconto() +
                    "\n ICMS (R$):" + nota.getIcms() +
                    "\n ISS (R$)" + nota.getIss() +
                    "\n Valor Serviços/Produtos (R$):" + nota.getValorBruto() +
                    "\n Valor Contabil (R$):" + nota.getValorContabil();
        List<Item> itensNota= new ArrayList<>();
        itensNota = nota.getItens();
        menssagem += "\n ##################ITENS########################";
        menssagem += "\n    DESCRIÇÃO  |   QUANTIDADE  |  VALOR TOTAL";
        for (Item i : itensNota) {
            menssagem += "\n   " + i.getItem().getDescricao() + "                " + i.getQuantidade() + "                         " + i.getValorTotal();
        }
        menssagem += "\n ###############################################";

        JOptionPane.showMessageDialog(null, menssagem,"",JOptionPane.INFORMATION_MESSAGE);
    }
}
