package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.TableObrasController;

public class TableObrasBoundary implements ActionListener, ListSelectionListener{
	private JDialog DialogTabelaObras;
	private JPanel panelObras;
	private JTable tabelaObras;
	private JScrollPane panTableObras;
	private TableObrasController control = new TableObrasController();
	public TableObrasBoundary() {
		panelObras = new JPanel(new BorderLayout());
		DialogTabelaObras = new JDialog();
	panelObras.setBackground(Color.WHITE);
		
		
		panelObras.add(principal(),BorderLayout.NORTH);
		
		

		DialogTabelaObras.setModal(true);
		DialogTabelaObras.setLocationRelativeTo(null);
		DialogTabelaObras.setResizable(false);
		DialogTabelaObras.setContentPane(panelObras);
		DialogTabelaObras.setSize(720, 660);
		DialogTabelaObras.setLocationRelativeTo(null);
		DialogTabelaObras.setVisible(true);
		
	}
	private JComponent principal() {
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panTableObras = new JScrollPane();
		tabelaObras = new JTable(control);
		
		panTableObras.getViewport().add(tabelaObras);
		tabelaObras.getSelectionModel().addListSelectionListener(this);
		
		panelPrincipal.add(panTableObras);
		
		
		
		return panelPrincipal;
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
