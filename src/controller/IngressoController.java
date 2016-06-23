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
import persistence.ILocalDAO;
import persistence.LocalDAO;
import persistence.VisitantesDAO;

public class IngressoController {
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

	public void salvar(LocalEntity local) {
		lDao.InsereLocal(local);
	}
	
	public List<LocalEntity> pesquisar(String nome) {
			return lDao.ConsultaLocal(nome);
	}
	
	
	
	
	
	
	
	
	
	

	public void remover(LocalEntity local) {


	}

	public void alterar(LocalEntity local) {
			lDao.AtualizaLocal(local);
			JOptionPane.showMessageDialog(null, "Cadastro atualizado com successo", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

	}



}
