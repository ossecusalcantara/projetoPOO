package src.form;

import src.AppMain;
import src.Produto;
import src.relatorio.TableProduto;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

public class RelatorioProdutoForm extends JPanel {

    public static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Descricao", "Tipo", "marca", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableProduto tabela;

    public RelatorioProdutoForm(Vector<Produto> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Produto> vetorDados) {
        tabela = new TableProduto(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableProduto.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorioProduto(List<Produto> produtos) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    try {
                        AppMain.chamarMenuRelatorio();
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
            Vector<Produto> vetorDados = new Vector<Produto>();
            for (Produto produto : produtos) {
                vetorDados.add(produto);
            }

            frame.getContentPane().add(new RelatorioProdutoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
