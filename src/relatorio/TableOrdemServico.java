package src.relatorio;

import src.OrdemDeServico;
import src.Produto;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableOrdemServico extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    public static final int INDEX_ID = 0;
    public static final int INDEX_TITULO = 1;
    public static final int INDEX_VALOR = 2;
    public static final int INDEX_DTENTRADA = 3;
    public static final int INDEX_DTLIMITE = 4;
    public static final int INDEX_ESCONDIDO = 5;

    protected String[] nomeColunas;
    protected Vector<OrdemDeServico> vetorDados;

    public TableOrdemServico(String[] columnNames, Vector<OrdemDeServico> vetorDados) {
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
        OrdemDeServico registroOS = (OrdemDeServico) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_ID:
                return registroOS.getId();
            case INDEX_TITULO:
                return registroOS.getTitulo();
            case INDEX_DTENTRADA:
                return registroOS.getDataFormatada(1);
            case INDEX_DTLIMITE:
                return registroOS.getDataFormatada(2);
            case INDEX_VALOR:
                return registroOS.getValorTotal();
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
