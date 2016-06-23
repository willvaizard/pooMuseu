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
import javax.swing.JTextField;

import controller.LocalController;
import entity.LocalEntity;

public class LocalBoundary extends JFrame implements ActionListener {

	private JPanel panelLocal = new JPanel(new BorderLayout());
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtResponsavel;
	private JTextField txtCep;
	private JTextField txtLogradouro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox<Object> cmbUf;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JButton btnPesquisar;
	private JButton btnNovo;
	private JDialog LocalDialog = new JDialog();

	private JRadioButton rdbtnAtivo;
	private JRadioButton rdbtnInativo;

	private LocalController control = new LocalController();

	public LocalBoundary() {
		panelLocal.add(topo(), BorderLayout.NORTH);
		panelLocal.add(principal(), BorderLayout.CENTER);
		panelLocal.add(botoes(), BorderLayout.SOUTH);

		LocalDialog.setModal(true);
		LocalDialog.setLocationRelativeTo(null);
		LocalDialog.setResizable(false);
		LocalDialog.setContentPane(panelLocal);
		LocalDialog.setSize(720, 400);
		LocalDialog.setLocationRelativeTo(null);
		LocalDialog.setVisible(true);

	}

	public JComponent topo() {
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Cadastro de Locais de Empréstimo");
		titulo.setFont(new Font("Paladino", Font.BOLD, 18));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelTopo.add(titulo);

		return panelTopo;

	}

	public JComponent principal() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(500, 0, 110, 14);
		panelPrincipal.add(lblCodigo);
		txtCodigo = new JTextField(50);
		txtCodigo.setBounds(570, 0, 54, 20);
		panelPrincipal.add(txtCodigo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 25, 110, 14);
		panelPrincipal.add(lblNome);
		txtNome = new JTextField(50);
		txtNome.setBounds(125, 22, 500, 20);
		panelPrincipal.add(txtNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(20, 50, 110, 14);
		panelPrincipal.add(lblEmail);
		txtEmail = new JTextField(50);
		txtEmail.setBounds(125, 50, 500, 20);
		panelPrincipal.add(txtEmail);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(20, 75, 110, 14);
		panelPrincipal.add(lblTelefone);
		txtTelefone = new JTextField(25);
		txtTelefone.setBounds(125, 77, 200, 20);
		panelPrincipal.add(txtTelefone);

		JLabel lblResponsavel = new JLabel("Responsável:");
		lblResponsavel.setBounds(330, 75, 110, 14);
		panelPrincipal.add(lblResponsavel);
		txtResponsavel = new JTextField(25);
		txtResponsavel.setBounds(420, 77, 205, 20);
		panelPrincipal.add(txtResponsavel);

		JLabel lblEndereco = new JLabel("ENDEREÇO");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setBounds(20, 110, 110, 14);
		panelPrincipal.add(lblEndereco);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(20, 135, 110, 14);
		panelPrincipal.add(lblCep);
		txtCep = new JTextField(25);
		txtCep.setBounds(125, 131, 200, 20);
		panelPrincipal.add(txtCep);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(20, 160, 110, 14);
		panelPrincipal.add(lblLogradouro);
		txtLogradouro = new JTextField(60);
		txtLogradouro.setBounds(125, 158, 500, 20);
		panelPrincipal.add(txtLogradouro);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setBounds(20, 185, 110, 14);
		panelPrincipal.add(lblNumero);
		txtNumero = new JTextField(60);
		txtNumero.setBounds(125, 185, 150, 20);
		panelPrincipal.add(txtNumero);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(285, 185, 110, 14);
		panelPrincipal.add(lblComplemento);
		txtComplemento = new JTextField(60);
		txtComplemento.setBounds(390, 185, 235, 20);
		panelPrincipal.add(txtComplemento);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(20, 212, 110, 14);
		panelPrincipal.add(lblBairro);
		txtBairro = new JTextField(60);
		txtBairro.setBounds(125, 212, 150, 20);
		panelPrincipal.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(285, 212, 110, 14);
		panelPrincipal.add(lblCidade);
		txtCidade = new JTextField(60);
		txtCidade.setBounds(340, 212, 168, 20);
		panelPrincipal.add(txtCidade);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(528, 212, 110, 14);
		panelPrincipal.add(lblUf);
		cmbUf = new JComboBox<Object>(new Object[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA",
				"MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO" });
		cmbUf.setBounds(558, 212, 63, 20);
		panelPrincipal.add(cmbUf);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(380, 239, 110, 14);
		panelPrincipal.add(lblStatus);
		rdbtnAtivo = new JRadioButton("Ativo");
		rdbtnAtivo.setBounds(430, 239, 100, 14);
		panelPrincipal.add(rdbtnAtivo);
		rdbtnInativo = new JRadioButton("Inativo");
		rdbtnInativo.setBounds(530, 239, 100, 14);
		panelPrincipal.add(rdbtnInativo);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnInativo);
		bg.add(rdbtnAtivo);

