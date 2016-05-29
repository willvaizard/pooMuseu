package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.CategoriaObras;
import entity.LocalizacaoObras;
import entity.tipoObras;
import persistence.CategoriaObrasDAO;
import persistence.LocalizacaoObraDAO;
import persistence.ObrasTipoObraDAO;

public class tipoObrasController {
	
	public tipoObrasController() {
		// TODO Auto-generated constructor stub
	}
	
	public List<tipoObras> tipoObra (){
		ObrasTipoObraDAO oDao;
		List<tipoObras> tpObra= new ArrayList<tipoObras>();
		try {
			oDao = new ObrasTipoObraDAO();
			tpObra = oDao.ConsultaTipoObra();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
		return tpObra;
		
	}
	
	
	public void adicionaNovoTipoObra(tipoObras tpObra){
		
		try {
			ObrasTipoObraDAO oDao = new ObrasTipoObraDAO();
			oDao.insere(tpObra);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		
	}
	
	
	

	
	
	
}
