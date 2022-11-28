package src.repository;

import src.NotaFiscal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDAO {
    static List<NotaFiscal> notas = new ArrayList<>();

    public static void salvar(NotaFiscal nota) {
        nota.setId(notas.size() +1);
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
                    "\n Valor Documento (R$)" + nota.getValorBruto() +
                    "\n Valor Cobrado (R$)" + nota.getValorLiquido();

        JOptionPane.showMessageDialog(null, menssagem,"",JOptionPane.INFORMATION_MESSAGE);
    }
}
