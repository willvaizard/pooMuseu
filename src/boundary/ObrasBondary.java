package boundary;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import com.toedter.calendar.JDateChooser;

import controller.DadosEstaticos;

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
	public ObrasBondary() {
	JFrame janela = new JFrame("Manter Obras");
	
	
	panelObras.add(topo(),BorderLayout.NORTH);
	panelObras.add(principal(), BorderLayout.CENTER);
	panelObras.add(botoes(), BorderLayout.SOUTH);
	janela.setContentPane(panelObras);
	janela.setSize(800, 600);
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
		JLabel lblNomeObra = new JLabel("Nome da Obra");
		panelPrincipal.add(lblNomeObra);
		txtNomeObra = new JTextField(50);
		panelPrincipal.add(txtNomeObra);
		btnPesquisarObra = new JButton("Pesquisar Obra");
		panelPrincipal.add(btnPesquisarObra);
		
		JLabel lblNomeAutor = new JLabel("Nome Autor");
		panelPrincipal.add(lblNomeAutor);
		txtNomeAutor = new JTextField(60);
		panelPrincipal.add(txtNomeAutor);
		
		JLabel lblBiografia = new JLabel("Biografia");
		panelPrincipal.add(lblBiografia);
		txtBiografia = new JTextArea(5,60);
		panelPrincipal.add(txtBiografia);
		JLabel lblDataObra = new JLabel();
		panelPrincipal.add(lblDataObra);
		DataObra = new JDateChooser();
		panelPrincipal.add(DataObra);
		
		JCheckBox disponibidadade = new JCheckBox("Disponivel para emprestimo");
		panelPrincipal.add(disponibidadade);
		JLabel lblTipoObra = new JLabel("Tipo de Obra");
		panelPrincipal.add(lblTipoObra);
		cbTipoObra = new JComboBox<Object>();
		panelPrincipal.add(cbTipoObra);
		DadosEstaticos de = new DadosEstaticos();
		List<Object> listaObras = de.tipoObra();
		
		for(Object obras: listaObras)
		cbTipoObra.addItem(obras);
		
		
		JLabel lblCategoria = new JLabel("Categoria");
		panelPrincipal.add(lblCategoria);
		cbCategoria = new JComboBox<Object>();
			List<Object> listaCat= de.Categoria();
		for(Object categoria: listaCat)
			cbCategoria.addItem(categoria);
		panelPrincipal.add(cbCategoria);
		
		JLabel lblLocalizacao = new JLabel("Localização");
		panelPrincipal.add(lblLocalizacao);
		
		JComboBox<Object> cbLocalizacao = new JComboBox<Object>();
		List<Object> listaLocal = new ArrayList<Object>();
		listaLocal = de.Localizacao();
		for(Object local: listaLocal)
			cbLocalizacao.addItem(local);
		panelPrincipal.add(cbLocalizacao);
		
		
		return panelPrincipal;
		
	}
	
	

	private JComponent botoes() {
		JPanel panelBotoes = new JPanel(new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnDeletar = new JButton("Deletar");
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnDeletar);
		
		
		return panelBotoes;
	}
	
	
	
	public static void main(String[] args) {
		new ObrasBondary();
	}
}
