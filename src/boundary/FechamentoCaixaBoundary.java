package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.IngressoController;
import entity.Ingresso;

public class FechamentoCaixaBoundary implements ActionListener{
	
	private JPanel panelTotalizacao;
	private JDialog ingressoTotalizacaoDialog;
	private JButton btnEmitirRelatorio;
	private JButton btnFechar;
	private JLabel txtTotalVendidos;
	private JLabel txtTotalDescontos;
	private JLabel txtTotalValorVendidos;

	public FechamentoCaixaBoundary() {
		panelTotalizacao = new JPanel (new BorderLayout());
		ingressoTotalizacaoDialog = new JDialog();
		panelTotalizacao.add(Valores(), BorderLayout.CENTER);
		ingressoTotalizacaoDialog.setModal(true);
		ingressoTotalizacaoDialog.setLocationRelativeTo(null);
		ingressoTotalizacaoDialog.setResizable(false);
		ingressoTotalizacaoDialog.setContentPane(panelTotalizacao);
		ingressoTotalizacaoDialog.setSize(600, 200);
		ingressoTotalizacaoDialog.setLocationRelativeTo(null);
		ingressoTotalizacaoDialog.setVisible(true);
	
	}

	private JComponent Valores() {
		JPanel paneValores = new JPanel(new GridLayout(4, 2));
		JLabel lblTotalVendidos = new JLabel("Total de Ingressos Vendidos");
		formataLabel(lblTotalVendidos);
		txtTotalVendidos = new JLabel("");
		formataLabel(txtTotalVendidos);
		JLabel lblTotalDescontos = new JLabel("Total de Descontos");
		formataLabel(lblTotalDescontos);
		txtTotalDescontos = new JLabel("");
		formataLabel(txtTotalDescontos);
		JLabel lblTotalValorVendidos = new JLabel("Valor Total Vendidos");
		formataLabel(lblTotalValorVendidos);
		txtTotalValorVendidos = new JLabel("");
		formataLabel(txtTotalValorVendidos);
		paneValores.add(lblTotalVendidos);
		paneValores.add(txtTotalVendidos);
		paneValores.add(lblTotalDescontos);
		paneValores.add(txtTotalDescontos);
		paneValores.add(lblTotalValorVendidos);
		paneValores.add(txtTotalValorVendidos);
		btnEmitirRelatorio = new JButton("Emitir Relatório");
		btnEmitirRelatorio.addActionListener(this);
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(this);
		
		
		
		paneValores.add(btnEmitirRelatorio);
		paneValores.add(btnFechar);
		
		informarValores();
		
		return paneValores;
	}
	
	
	public void formataLabel (JLabel lbl){
		lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl.setForeground(Color.BLUE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnFechar){
			ingressoTotalizacaoDialog.dispose();
		}else
			if(e.getSource() == btnEmitirRelatorio){
				JOptionPane.showMessageDialog(null, "Relatório Emitido com sucesso");
			}
		
	}
	
	public void informarValores(){
		IngressoController control = new IngressoController();
		Ingresso ing = control.getValoresTotal();
		txtTotalDescontos.setText("R$"+ing.getValorTotalDesconto());
		txtTotalValorVendidos.setText("R$"+ing.getValorTotalIngressosVendidos());
		txtTotalVendidos.setText(""+ing.getTotalVendidos());
		
	}
}
