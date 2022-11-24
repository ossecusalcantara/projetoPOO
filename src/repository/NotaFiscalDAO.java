package src.repository;

import src.NotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscalDAO {
    static List<NotaFiscal> notas = new ArrayList<>();

    public static void salvar(NotaFiscal nota) {
        notas.add(nota);
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
}
