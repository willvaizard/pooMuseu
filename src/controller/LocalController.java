package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import boundary.LocalBoundary;
import entity.LocalEntity;
import entity.VisitanteEntity;
import persistence.LocalDAO;
import persistence.VisitantesDAO;

public class LocalController {
	List<LocalEntity> lista = new ArrayList<LocalEntity>();

	public LocalController() {
		populaTabela();
	}

	public void populaTabela(){
		lista.clear();
		LocalDAO lDao;
		try {
			lDao = new LocalDAO();
			 List<LocalEntity> list = lDao.ConsultaLocal();
			 
			for (LocalEntity V : list){
				lista.add(V);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public LocalEntity pesquisar(String codigo) {

		LocalEntity local = null;
		// for (LocalEntity lcl : lista){
		// if (lcl.getCodigo().contains(codigo)){
		// local = lcl;
		// }
		// }

		return local;

	}

	public void remover(LocalEntity local) {
		try {
			LocalDAO lDao = new LocalDAO();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void alterar(LocalEntity local) {
		try {
			LocalDAO lDao = new LocalDAO();
			lDao.AtualizaLocal(local);
			JOptionPane.showMessageDialog(null, "Cadastro atualizado com successo", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void salvar(LocalEntity local) {
		try {
			LocalDAO lDao = new LocalDAO();
			lDao.InsereLocal(local);
			JOptionPane.showMessageDialog(null, "Cadastro inserido com successo", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
