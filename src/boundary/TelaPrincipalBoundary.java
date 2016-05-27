package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;






public class TelaPrincipalBoundary implements ActionListener{

	private JPanel panel = new JPanel(new BorderLayout());
	private JFrame janela = new JFrame("Controle Museu - Principal");
	private JButton BtnVisitantes;
	private JButton BtnIngressos;
	private JButton BtnObras;
	private CadastroVisitanteBoundary cadvi;

	public TelaPrincipalBoundary() {
		
		
		panel.add(Topo(), BorderLayout.NORTH);
	
		panel.setBackground(Color.black);
		panel.add(CentroPrincipal(), BorderLayout.CENTER);
		
		
		janela.setContentPane(panel);
		janela.setSize(700, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JComponent Topo(){
		JPanel panelTopo = new JPanel();
		
		JLabel nomeApp = new JLabel("Controle de Museu - MUSEX");
		nomeApp.setHorizontalAlignment(JLabel.CENTER);
		nomeApp.setFont(new Font("Paladino", Font.BOLD, 18));
		nomeApp.setForeground(Color.LIGHT_GRAY);
		
		panelTopo.setBackground(Color.WHITE);
		panelTopo.add(nomeApp);
		
		
		return  panelTopo;
	}
	
	public JComponent CentroPrincipal (){
		
		JPanel panelCentro = new JPanel(new FlowLayout());
		panelCentro.setBackground(Color.WHITE);
		BtnVisitantes = new JButton("Visitantes");
		BtnVisitantes.setFont( new Font("Paladinos", Font.BOLD, 16));
		BtnVisitantes.setIcon(new ImageIcon
				(TelaPrincipalBoundary.class.getResource("/resources/visitantes.png")));
		panelCentro.add(BtnVisitantes);
		BtnVisitantes.addActionListener(this);
		BtnObras = new JButton("Obras");
		BtnObras.setFont( new Font("Paladinos", Font.BOLD, 16));
		BtnObras.setIcon(new ImageIcon
				(TelaPrincipalBoundary.class.getResource("/resources/obras.png")));
		panelCentro.add(BtnObras);
		
		BtnIngressos = new JButton("Ingressos");
		BtnIngressos.setFont(new Font("Paladinos", Font.BOLD, 16));
		BtnIngressos.setIcon(new ImageIcon(
				TelaPrincipalBoundary.class.getResource("/resources/ingressos.png")));
		panelCentro.add(BtnIngressos);
		
		
		
		
		
		
		return panelCentro;
	}
	
	


public static void main(String[] args) {
	new TelaPrincipalBoundary();
}

@Override
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource() == BtnVisitantes){
		
		cadvi = new CadastroVisitanteBoundary();
		
		
	}
	
}
}