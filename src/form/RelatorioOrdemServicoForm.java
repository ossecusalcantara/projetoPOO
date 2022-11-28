package src.form;

import src.AppMain;
import src.NotaFiscal;
import src.OrdemDeServico;
import src.relatorio.TableOrdemServico;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

public class RelatorioOrdemServicoForm extends JPanel {
    public static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"ID", "Titulo", "Valor", "Dt Cadastro", "Dt Conclusão", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableOrdemServico tabela;

    public RelatorioOrdemServicoForm(Vector<OrdemDeServico> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<OrdemDeServico> vetorDados) {
        tabela = new TableOrdemServico(nomeColunas, vetorDados);
        table = new JTable();
        table.setModel(tabela);
        table.setSurrendersFocusOnKeystroke(true);
        scroller = new javax.swing.JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(500, 300));

        TableColumn colunaEscondida = table.getColumnModel().getColumn(TableOrdemServico.INDEX_ESCONDIDO);
        colunaEscondida.setMinWidth(2);
        colunaEscondida.setPreferredWidth(2);
        colunaEscondida.setMaxWidth(2);
        setLayout(new BorderLayout());
        add(scroller, BorderLayout.CENTER);
    }

    public static void emitirRelatorioOS(List<OrdemDeServico> ordens) {
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
            Vector<OrdemDeServico> vetorDados = new Vector<OrdemDeServico>();
            for (OrdemDeServico os : ordens) {
                vetorDados.add(os);
            }

            frame.getContentPane().add(new RelatorioOrdemServicoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
