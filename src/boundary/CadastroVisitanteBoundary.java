package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.VisitanteController;
import entity.VisitanteEntity;

public class CadastroVisitanteBoundary extends JFrame{
	
	private JPanel panelVisitantes;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JButton btnPesquisar;
	private JTextField txtCPF;
	private JTextField txtIdade;
	private JCheckBox cbBrasileiro;
	private JRadioButton rdOutro;
	private JTable tabelaVisitante;
	private VisitanteController control = new VisitanteController();
	
	 
	
	
	
	public CadastroVisitanteBoundary(){
		JPanel panelPrincipal = new JPanel(new FlowLayout());
		JFrame janela = new JFrame("Cadastro de Visitantes");
		
		//JScrollPane panTableVisitante = new JScrollPane();
		panelVisitantes = new JPanel(new BorderLayout());
		panelVisitantes.setBackground(Color.WHITE);
		
		panelVisitantes.add(topo(),BorderLayout.NORTH);
		panelVisitantes.add(botoes(), BorderLayout.SOUTH);
		
		
		
		//panelPrincipal.add(panTableVisitante);
	
		panelVisitantes.add(principal(),BorderLayout.CENTER);
		tabelaVisitante = new JTable(control);
		//panTableVisitante.getViewport().add(tabelaVisitante);
		control.getLista(); 
		
		janela.setContentPane(panelVisitantes);
		janela.setSize(1000,600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new CadastroVisitanteBoundary();
	}
	
	
	
	
	public JComponent topo(){
		JPanel panelTopo = new JPanel(new GridLayout(1,1));
		panelTopo.setForeground(Color.BLUE);
		panelTopo.setBackground(Color.white);
		JLabel nomeJanela = new JLabel("Cadastro de Visitante");
		nomeJanela.setFont(new Font("Tahoma",Font.BOLD,19));
		panelTopo.add(nomeJanela);
		
		
		
		
		
		return panelTopo;
	}
	
	public JComponent principal(){
		
		
		
		JPanel panelPrincipal = new JPanel(new FlowLayout());
		JScrollPane panTableVisitante = new JScrollPane();
		tabelaVisitante = new JTable(control);
		
		
		
		
		panTableVisitante.getViewport().add(tabelaVisitante);
		panelPrincipal.add(panTableVisitante);
	
		
		return panelPrincipal;
	}
	
	
	
	public JComponent botoes (){
		JPanel panelBotoes = new JPanel( new GridLayout(1,4,5,5));
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnRemover = new JButton("Remover");
		btnPesquisar = new JButton("Pesquisar");
		
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnRemover);
		panelBotoes.add(btnPesquisar);
		
		
		
		return panelBotoes;
		
		
	}
	

}
