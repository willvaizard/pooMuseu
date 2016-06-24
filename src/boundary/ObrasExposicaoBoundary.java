package boundary;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ExposicaoAdicionaObraController;

public class ObrasExposicaoBoundary {
	private JDialog addObraDialog;
	private JPanel panelAddObra;
	private JTable tabelaObrasExposicao;
	private ExposicaoAdicionaObraController expControl;
	private JScrollPane scrollObExp;
	public ObrasExposicaoBoundary(long idExposicao) {
		expControl = new ExposicaoAdicionaObraController(idExposicao);
		panelAddObra = new JPanel(new BorderLayout());
		addObraDialog = new JDialog();
		
		panelAddObra.add(Topo(), BorderLayout.NORTH);
		panelAddObra.add(TabelaObrasDaExposicao(), BorderLayout.CENTER);
		addObraDialog.setModal(true);
		addObraDialog.setLocationRelativeTo(null);
		addObraDialog.setResizable(false);
		addObraDialog.setContentPane(panelAddObra);
		addObraDialog.setSize(520, 300);
		addObraDialog.setLocationRelativeTo(null);
		addObraDialog.setVisible(true);
	}
	private JComponent Topo() {
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Obras da Exposição");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelTopo.add(titulo);
		return panelTopo;
	}
	private JComponent TabelaObrasDaExposicao() {
		JPanel panelTable = new JPanel(new GridLayout(1,1));
		tabelaObrasExposicao = new JTable(expControl);
		scrollObExp = new JScrollPane();
		scrollObExp.getViewport().add(tabelaObrasExposicao);
		panelTable.add(scrollObExp);
		
		return panelTable;
	}
	
	

}
