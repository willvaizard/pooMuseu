package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ExposicaoController;
import controller.IngressoController;
import entity.IngressoEntity;

public class IngressoBoundary extends JFrame implements ActionListener, ListSelectionListener,MouseListener {

	private JPanel panelIngresso = new JPanel(new BorderLayout());
	private JRadioButton rdbtnIdade5;
	private JRadioButton rdbtnIdade60;
	private JRadioButton rdbtnEstud;
	private JRadioButton rdbtnProf;
	private JRadioButton rdbtnOutros;
	private JLabel txtValor;
	private JLabel txtDesconto;
	private JLabel txtTotal;
	private JButton btnNovo;
	private JButton btnFinalizar;
	private JDialog IngressoDialog = new JDialog();
	private ExposicaoController control = new ExposicaoController();
	private IngressoController ingcontrol = new IngressoController();
	private JScrollPane panTableExposicaoIngresso;
	private JTable tabelaExposicaoIngresso;
	private Long idExposicao;
	private Double valorIngresso=0.0;
	private Double valorDesconto=0.0;
	private Double valorTotalAPagar=0.0;
	private ButtonGroup btnGroup;
	private String exposicao;
	private JLabel nomeExposicao;
	private JButton btnVisualizarVendas;
	private JButton btnFecharCaixa;

	public IngressoBoundary() {
		panelIngresso.add(topo(), BorderLayout.NORTH);
		panelIngresso.add(centro(), BorderLayout.CENTER);
		panelIngresso.add(sul(), BorderLayout.SOUTH);

		IngressoDialog.setModal(true);
		IngressoDialog.setLocationRelativeTo(null);
		IngressoDialog.setResizable(false);
		IngressoDialog.setContentPane(panelIngresso);
		IngressoDialog.setSize(720, 700);
		IngressoDialog.setLocationRelativeTo(null);
		IngressoDialog.setVisible(true);

	}

