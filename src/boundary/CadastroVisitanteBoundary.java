package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CadastroVisitanteBoundary extends JFrame{
	
	JPanel panelVisitantes;
	
	public CadastroVisitanteBoundary(){
		JFrame janela = new JFrame("Cadastro de Visitantes");
		panelVisitantes = new JPanel(new BorderLayout());
		panelVisitantes.setBackground(Color.WHITE);
		
		panelVisitantes.add(topo(),BorderLayout.NORTH);
		
		
		janela.setContentPane(panelVisitantes);
		janela.setSize(1000,600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		new CadastroVisitanteBoundary();
	}
	
	public JComponent topo (){
		JPanel panelTopo = new JPanel(new GridLayout(1,1));
		panelTopo.setForeground(Color.BLUE);
		panelTopo.setBackground(Color.white);
		JLabel nomeJanela = new JLabel("Cadastro de Visitante");
				nomeJanela.setFont(new Font("Tahoma",Font.BOLD,19));
		panelTopo.add(nomeJanela);
		
		
		
		
		
		return panelTopo;
	}
	
	

}
