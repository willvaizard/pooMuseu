package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.TableObrasController;
import entity.Obras;
import javafx.scene.layout.Border;

public class TableObrasBoundary implements ActionListener, ListSelectionListener{
	private JDialog DialogTabelaObras;
	private JPanel panelObras;
	private JTable tabelaObras;
	private JScrollPane panTableObras;
	private TableObrasController control = new TableObrasController();
	private JTextField txtpesquisar;
	private JButton btnPesquisar;
	public TableObrasBoundary() {
		panelObras = new JPanel(new BorderLayout());
		DialogTabelaObras = new JDialog();
	panelObras.setBackground(Color.WHITE);
		
		panelObras.add(topo(), BorderLayout.NORTH);
		panelObras.add(principal(),BorderLayout.CENTER);
		panelObras.add(rodape(), BorderLayout.SOUTH);
		
		

		DialogTabelaObras.setModal(true);
		DialogTabelaObras.setLocationRelativeTo(null);
		DialogTabelaObras.setResizable(false);
		DialogTabelaObras.setContentPane(panelObras);
		DialogTabelaObras.setSize(720, 660);
		DialogTabelaObras.setLocationRelativeTo(null);
		DialogTabelaObras.setVisible(true);
		
	}
	private Component rodape() {
		JPanel panelRodape = new JPanel(new FlowLayout());
		panelRodape.setBackground(Color.LIGHT_GRAY);
		JComboBox<Object> tipoPesquisa = new JComboBox<Object>();
		tipoPesquisa.addItem("Obra");
		tipoPesquisa.addItem("Autor");
		panelRodape.add(tipoPesquisa);
		txtpesquisar = new JTextField(30);
		panelRodape.add(txtpesquisar);
		txtpesquisar.addActionListener(this);
		btnPesquisar = new JButton("Pesquisiar");
		panelRodape.add(btnPesquisar);
		btnPesquisar.addActionListener(this);
		
		return panelRodape;
	}
	private JComponent topo() {
		JPanel PanelTopo = new JPanel(new FlowLayout());
		JLabel titulo = new JLabel("Consulta de Obras");
		
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		PanelTopo.add(titulo);
		
		
		
		return PanelTopo;
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
		System.out.println(tabelaObras.getSelectedRowCount());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtpesquisar || e.getSource() == btnPesquisar){
			if(validaCampoVazio()){
				Obras ob = new Obras();
				String nomeObra = txtpesquisar.getText().trim();
				control.ConsultaPorObra(nomeObra);
			}else
			{
				JOptionPane.showMessageDialog(null, "O campo de pesquisar não pode ser vazio");
			}
			
		}
		
	}
	public boolean validaCampoVazio(){
		if(txtpesquisar.getText().length() < 1)
			return false;
		return true;
	}
	
}
