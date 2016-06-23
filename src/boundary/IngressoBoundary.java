package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import controller.IngressoController;
import controller.LocalController;
import entity.IngressoEntity;
import entity.LocalEntity;

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
		panelIngresso.add(principal(), BorderLayout.CENTER);
		panelIngresso.add(botoes(), BorderLayout.SOUTH);

		IngressoDialog.setModal(true);
		IngressoDialog.setLocationRelativeTo(null);
		IngressoDialog.setResizable(false);
		IngressoDialog.setContentPane(panelIngresso);
		IngressoDialog.setSize(720, 400);
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

	public JComponent principal() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);

		/*JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(500, 0, 110, 14);
		panelPrincipal.add(lblCodigo);
		txtCodigo = new JTextField(50);
		txtCodigo.setBounds(570, 0, 54, 20);
		panelPrincipal.add(txtCodigo);*/
		
		JLabel lblObras = new JLabel("Obras em Exposição:");
		lblObras.setBounds(20, 25, 150, 14);
		panelPrincipal.add(lblObras);
		cbObras = new JComboBox<>();
		cbObras.addItem("");
		cbObras.addItem("Brasileiro");
		cbObras.addItem("Outros");
		cbObras.setBounds(225, 25, 150, 20);
		panelPrincipal.add(cbObras);

		JLabel lblIdade5 = new JLabel("Idade:");
		lblIdade5.setBounds(20, 75, 110, 14);
		panelPrincipal.add(lblIdade5);
		rdbtnIdade5 = new JRadioButton("Menor que 5 anos");
		rdbtnIdade5.setBounds(225, 75, 150, 14);
		panelPrincipal.add(rdbtnIdade5);

		rdbtnIdade60 = new JRadioButton("Maior que 60 anos");
		rdbtnIdade60.setBounds(375, 75, 150, 14);
		panelPrincipal.add(rdbtnIdade60);

		JLabel lblTipoVisit = new JLabel("Tipo de Visitante:");
		lblTipoVisit.setBounds(20, 100, 110, 14);
		panelPrincipal.add(lblTipoVisit);
		rdbtnEstud = new JRadioButton("Estudante");
		rdbtnEstud.setBounds(225, 100, 150, 14);
		panelPrincipal.add(rdbtnEstud);

		rdbtnProf = new JRadioButton("Professor");
		rdbtnProf.setBounds(375, 100, 150, 14);
		panelPrincipal.add(rdbtnProf);
		
		rdbtnOutros = new JRadioButton("Outros");
		rdbtnOutros.setBounds(525, 100, 150, 14);
		panelPrincipal.add(rdbtnOutros);

		JLabel lblValor = new JLabel("Valor do Ingresso Inteiro:");
		lblValor.setBounds(20, 150, 200, 14);
		panelPrincipal.add(lblValor);
		txtValor = new JTextField(25);
		txtValor.setBounds(225, 150, 150, 20);
		panelPrincipal.add(txtValor);

		/*JLabel lblEndereco = new JLabel("ENDEREÇO");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setBounds(20, 110, 110, 14);
		panelPrincipal.add(lblEndereco);*/

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(20, 175, 200, 14);
		panelPrincipal.add(lblDesconto);
		txtDesconto = new JTextField(25);
		txtDesconto.setBounds(225, 175, 150, 20);
		panelPrincipal.add(txtDesconto);

		JLabel lblTotal = new JLabel("Total a Pagar:");
		lblTotal.setBounds(20, 200, 200, 14);
		panelPrincipal.add(lblTotal);
		txtTotal = new JTextField(60);
		txtTotal.setBounds(225, 200, 150, 20);
		panelPrincipal.add(txtTotal);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnIdade5);
		bg.add(rdbtnIdade60);
		bg.add(rdbtnEstud);
		bg.add(rdbtnProf);
		bg.add(rdbtnOutros);

		return panelPrincipal;
	}

	private JComponent botoes() {
		JPanel panelBotoes = new JPanel(new FlowLayout());
		btnAjustar = new JButton("Ajustar Descontos");
		btnAjustar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/salvar.png")));
		btnAjustar.addActionListener(this);
		btnNovo = new JButton("Nova Venda");
		btnNovo.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/edit.png")));
		btnNovo.addActionListener(this);
		btnFinalizar = new JButton("Finalizar venda");
		btnFinalizar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/delete.png")));
		btnFinalizar.addActionListener(this);

		panelBotoes.add(btnAjustar);
		panelBotoes.add(btnNovo);
		panelBotoes.add(btnFinalizar);

		return panelBotoes;
	}
	
	public IngressoEntity formLocalDados() {
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
/////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Salvar".equals(cmd)) {

			if (validaCampo()) {
				// proximoCodigo();
				ingcontrol.salvar(formLocalDados());
				limpaCampos();
			}

		}

		else if ("Pesquisar".equals(cmd)) {
			if(rdbtnIdade5.getText() != null){
				List<IngressoEntity> lista = ingcontrol.pesquisar(rdbtnIdade5.getText());
				if (lista.size()>0){
					IngressoToForm(lista.get(0));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Informar um nome para pesquisa", "Alerta",
				JOptionPane.INFORMATION_MESSAGE);
			}
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

	private boolean validaCampo() {
		int tamanhoCodigo = txtCodigo.getText().replace(".", "").replace("-", "").trim().length();
		if (tamanhoCodigo <= 0 && tamanhoCodigo < 11) {
			JOptionPane.showMessageDialog(null, "O Código deve ser informado", "Alerta",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtNome.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar nome", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtEmail.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar e-mail", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtTelefone.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar telefone", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtResponsavel.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar responsável", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtCep.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar CEP", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtLogradouro.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar logradouro", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtNumero.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar número", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtBairro.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar bairro", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (txtCidade.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar cidade", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		
		} else {
			return true;
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}