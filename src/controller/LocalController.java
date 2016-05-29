package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import boundary.LocalBoundary;
import entity.LocalEntity;
import persistence.LocalDAO;

public class LocalController implements ActionListener {

	JTextField txtCodigo, txtNome, txtEmail, txtTelefone, txtResponsavel, txtCep, txtLogradouro, txtNumero,
			txtComplemento, txtBairro, txtCidade;
	JComboBox<Object> cmbUf;
	JRadioButton rdbtnAtivo, rdbtnInativo;
	JButton btnSalvar, btnAlterar, btnRemover, btnPesquisar;

	public LocalController(JTextField txtCodigo, JTextField txtNome, JTextField txtEmail, JTextField txtTelefone,
			JTextField txtResponsavel, JTextField txtCep, JTextField txtLogradouro, JTextField txtNumero,
			JTextField txtComplemento, JTextField txtBairro, JTextField txtCidade, JComboBox<Object> cmbUf,
			JRadioButton rdbtnAtivo, JRadioButton rdbtnInativo, JButton btnSalvar, JButton btnAlterar,
			JButton btnRemover, JButton btnPesquisar) {
		// super();
		this.txtCodigo = txtCodigo;
		this.txtNome = txtNome;
		this.txtEmail = txtEmail;
		this.txtTelefone = txtTelefone;
		this.txtResponsavel = txtResponsavel;
		this.txtCep = txtCep;
		this.txtLogradouro = txtLogradouro;
		this.txtNumero = txtNumero;
		this.txtComplemento = txtComplemento;
		this.txtBairro = txtBairro;
		this.txtCidade = txtCidade;
		this.cmbUf = cmbUf;
		this.rdbtnAtivo = rdbtnAtivo;
		this.rdbtnInativo = rdbtnInativo;
		this.btnSalvar = btnSalvar;
		this.btnAlterar = btnAlterar;
		this.btnRemover = btnRemover;
		this.btnPesquisar = btnPesquisar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LocalEntity local = new LocalEntity();
		if (e.getSource() == btnSalvar) {
			
			if (validaCampos()) {
				salvar(local);
				limpaCampos();
			}

		}

		// if (btnSalvar.isSelected()){
		// salvar(local);
		// } else if (btnAlterar.isSelected()){
		// alterar(local);
		// } else if (btnRemover.isSelected()){
		// remover(local);
		// } else if (btnPesquisar.isSelected()){
		// pesquisar(local);
		// }
		limpaCampos();

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

	private void pesquisar(LocalEntity local) {
		System.out.println("Pesquisar");

	}

	private void remover(LocalEntity local) {
		// TODO Auto-generated method stub

	}

	private void alterar(LocalEntity local) {
		// TODO Auto-generated method stub

	}

	private void salvar(LocalEntity local) {
		try {
			LocalDAO lDao = new LocalDAO();
			validaCampos();
			lDao.InsereLocal(local);
			JOptionPane.showMessageDialog(null, "Cadastro inserido com successo", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
			LocalController lController = new LocalController(txtCodigo, txtNome, txtEmail, txtTelefone, txtResponsavel, txtCep, txtLogradouro, txtNumero, txtComplemento, txtBairro, txtCidade, cmbUf, rdbtnAtivo, rdbtnInativo, btnSalvar, btnAlterar, btnRemover, btnPesquisar);
			lController.proximoCodigo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void proximoCodigo() {
		try {
			LocalDAO lDao = new LocalDAO();
			txtCodigo.setText(String.valueOf(lDao.proximoCodigo()));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			// e.printStackTrace();
		}

	}

	private boolean validaCampos() {
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
		} else if (txtComplemento.getText().trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Informar complemento", "Alerta", JOptionPane.INFORMATION_MESSAGE);
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
		} else if (!rdbtnAtivo.isSelected() || !rdbtnInativo.isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione o status", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			return true;
		}

	}

}
