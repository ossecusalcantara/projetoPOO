package src.form;

import src.AppMain;
import src.Servico;
import src.relatorio.TableProduto;
import src.relatorio.TableServico;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.Vector;
import java.util.List;


public class RelatorioServicoForm extends JPanel {
    public static final long serialVersionUID = 1L;

    public static final String[] nomeColunas =
            {"Descricao", "Tempo", "Valor", ""};

    protected JTable table;
    protected JScrollPane scroller;
    protected TableServico tabela;

    public RelatorioServicoForm(Vector<Servico> vetorDados) {
        iniciarComponentes(vetorDados);
    }

    public void iniciarComponentes(Vector<Servico> vetorDados) {
        tabela = new TableServico(nomeColunas, vetorDados);
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

    public static void emitirRelatorioServico(List<Servico> servicos) {
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
            Vector<Servico> vetorDados = new Vector<Servico>();
            for (Servico servico : servicos) {
                vetorDados.add(servico);
            }

            frame.getContentPane().add(new RelatorioServicoForm(vetorDados));
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

