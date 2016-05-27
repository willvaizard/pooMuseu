package boundary;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import com.toedter.calendar.JDateChooser;

import controller.comboBox;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;


import javafx.scene.layout.Border;
import javax.swing.ImageIcon;

public class ObrasBondary {
	private JPanel 	 panelObras = new JPanel(new BorderLayout());
	private JButton btnPesquisarObra;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JTextArea txtBiografia;
	private JDateChooser DataObra;
	private JComboBox<Object> cbTipoObra;
	private JComboBox<Object> cbCategoria;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton btnPesquisarAutor;
	public ObrasBondary() {
	JFrame janela = new JFrame("Manter Obras");
	
	
	panelObras.add(topo(),BorderLayout.NORTH);
	panelObras.add(principal(), BorderLayout.CENTER);
	panelObras.add(botoes(), BorderLayout.SOUTH);
	janela.setContentPane(panelObras);
	janela.setSize(720, 400);
	janela.setVisible(true);
	
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		 
		 
		 
	
	}


	public JComponent topo(){
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Cadastro de Obras");
		titulo.setFont(new Font("Paladino", Font.BOLD, 18));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelTopo.add(titulo);
		
		
		
		return panelTopo;
		
	}
	
	
	public JComponent principal (){
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		JLabel lblNomeObra = new JLabel("Nome da Obra:");
		lblNomeObra.setBounds(20, 25, 110, 14);
		panelPrincipal.add(lblNomeObra);
		txtNomeObra = new JTextField(50);
		txtNomeObra.setBounds(125, 22, 406, 20);
		panelPrincipal.add(txtNomeObra);
		btnPesquisarObra = new JButton("");
		btnPesquisarObra.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/lupa.png")));
		btnPesquisarObra.setBounds(551, 12, 40, 40);
		panelPrincipal.add(btnPesquisarObra);
		
		JLabel lblNomeAutor = new JLabel("Nome Autor:");
		lblNomeAutor.setBounds(20, 80, 110, 14);
		panelPrincipal.add(lblNomeAutor);
		txtNomeAutor = new JTextField(60);
		txtNomeAutor.setBounds(125, 77, 406, 20);
		panelPrincipal.add(txtNomeAutor);
		
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(20, 123, 95, 14);
		panelPrincipal.add(lblBiografia);
		txtBiografia = new JTextArea(5,60);
		txtBiografia.setBounds(125, 118, 558, 77);
		panelPrincipal.add(txtBiografia);
		DataObra = new JDateChooser();
		DataObra.setBounds(106, 242, 124, 20);
		panelPrincipal.add(DataObra);
		
		JCheckBox disponibidadade = new JCheckBox("Disponivel para emprestimo");
		disponibidadade.setBounds(263, 242, 327, 23);
		panelPrincipal.add(disponibidadade);
		JLabel lblTipoObra = new JLabel("Tipo de Obra:");
		lblTipoObra.setBounds(20, 209, 76, 14);
		panelPrincipal.add(lblTipoObra);
		cbTipoObra = new JComboBox<Object>();
		cbTipoObra.setBounds(106, 206, 124, 20);
		panelPrincipal.add(cbTipoObra);
		comboBox de = new comboBox();
		List<Object> listaObras = de.tipoObra();
		
		for(Object obras: listaObras)
		cbTipoObra.addItem(obras);
		
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(263, 209, 76, 14);
		panelPrincipal.add(lblCategoria);
		cbCategoria = new JComboBox<Object>();
		cbCategoria.setBounds(335, 206, 124, 20);
			List<Object> listaCat= de.Categoria();
		for(Object categoria: listaCat)
			cbCategoria.addItem(categoria);
		panelPrincipal.add(cbCategoria);
		
		JLabel lblLocalizacao = new JLabel("Localiza\u00E7\u00E3o:");
		lblLocalizacao.setBounds(489, 209, 92, 14);
		panelPrincipal.add(lblLocalizacao);
		
		JComboBox<Object> cbLocalizacao = new JComboBox<Object>();
		cbLocalizacao.setBounds(575, 206, 108, 20);
		List<Object> listaLocal = new ArrayList<Object>();
		listaLocal = de.Localizacao();
		for(Object local: listaLocal)
			cbLocalizacao.addItem(local);
		panelPrincipal.add(cbLocalizacao);
		
		JLabel lblDtObra = new JLabel("Data da Obra:");
		lblDtObra.setBounds(20, 246, 110, 14);
		panelPrincipal.add(lblDtObra);
		
		btnPesquisarAutor = new JButton("");
		btnPesquisarAutor.setBounds(551, 67, 40, 40);
		btnPesquisarAutor.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/lupa.png")));
		panelPrincipal.add(btnPesquisarAutor);
		
		
		return panelPrincipal;
		
	}
	
	

	private JComponent botoes() {
		JPanel panelBotoes = new JPanel(new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/salvar.png")));
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/edit.png")));
		btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/delete.png")));

		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnDeletar);
		
		
		return panelBotoes;
	}
	
	
	
	public static void main(String[] args) {
		new ObrasBondary();
	}
}
