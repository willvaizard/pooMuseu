package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CategoriaObras;
import entity.LocalizacaoObras;
import entity.tipoObras;
import persistence.CategoriaObrasDAO;
import persistence.LocalizacaoObraDAO;
import persistence.ObrasTipoObraDAO;

public class LocalizacaoObrasController {
	
	public LocalizacaoObrasController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public List<LocalizacaoObras> Localizacao (){
		
		List<LocalizacaoObras> local = new ArrayList<LocalizacaoObras>();
		
		try {
			LocalizacaoObraDAO lDao = new LocalizacaoObraDAO();
			local = lDao.ConsultaLocalizacao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return local;
		
		
	}

	
	
	
}