		return panelPrincipal;
	}

	private JComponent botoes() {
		JPanel panelBotoes = new JPanel(new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/salvar.png")));
		btnSalvar.addActionListener(this);
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/edit.png")));
		btnAlterar.addActionListener(this);
		btnRemover = new JButton("Remover");
		btnRemover.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/delete.png")));
		btnRemover.addActionListener(this);
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/lupa.png")));
		btnPesquisar.addActionListener(this);
		btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/new.png")));
		btnNovo.addActionListener(this);

		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnRemover);
		panelBotoes.add(btnPesquisar);
		panelBotoes.add(btnNovo);

		return panelBotoes;
	}

	public LocalEntity formLocalDados() {
		LocalEntity lcl = new LocalEntity();
		lcl.setCodigo(Integer.parseInt(txtCodigo.getText()));
		lcl.setNome(txtNome.getText());
		lcl.setEmail(txtEmail.getText());
		lcl.setTelefone(Integer.parseInt(txtTelefone.getText()));
		lcl.setResponsavel(txtResponsavel.getText());
		lcl.setCep(Integer.parseInt(txtCep.getText()));
		lcl.setLogradouro(txtLogradouro.getText());
		lcl.setNumero(Integer.parseInt(txtNumero.getText()));
		lcl.setComplemento(txtComplemento.getText());
		lcl.setBairro(txtBairro.getText());
		lcl.setCidade(txtCidade.getText());
		lcl.setUf(cmbUf.getSelectedItem().toString());
		lcl.setAtivo(rdbtnAtivo.getText());
		lcl.setInativo(rdbtnInativo.getText());
		return lcl;
	}
	
	public void LocalToForm(LocalEntity lcl) {
		txtCodigo.setText(String.valueOf(lcl.getCodigo()));
		txtNome.setText(lcl.getNome());
		txtEmail.setText(lcl.getEmail());
		txtTelefone.setText(String.valueOf(lcl.getTelefone()));
		txtResponsavel.setText(lcl.getResponsavel());
		txtCep.setText(String.valueOf(lcl.getCep()));
		txtLogradouro.setText(lcl.getLogradouro());
		txtNumero.setText(String.valueOf(lcl.getNumero()));
		txtComplemento.setText(lcl.getComplemento());
		txtBairro.setText(lcl.getBairro());
		txtCidade.setText(lcl.getCidade());
		cmbUf.setSelectedItem(lcl.getUf());
		rdbtnAtivo.setSelected(lcl.equals(rdbtnAtivo));
		rdbtnInativo.setSelected(lcl.equals(rdbtnInativo));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("Salvar".equals(cmd)) {
			if (validaCampo()) {
				control.salvar(formLocalDados());
			}
		}

		else if ("Pesquisar".equals(cmd)) {
			if(txtNome.getText() != null){
				List<LocalEntity> lista = control.pesquisar(txtNome.getText());
				if (lista.size()>0){
					LocalToForm(lista.get(0));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Informar um nome para pesquisa", "Alerta",
				JOptionPane.INFORMATION_MESSAGE);
			}
		} else if ("Alterar".equals(cmd)) {

			if (validaCampo()) {
				control.alterar(formLocalDados());
			}

		} else if ("Remover".equals(cmd)) {

			if (validaCampo()) {
				control.excluir(Integer.parseInt(txtCodigo.getText()));
				control.pesquisar("");
				limpaCampos();
			}
		} else if ("Novo".equals(cmd)){
			limpaCampos();
		}
	}


	private void limpaCampos() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtResponsavel.setText("");
		txtCep.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtComplemento.setText("");
		txtBairro.setText("");
		txtCidade.setText("");
		cmbUf.setSelectedItem("");
		rdbtnAtivo.setSelected(false);
		rdbtnInativo.setSelected(false);
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
		} else if (cmbUf.getSelectedItem().toString() == "") {
			JOptionPane.showMessageDialog(null, "Selecionar UF", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else if (!rdbtnAtivo.isSelected() && !rdbtnInativo.isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione o status", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			return true;
		}

	}

}
