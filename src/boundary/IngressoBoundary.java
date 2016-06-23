package boundary;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	private JButton btnAjustar;
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
	private double valorTotalAPagar=0.0;

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
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Venda de Ingressos");
		titulo.setFont(new Font("Paladino", Font.BOLD, 18));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelTopo.add(titulo);

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

		JLabel lblTotal = new JLabel("Total a Pagar:");
		lblTotal.setBounds(20, 200, 200, 14);
		panelCampos.add(lblTotal);
		txtTotal = new JLabel("0.00");
		txtTotal.setBounds(225, 200, 150, 20);
		panelCampos.add(txtTotal);
		
		ButtonGroup bg = new ButtonGroup();
		rdbtnIdade5.addActionListener(this);
		rdbtnIdade60.addActionListener(this);
		rdbtnEstud.addActionListener(this);
		rdbtnProf.addActionListener(this);
		rdbtnOutros.addActionListener(this);
		
		
		bg.add(rdbtnIdade5);
		bg.add(rdbtnIdade60);
		bg.add(rdbtnEstud);
		bg.add(rdbtnProf);
		bg.add(rdbtnOutros);
		System.out.println(tabelaExposicaoIngresso.getSelectedRow());
		
		return panelCampos;
	}
	
	public JComponent botoes (){
		JPanel panelBotoes = new JPanel( new GridLayout(3,1));
		
		btnAjustar = new JButton("Ajustar Descontos");
		btnAjustar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/edit.png")));
		btnAjustar.addActionListener(this);
		btnNovo = new JButton("Nova Venda");
		btnNovo.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/new.png")));
		btnNovo.addActionListener(this);
		btnFinalizar = new JButton("Finalizar Venda");
		btnFinalizar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/salvar.png")));
		btnFinalizar.addActionListener(this);

		panelBotoes.add(btnAjustar);
		panelBotoes.add(btnNovo);
		panelBotoes.add(btnFinalizar);
		return panelBotoes;		
	}
	
	public IngressoEntity formVenda() {
		IngressoEntity ing = new IngressoEntity();
		ing.setIdade5(rdbtnIdade5.getText());
		ing.setIdade60(rdbtnIdade60.getText());
		ing.setEstudante(rdbtnEstud.getText());
		ing.setProfessor(rdbtnProf.getText());
		ing.setOutros(rdbtnOutros.getText());
		ing.setValor(txtValor.getText());
		ing.setDesconto(txtDesconto.getText());
		ing.setTotal(txtTotal.getText());
		return ing;
	}

	public void IngressoToForm(IngressoEntity ing) {
		rdbtnIdade5.setText(ing.getIdade5());
		rdbtnIdade60.setText(ing.getIdade60());
		rdbtnEstud.setText(ing.getEstudante());
		rdbtnProf.setText(ing.getProfessor());
		rdbtnOutros.setText(ing.getOutros());
		txtValor.setText(ing.getValor());
		txtDesconto.setText(String.valueOf(ing.getDesconto()));
		txtTotal.setText(ing.getTotal());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Finalizar Venda".equals(cmd)) {
			ingcontrol.salvar(formVenda());
			limpaCampos();
			habilitaMeiaEntrada();
		}
		else if ("Nova Venda".equals(cmd)){
			limpaCampos();
			habilitaMeiaEntrada();
		}
		
		if("Menor que 5 anos".equals(cmd) || ("Maior que 60 anos".equals(cmd)))
		{
			desabilitaMeiaEntrada();
			CalculaTotalPagar();
		}
			
			
			
		if(("Outros".equals(cmd)) || ("Estudante".equals(cmd) || ("Professor".equals(cmd)))){
						
		
				CalculaTotalPagar();
		}
		
		
		
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
		rdbtnIdade5.setSelected(false);
		rdbtnIdade60.setSelected(false);
		rdbtnEstud.setSelected(false);
		rdbtnProf.setSelected(false);
		rdbtnOutros.setSelected(false);
		txtDesconto.setText("0.00");
		txtTotal.setText("0.00");
		valorTotalAPagar = 0.00;
		valorDesconto=0.00;
		valorIngresso=0.00;
		CalculaTotalPagar();
		tabelaExposicaoIngresso.clearSelection();
		
	}
	

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int linha = tabelaExposicaoIngresso.getSelectedRow();
		if(linha != -1){
		idExposicao = (Long) tabelaExposicaoIngresso.getValueAt(linha, 0);
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
	public void desabilitaMeiaEntrada(){
	rdbtnEstud.setEnabled(false);
	rdbtnProf.setEnabled(false);
	rdbtnOutros.setEnabled(false);
	
		
	}
	public void habilitaMeiaEntrada(){
		rdbtnEstud.setEnabled(true);
		rdbtnProf.setEnabled(true);
		rdbtnOutros.setEnabled(true);	
		
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