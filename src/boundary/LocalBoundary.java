package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import controller.LocalController;
import controller.comboBox;
import entity.VisitanteEntity;
import entity.tipoObras;

public class LocalBoundary implements ActionListener {
	
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
	private JDialog LocalDialog = new JDialog();

	private JRadioButton rdbtnAtivo;
	private JRadioButton rdbtnInativo;

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

//		LocalController localController = new LocalController(txtCodigo, txtNome, txtEmail, txtTelefone, txtResponsavel,
//				txtCep, txtLogradouro, txtNumero, txtComplemento, txtBairro, txtCidade, cmbUf, rdbtnAtivo, rdbtnInativo,
//				btnSalvar, btnAlterar, btnRemover, btnPesquisar);
//		btnSalvar.addActionListener(localController);
		btnSalvar.addActionListener(this);

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
		txtCodigo.setEditable(false);
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
		cmbUf = new JComboBox<Object>(new Object[] {"", "AC", "AL", "AM", "AP", "BA", "CE", 
				"DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ",
				"RN", "RO", "RS", "SC", "SE", "SP", "TO"});
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
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/edit.png")));
		btnRemover = new JButton("Remover");
		btnRemover.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/delete.png")));
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/lupa.png")));

		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnRemover);
		panelBotoes.add(btnPesquisar);

		return panelBotoes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSalvar){
			LocalController lController = new LocalController(txtCodigo, txtNome, txtEmail, txtTelefone, txtResponsavel, txtCep, txtLogradouro, txtNumero, txtComplemento, txtBairro, txtCidade, cmbUf, rdbtnAtivo, rdbtnInativo, btnSalvar, btnAlterar, btnRemover, btnPesquisar);
			//lController = new CadastroVisitanteBoundary();
			btnSalvar.addActionListener(lController);
		}
		
	}

}
