package boundary;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class EmprestimoDeObraBoundary {
	private JPanel panelEmprestimoObra;
	private JDialog emprestimoObraDialog;
	public EmprestimoDeObraBoundary() {
	panelEmprestimoObra = new JPanel(new BorderLayout());
	emprestimoObraDialog = new JDialog();
	panelEmprestimoObra.add(centro(), BorderLayout.CENTER);
	emprestimoObraDialog.setModal(true);
	emprestimoObraDialog.setLocationRelativeTo(null);
	emprestimoObraDialog.setResizable(false);
	emprestimoObraDialog.setContentPane(panelEmprestimoObra);
	emprestimoObraDialog.setSize(720, 660);
	emprestimoObraDialog.setLocationRelativeTo(null);
	emprestimoObraDialog.setVisible(true);
	
	
	
	
	}
	private JComponent centro() {
		JPanel panelCentro = new JPanel();
		
		
		return panelCentro;
	}
	
	
	

}
