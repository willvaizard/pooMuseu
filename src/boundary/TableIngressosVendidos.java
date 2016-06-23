package boundary;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class TableIngressosVendidos {
	private JPanel panelIngressosVendidos = new JPanel (new GridLayout(2,1));
	private JDialog IngressoVendidosDialog;
	public TableIngressosVendidos() {
		
		panelIngressosVendidos.add(TabelaIngressos());
		IngressoVendidosDialog.setModal(true);
		IngressoVendidosDialog.setLocationRelativeTo(null);
		IngressoVendidosDialog.setResizable(false);
		IngressoVendidosDialog.setContentPane(panelIngressosVendidos);
		IngressoVendidosDialog.setSize(720, 700);
		IngressoVendidosDialog.setLocationRelativeTo(null);
		IngressoVendidosDialog.setVisible(true);
		
	}
	
	public JComponent TabelaIngressos (){
		JPanel paneTabela = new JPanel();
		
		
		return paneTabela;
	}
	

}
