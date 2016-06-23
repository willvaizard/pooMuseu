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
import entity.Local;
import entity.Visitante;
import persistence.ILocalDAO;
import persistence.LocalDAO;
import persistence.VisitantesDAO;

public class LocalController {
	private ILocalDAO lDao = new LocalDAO(); 

//	public LocalController() {
//		populaTabela();
//	}

//	public void populaTabela(){
//		lista.clear();
//		LocalDAO lDao;
//		try {
//			lDao = new LocalDAO();
//			 List<LocalEntity> list = lDao.ConsultaLocal();
//			 
//			for (LocalEntity V : list){
//				lista.add(V);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void salvar(Local local) {
		lDao.InsereLocal(local);
		JOptionPane.showMessageDialog(null, "Cadastrado com successo", "Cadastro concluido",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public List<Local> pesquisar(String nome) {
			return lDao.ConsultaLocal(nome);
	}
	
	public void alterar(Local local) {
		lDao.AtualizaLocal(local);
		JOptionPane.showMessageDialog(null, "Cadastro atualizado com successo", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void excluir(int codigo) {
		lDao.ExcluiLocal(codigo);	
		JOptionPane.showMessageDialog(null, "Cadastro excluído", "Confirmação",
				JOptionPane.INFORMATION_MESSAGE);
	}





}
