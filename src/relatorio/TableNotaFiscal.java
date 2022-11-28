package src.relatorio;

import src.Cliente;
import src.NotaFiscal;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableNotaFiscal extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    public static final int INDEX_NUMERO = 0;
    public static final int INDEX_DATA = 1;
    public static final int INDEX_DESCONTO  = 2;
    public static final int INDEX_VALORBRUTO = 3;
    public static final int INDEX_VALORLIQUIDO = 4;
    public static final int INDEX_ESCONDIDO = 5;

    protected String[] nomeColunas;
    protected Vector<NotaFiscal> vetorDados;

    public TableNotaFiscal(String[] columnNames, Vector<NotaFiscal> vetorDados) {
        this.nomeColunas = columnNames;
        this.vetorDados = vetorDados;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        if (coluna == INDEX_ESCONDIDO) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        NotaFiscal registroNotas = (NotaFiscal) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_NUMERO:
                return registroNotas.getNumeroNota();
            case INDEX_DATA:
                return registroNotas.getDataEmissaoFormatadaBr();
            case INDEX_DESCONTO:
                return registroNotas.getDesconto();
            case INDEX_VALORBRUTO:
                return registroNotas.getValorBruto();
            case INDEX_VALORLIQUIDO:
                System.out.println("Teste");
                return registroNotas.getValorLiquido();
            default:
                return new Object();
        }
    }

    @Override
    public int getRowCount() {
        return vetorDados.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
}
