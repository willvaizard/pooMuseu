package boundary;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.ExposicaoAdicionaObraController;
import controller.ExposicaoController;
import entity.Obras;

public class ExposicaoAdicionaObraBoundary  implements ActionListener{
	private JDialog addObraDialog;
	private JPanel panelAddObra;
	private JTable tabelaObrasExposicao;
	private ExposicaoAdicionaObraController expControl;
	private JScrollPane scrollObExp;
	private TableObrasBoundary obrasView;
	private long idExposicao;
	public ExposicaoAdicionaObraBoundary(long idExposicao){
		this.idExposicao=idExposicao;
		expControl = new ExposicaoAdicionaObraController(idExposicao);
		panelAddObra = new JPanel(new BorderLayout());
		addObraDialog = new JDialog();
		
		panelAddObra.add(Norte(), BorderLayout.CENTER);
		panelAddObra.add(TabelaObrasDaExposicao(), BorderLayout.CENTER);
		panelAddObra.add(Sul(), BorderLayout.SOUTH);
		addObraDialog.setModal(true);
		addObraDialog.setLocationRelativeTo(null);
		addObraDialog.setResizable(false);
		addObraDialog.setContentPane(panelAddObra);
		addObraDialog.setSize(720, 700);
		addObraDialog.setLocationRelativeTo(null);
		addObraDialog.setVisible(true);
	}
	private Component Norte() {
		JPanel panelNorte = new JPanel();
		JLabel titulo = new JLabel("Exposição: Inclusão de Obras");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
		return panelNorte;
	}
	private Component Sul() {
		JPanel panelSul = new JPanel();
		JButton btnPesquisarObras = new JButton("Pesquisar Obra");
		btnPesquisarObras.setIcon(new ImageIcon(ObrasBondary.class.getResource(""
				+ "/resources/lupa.png")));
		btnPesquisarObras.addActionListener(this);
		panelSul.add(btnPesquisarObras);
		
		
		return panelSul;
	}
	private JComponent TabelaObrasDaExposicao() {
		JPanel panelTable = new JPanel(new GridLayout(1,1));
		tabelaObrasExposicao = new JTable(expControl);
		scrollObExp = new JScrollPane();
		scrollObExp.getViewport().add(tabelaObrasExposicao);
		panelTable.add(scrollObExp);
		
		return panelTable;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		obrasView = new TableObrasBoundary();
		Obras ob = obrasView.getDadosObras();
		ob.setExposicao_id(idExposicao);
		ExposicaoController control = new ExposicaoController();
		control.insereNovaObraEmExposicao(ob);
		tabelaObrasExposicao.invalidate();
		tabelaObrasExposicao.revalidate();
		
		
	}
	
	

}
