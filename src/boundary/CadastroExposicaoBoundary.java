package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ExposicaoController;

public class CadastroExposicaoBoundary implements ActionListener, MouseListener, ListSelectionListener{
	private JPanel panelExposicao;
	private JDialog CadDialog = new JDialog();
	private ExposicaoController control = new ExposicaoController();
	private JTable tabelaExposicao;
	private JScrollPane panTableExposicao;
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
		JPanel JPaneCentro = new JPanel(new GridLayout(1,1));
		panTableExposicao = new JScrollPane();
		tabelaExposicao = new JTable(control);
		panTableExposicao.getViewport().add(tabelaExposicao);
		tabelaExposicao.getSelectionModel().addListSelectionListener(this);
		tabelaExposicao.addMouseListener(this);
		
		
		JPaneCentro.add(panTableExposicao);
		
		
		
		
		return JPaneCentro;
	}
	public JComponent Botoes() {
		JPanel botoes = new JPanel();
		
		
		return botoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