	public JComponent topo() {
		JPanel panelTopo = new JPanel(new GridLayout(2, 1));
		JLabel titulo = new JLabel("Venda de Ingressos");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 35));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		
		nomeExposicao = new JLabel("");
		nomeExposicao.setFont(new Font("Tahoma", Font.BOLD, 25));
		nomeExposicao.setForeground(Color.BLUE);
		
		nomeExposicao.setHorizontalAlignment(JLabel.CENTER);
		
		panelTopo.add(titulo);
		panelTopo.add(nomeExposicao);

		return panelTopo;
	}

	public JComponent centro() {
		JPanel panelCentro = new JPanel(new GridLayout(1,1));
		panTableExposicaoIngresso = new JScrollPane();
		tabelaExposicaoIngresso = new JTable(control);
		panTableExposicaoIngresso.getViewport().add(tabelaExposicaoIngresso);
		tabelaExposicaoIngresso.getSelectionModel().addListSelectionListener(this);
		tabelaExposicaoIngresso.addMouseListener(this);
		
		
		panelCentro.add(panTableExposicaoIngresso);





		return panelCentro;
	}

	private JComponent sul() {
		JPanel panelSul = new JPanel(new GridLayout(1,2));
		panelSul.add(Campos(),BorderLayout.CENTER);
		panelSul.add(botoes(), BorderLayout.PAGE_END);
		return panelSul;
	}
	
	public JComponent Campos(){
		JPanel panelCampos = new JPanel(new GridLayout(8,1));
					
		JLabel lblIdade5 = new JLabel("Idade:");
		lblIdade5.setBounds(20, 75, 110, 14);
		panelCampos.add(lblIdade5);
		rdbtnIdade5 = new JRadioButton("Menor que 5 anos");
		rdbtnIdade5.setBounds(225, 75, 150, 14);
		panelCampos.add(rdbtnIdade5);

		JLabel lblIdade60 = new JLabel("");
		lblIdade60.setBounds(20, 75, 110, 14);
		panelCampos.add(lblIdade60);
		rdbtnIdade60 = new JRadioButton("Maior que 60 anos");
		rdbtnIdade60.setBounds(375, 75, 150, 14);
		panelCampos.add(rdbtnIdade60);

		JLabel lblTipoVisit = new JLabel("Tipo de Visitante:");
		lblTipoVisit.setBounds(20, 100, 110, 14);
		panelCampos.add(lblTipoVisit);
		rdbtnEstud = new JRadioButton("Estudante");
		rdbtnEstud.setBounds(225, 100, 150, 14);
		panelCampos.add(rdbtnEstud);

		JLabel lblProf = new JLabel("");
		lblProf.setBounds(20, 100, 110, 14);
		panelCampos.add(lblProf);
		rdbtnProf = new JRadioButton("Professor");
		rdbtnProf.setBounds(375, 100, 150, 14);
		panelCampos.add(rdbtnProf);
		
		JLabel lblOutros = new JLabel("");
		lblOutros.setBounds(20, 100, 110, 14);
		panelCampos.add(lblOutros);
		rdbtnOutros = new JRadioButton("Outros");
		rdbtnOutros.setBounds(525, 100, 150, 14);
		panelCampos.add(rdbtnOutros);

		JLabel lblValor = new JLabel("Valor do Ingresso Inteiro:   R$");
		lblValor.setBounds(20, 150, 200, 14);
		panelCampos.add(lblValor);
		txtValor = new JLabel("0.00");
		txtValor.setBounds(225, 150, 150, 20);
		panelCampos.add(txtValor);

		JLabel lblDesconto = new JLabel("Desconto:   R$");
		lblDesconto.setBounds(20, 175, 200, 14);
		panelCampos.add(lblDesconto);
		txtDesconto = new JLabel("0.00");
		txtDesconto.setBounds(225, 175, 150, 20);
		panelCampos.add(txtDesconto);

		JLabel lblTotal = new JLabel("Total a Pagar:    R$");
		lblTotal.setBounds(20, 200, 200, 14);
		panelCampos.add(lblTotal);
		txtTotal = new JLabel("0.00");
		txtTotal.setBounds(225, 200, 150, 20);
		panelCampos.add(txtTotal);
		
		btnGroup = new ButtonGroup();
		rdbtnIdade5.addActionListener(this);
		rdbtnIdade60.addActionListener(this);
		rdbtnEstud.addActionListener(this);
		rdbtnProf.addActionListener(this);
		rdbtnOutros.addActionListener(this);
		
		
		btnGroup.add(rdbtnIdade5);
		btnGroup.add(rdbtnIdade60);
		btnGroup.add(rdbtnEstud);
		btnGroup.add(rdbtnProf);
		btnGroup.add(rdbtnOutros);
		
		return panelCampos;
	}
	
	public JComponent botoes (){
		JPanel panelBotoes = new JPanel( new GridLayout(4,1));
		
		
		btnNovo = new JButton("Nova Venda");
		btnNovo.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/new.png")));
		btnNovo.addActionListener(this);
		btnFinalizar = new JButton("Finalizar Venda");
		btnFinalizar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/salvar.png")));
		btnFinalizar.addActionListener(this);
		btnVisualizarVendas = new JButton("Visualizar Vendas");
		btnVisualizarVendas.addActionListener(this);
		btnFecharCaixa = new JButton ("Fechar Caixa");
		btnFecharCaixa.addActionListener(this);
		
		panelBotoes.add(btnFecharCaixa);
		panelBotoes.add(btnVisualizarVendas);
		panelBotoes.add(btnNovo);
		panelBotoes.add(btnFinalizar);
		
		return panelBotoes;		
	}
	
		public IngressoEntity formVenda() {
			IngressoEntity ing = new IngressoEntity();
			ing.setObrasexp(exposicao);
			ing.setIdade5(rdbtnIdade5.isSelected());
			ing.setIdade60(rdbtnIdade60.isSelected());
			ing.setEstudante(rdbtnEstud.isSelected());
			ing.setProfessor(rdbtnProf.isSelected());
			ing.setOutros(rdbtnOutros.isSelected());
			ing.setValor(Double.parseDouble(txtValor.getText()));
			ing.setDesconto(Double.parseDouble(txtDesconto.getText()));
			ing.setTotal(Double.parseDouble(txtTotal.getText()));
			return ing;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Finalizar Venda".equals(cmd)) {
			if(validaSelecao()){
				ingcontrol.salvar(formVenda());
				JOptionPane.showMessageDialog(null, "Venda efetuada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				limpaCampos();		
			}else{
				JOptionPane.showMessageDialog(null, "Selecione um ingresso para venda", "ERRO", JOptionPane.WARNING_MESSAGE);
			}
		

		}
		else if ("Nova Venda".equals(cmd)){
			limpaCampos();

		}
		
		if("Menor que 5 anos".equals(cmd) || ("Maior que 60 anos".equals(cmd)))
		{

			CalculaTotalPagar();
		}
			
			
			
		if(("Outros".equals(cmd)) || ("Estudante".equals(cmd) || ("Professor".equals(cmd)))){
						
			
				CalculaTotalPagar();
		}
		if("Fechar Caixa".equals(cmd)){
			
			IngressoDialog.dispose();
		}
		
		
		
	}
	
	private boolean validaSelecao() {
		if(tabelaExposicaoIngresso.getSelectedRow() != -1)
		return true;
		return false;
	}

	public void CalculaTotalPagar(){
		if(rdbtnIdade5.isSelected()|| rdbtnIdade60.isSelected()){
			valorDesconto = valorIngresso;	
		}else if(rdbtnOutros.isSelected()){
			valorDesconto = 0.00;
		}else if(rdbtnEstud.isSelected() || rdbtnProf.isSelected()){
			valorDesconto = valorIngresso/2;
		}
		
		txtDesconto.setText(""+valorDesconto);	
		valorTotalAPagar = valorIngresso - valorDesconto;
		txtTotal.setText(""+valorTotalAPagar);
		
		
	}


	private void limpaCampos() {
		
		
		
		btnGroup.clearSelection();
		
		valorTotalAPagar = 0.00;
		valorDesconto=0.00;
		valorIngresso=0.00;
		txtDesconto.setText(valorDesconto.toString());
		txtValor.setText(valorIngresso.toString());
		txtTotal.setText(valorTotalAPagar.toString());		
		CalculaTotalPagar();
		
		tabelaExposicaoIngresso.clearSelection();
		
	}
	

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int linha = tabelaExposicaoIngresso.getSelectedRow();
		if(linha != -1){
		idExposicao = (Long) tabelaExposicaoIngresso.getValueAt(linha, 0);
		exposicao = (String) tabelaExposicaoIngresso.getValueAt(linha, 1);
		nomeExposicao.setText(exposicao);
		valorIngresso = (Double) tabelaExposicaoIngresso.getValueAt(linha, 4); 
		txtValor.setText(""+ valorIngresso);
		}
		
		limpaDesconto();
		CalculaTotalPagar();
		
	}
	public void limpaDesconto(){
		valorDesconto = 0.00;
		valorTotalAPagar = 0.00;
		
		
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

}