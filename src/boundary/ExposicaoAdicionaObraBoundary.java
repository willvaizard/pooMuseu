package boundary;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class ExposicaoAdicionaObraBoundary {
	private JDialog addObraDialog;
	private JPanel panelAddObra;
	public ExposicaoAdicionaObraBoundary(int idExposicao) {
		panelAddObra = new JPanel(new BorderLayout());
		addObraDialog = new JDialog();
		
		panelAddObra.add(TabelaObrasDaExposicao(), BorderLayout.CENTER);
		addObraDialog.setModal(true);
		addObraDialog.setLocationRelativeTo(null);
		addObraDialog.setResizable(false);
		addObraDialog.setContentPane(panelAddObra);
		addObraDialog.setSize(720, 700);
		addObraDialog.setLocationRelativeTo(null);
		addObraDialog.setVisible(true);
	}
	private Component TabelaObrasDaExposicao() {

		return null;
	}
	
	

}
