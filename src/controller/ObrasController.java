package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import entity.Obras;
import persistence.ObrasDAO;
import persistence.iObrasDAO;

public class ObrasController implements iObrasController{

	public ObrasController() {
	
		
		
		
	}

	@Override
	public void inserir(Obras ob) {
		
		
		try {
			iObrasDAO oDao = new ObrasDAO(); 
					
			oDao.Inserir(ob);
			JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void alterar(Obras ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Obras ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Obras consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Obras  getClienteByID(int idObra) {
		Obras ob = new Obras();
		ObrasDAO oDao = new ObrasDAO();
		try {
			ob = oDao.getObraPorId(idObra);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return ob;
	}
	
	
	


	

	
}
