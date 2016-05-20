package boundary;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;

public class ObrasBondary {
	private JPanel 	 panelObras = new JPanel(new BorderLayout());
	public ObrasBondary() {
	JFrame janela = new JFrame("Manter Obras");
	
	
	panelObras.add(topo(),BorderLayout.NORTH);
	
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
	
	
	
	
	
	
	public static void main(String[] args) {
		new ObrasBondary();
	}
}
