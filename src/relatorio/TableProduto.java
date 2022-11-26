package src.relatorio;

import src.Produto;

import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class TableProduto extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    public static final int INDEX_DESCRICAO = 0;
    public static final int INDEX_QUANTIDADE = 1;
    public static final int INDEX_MARCA = 2;
    public static final int INDEX_ESCONDIDO = 3;

    protected String[] nomeColunas;
    protected Vector<Produto> vetorDados;

    public TableProduto(String[] columnNames, Vector<Produto> vetorDados) {
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
        Produto registroProduto = (Produto) vetorDados.get(linha);
        switch (coluna) {
            case INDEX_DESCRICAO:
                return registroProduto.getDescricao();
            case INDEX_QUANTIDADE:
                return registroProduto.getQuantidade();
            case INDEX_MARCA:
                return registroProduto.getMarca();
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