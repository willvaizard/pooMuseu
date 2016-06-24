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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ExposicaoAdicionaObraController;
import controller.ExposicaoController;
import entity.Obras;

public class ExposicaoAdicionaObraBoundary  implements ActionListener, ListSelectionListener{
	private JDialog addObraDialog;
	private JPanel panelAddObra;
	private JTable tabelaObrasExposicao;
	private ExposicaoAdicionaObraController expControl;
	private JScrollPane scrollObExp;
	private TableObrasBoundary obrasView;
	private long idExposicao;
	private String nomeExposicao;
	private JButton btnPesquisarObras;
	private JButton btnRemoverObra;
	private int idObras;
	private ExposicaoController control;
	
	public ExposicaoAdicionaObraBoundary(String[] exposicao){
		this.idExposicao=Integer.parseInt(exposicao[0]);
		this.nomeExposicao =exposicao[1];
		
		expControl = new ExposicaoAdicionaObraController(idExposicao);
		panelAddObra = new JPanel(new BorderLayout());
		addObraDialog = new JDialog();
		
		panelAddObra.add(Norte(), BorderLayout.NORTH);
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
	private JComponent Norte() {
		JPanel panelNorte = new JPanel(new GridLayout(2, 1));
		JLabel titulo = new JLabel("Inclusão de Obras");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		JLabel txtNomeObra = new JLabel("Exposição: "+nomeExposicao);
		txtNomeObra.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNomeObra.setHorizontalAlignment(JLabel.CENTER);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelNorte.add(titulo);
		panelNorte.add(txtNomeObra);
		return panelNorte;
	}
	private JComponent Sul() {
		JPanel panelSul = new JPanel();
		btnPesquisarObras = new JButton("Pesquisar Obra");
		btnPesquisarObras.setIcon(new ImageIcon(ObrasBondary.class.getResource(""
				+ "/resources/lupa.png")));
		btnPesquisarObras.addActionListener(this);
		
		btnRemoverObra = new JButton("Remover Obra");
		btnRemoverObra.setToolTipText("Remove Obras da exposicao");
		btnRemoverObra.setIcon(new ImageIcon(ObrasBondary.class.getResource(""
				+ "/resources/delete.png")));
		btnRemoverObra.addActionListener(this);
		btnRemoverObra.setEnabled(false);
		
		
		
		panelSul.add(btnPesquisarObras);
		panelSul.add(btnRemoverObra);
		
		return panelSul;
	}
	private JComponent TabelaObrasDaExposicao() {
		JPanel panelTable = new JPanel(new GridLayout(1,1));
		tabelaObrasExposicao = new JTable(expControl);
		tabelaObrasExposicao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaObrasExposicao.getSelectionModel().addListSelectionListener(this);
		scrollObExp = new JScrollPane();
		scrollObExp.getViewport().add(tabelaObrasExposicao);
		panelTable.add(scrollObExp);
		
		return panelTable;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnPesquisarObras ){
		obrasView = new TableObrasBoundary();
		Obras ob = obrasView.getDadosObras();
		ob.setExposicao_id(idExposicao);
		control = new ExposicaoController();
		control.insereNovaObraEmExposicao(ob);
		AtualizaTabela();
		
		}
		if(e.getSource() == btnRemoverObra){
			Obras obras = new Obras();
			obras.setIdObras(idObras);
			obras.setExposicao_id(idExposicao);
			
			ExposicaoController crtExp =new ExposicaoController();
			crtExp.removeObraDaExposicao(obras);
			AtualizaTabela();
		}
		
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabelaObrasExposicao.getSelectedRow();
		 idObras = (int) (tabelaObrasExposicao.getValueAt(linha, 0));
		 btnRemoverObra.setEnabled(true);
		
	}
	
	public void AtualizaTabela(){
		expControl.getListaObraExposicao();
		tabelaObrasExposicao.invalidate();
		tabelaObrasExposicao.revalidate();
	}
	
	
	
	
	
	

}
