package src.form;

import src.Cliente;
import src.AppMain;
import src.relatorio.TableCliente;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

public class RelatorioPessoaForm extends JPanel {

    public static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Nome", "Documento", "Telefone", "Email", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableCliente tabela;

    public RelatorioPessoaForm(Vector<Cliente> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Cliente> vetorDados) {
        tabela = new TableCliente(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableCliente.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorioCliente(List<Cliente> pessoas) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame frame = new JFrame("Relatorio");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    frame.setVisible(false);
                    try {
                        AppMain.chamarMenuRelatorio();
                    }  catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            Vector<Cliente> vetorDados = new Vector<Cliente>();
            for (Cliente pessoa : pessoas) {
                vetorDados.add(pessoa);
            }

            frame.getContentPane().add(new RelatorioPessoaForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
