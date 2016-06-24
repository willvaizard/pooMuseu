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
import javax.swing.table.TableModel;

import controller.TableIngressosVendidosController;

public class TableIngressosVendidosBoundary {
	private JPanel panelIngressosVendidos;
	private JDialog IngressoVendidosDialog;
	private TableIngressosVendidosController control = new TableIngressosVendidosController();
	private JScrollPane paneTableIngressosVendidos;
	private JTable tabelaVendidos;
	
	public TableIngressosVendidosBoundary() {
		panelIngressosVendidos = new JPanel (new BorderLayout());
		IngressoVendidosDialog = new JDialog();
		
		panelIngressosVendidos.add(TabelaIngressos(), BorderLayout.CENTER);
		IngressoVendidosDialog.setModal(true);
		IngressoVendidosDialog.setLocationRelativeTo(null);
		IngressoVendidosDialog.setResizable(false);
		IngressoVendidosDialog.setContentPane(panelIngressosVendidos);
		IngressoVendidosDialog.setSize(720, 700);
		IngressoVendidosDialog.setLocationRelativeTo(null);
		IngressoVendidosDialog.setVisible(true);
		
	}
	
	

	public JComponent TabelaIngressos (){
		JPanel paneTabela = new JPanel(new GridLayout(1,1));
		paneTableIngressosVendidos = new JScrollPane();
		tabelaVendidos = new JTable(control);
		paneTableIngressosVendidos.getViewport().add(tabelaVendidos);
		
		
		
		
		paneTabela.add(paneTableIngressosVendidos);
		
		
		
		return paneTabela;
	}
	
	public JComponent IngressosVendidosTotal(){
		JPanel paneTotalVendidos = new JPanel();
		
		return paneTotalVendidos;
	}
	

}
