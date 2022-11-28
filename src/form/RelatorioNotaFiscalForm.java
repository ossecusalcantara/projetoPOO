package src.form;

import src.AppMain;
import src.NotaFiscal;
import src.relatorio.TableCliente;
import src.relatorio.TableNotaFiscal;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

public class RelatorioNotaFiscalForm extends JPanel {
    public static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Numero", "Data Emissão", "Desconto", "Valor Dcumento", "Valor Cobrado", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableNotaFiscal tabela;

    public RelatorioNotaFiscalForm(Vector<NotaFiscal> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<NotaFiscal> vetorDados) {
        tabela = new TableNotaFiscal(nomeColunas, vetorDados);
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

    public static void emitirRelatorioNotas(List<NotaFiscal> notas) {
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
            Vector<NotaFiscal> vetorDados = new Vector<NotaFiscal>();
            for (NotaFiscal nota : notas) {
                vetorDados.add(nota);
            }

            frame.getContentPane().add(new RelatorioNotaFiscalForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
