package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LocalizacaoObras;
import persistence.LocalizacaoObrasDAO;

public class LocalizacaoObrasController {
	
	public LocalizacaoObrasController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public List<LocalizacaoObras> Localizacao (){
		
		List<LocalizacaoObras> local = new ArrayList<LocalizacaoObras>();
		
		try {
			LocalizacaoObrasDAO lDao = new LocalizacaoObrasDAO();
			local = lDao.ConsultaLocalizacao();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return local;
		
		
	}



	public void adicionaNovaLocalizacao(LocalizacaoObras loc) {
		
		try {
			LocalizacaoObrasDAO lDao = new LocalizacaoObrasDAO();
			lDao.insere(loc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
}
