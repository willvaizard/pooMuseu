package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CadastroExposicaoBoundary {
	JPanel panelExposicao;
	JDialog CadDialog = new JDialog();
	public CadastroExposicaoBoundary() {
	
		panelExposicao = new JPanel(new BorderLayout());
		panelExposicao.setBackground(Color.WHITE);
		
		panelExposicao.add(topo(),BorderLayout.NORTH);
		panelExposicao.add(Centro(),BorderLayout.CENTER);
		panelExposicao.add(Botoes(),BorderLayout.SOUTH);
	
		

		CadDialog.setModal(true);
		CadDialog.setLocationRelativeTo(null);
		CadDialog.setResizable(false);
		CadDialog.setContentPane(panelExposicao);
		CadDialog.setSize(720, 660);
		
		CadDialog.setLocationRelativeTo(null);
		CadDialog.setVisible(true);
	}
	
	public JComponent topo() {
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Cadastro de Exposições");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelTopo.add(titulo);
		
		return panelTopo;
	}
	
	
	public JComponent Centro() {
		JPanel JPaneCentro = new JPanel();
		
		
		
		
		
		return JPaneCentro;
	}
	public JComponent Botoes() {
		JPanel botoes = new JPanel();
		
		
		return botoes;
	}

}
