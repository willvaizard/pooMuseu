package boundary;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.IngressoController;
import entity.IngressoEntity;

public class IngressoBoundary extends JFrame implements ActionListener, ListSelectionListener {

	private JPanel panelIngresso = new JPanel(new BorderLayout());
	private JComboBox<Object> cbObras;
	private JRadioButton rdbtnIdade5;
	private JRadioButton rdbtnIdade60;
	private JRadioButton rdbtnEstud;
	private JRadioButton rdbtnProf;
	private JRadioButton rdbtnOutros;
	private JTextField txtValor;
	private JTextField txtDesconto;
	private JTextField txtTotal;
	private JButton btnAjustar;
	private JButton btnNovo;
	private JButton btnFinalizar;
	private JDialog IngressoDialog = new JDialog();


	private IngressoController ingcontrol = new IngressoController();

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
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(null);





		return panelCentro;
	}

	private JComponent sul() {
		JPanel panelSul = new JPanel(new GridLayout(1,2));
		panelSul.add(Campos(),BorderLayout.CENTER);
		panelSul.add(botoes(), BorderLayout.PAGE_END);
		return panelSul;
	}
	
	public JComponent Campos(){
		JPanel panelCampos = new JPanel(new GridLayout(9,1));
		JLabel lblObras = new JLabel("Obras em Exposição:");
		lblObras.setBounds(20, 25, 150, 14);
		panelCampos.add(lblObras);
		cbObras = new JComboBox<>();
		cbObras.addItem("");
		cbObras.addItem("Teste Obra 1");
		cbObras.addItem("Teste Obra 2");
		cbObras.setBounds(225, 25, 150, 20);
		panelCampos.add(cbObras);

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

		JLabel lblValor = new JLabel("Valor do Ingresso Inteiro:");
		lblValor.setBounds(20, 150, 200, 14);
		panelCampos.add(lblValor);
		txtValor = new JTextField(25);
		txtValor.setBounds(225, 150, 150, 20);
		panelCampos.add(txtValor);

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(20, 175, 200, 14);
		panelCampos.add(lblDesconto);
		txtDesconto = new JTextField(25);
		txtDesconto.setBounds(225, 175, 150, 20);
		panelCampos.add(txtDesconto);

		JLabel lblTotal = new JLabel("Total a Pagar:");
		lblTotal.setBounds(20, 200, 200, 14);
		panelCampos.add(lblTotal);
		txtTotal = new JTextField(60);
		txtTotal.setBounds(225, 200, 150, 20);
		panelCampos.add(txtTotal);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnIdade5);
		bg.add(rdbtnIdade60);
		bg.add(rdbtnEstud);
		bg.add(rdbtnProf);
		bg.add(rdbtnOutros);
		
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
		ing.setObrasexp(cbObras.getSelectedItem().toString());
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
		cbObras.setSelectedItem(ing.getObrasexp());
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
		}
		else if ("Nova Venda".equals(cmd)){
			limpaCampos();
		}
		
	}


	private void limpaCampos() {
		cbObras.setSelectedItem("");
		rdbtnIdade5.setSelected(false);
		rdbtnIdade60.setSelected(false);
		rdbtnEstud.setSelected(false);
		rdbtnProf.setSelected(false);
		rdbtnOutros.setSelected(false);
		txtValor.setText("");
		txtDesconto.setText("");
		txtTotal.setText("");
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}