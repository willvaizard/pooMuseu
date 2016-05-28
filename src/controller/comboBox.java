package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.tipoObras;
import persistence.ObrastipoObraDAO;

public class comboBox {
	
	public comboBox() {
		// TODO Auto-generated constructor stub
	}
	
	public List<tipoObras> tipoObra (){
		ObrastipoObraDAO oDao;
		List<tipoObras> tpObra= new ArrayList<tipoObras>();
		try {
			oDao = new ObrastipoObraDAO();
			tpObra = oDao.ConsultaTipoObra();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return tpObra;
		
	}
	
	public List<Object> Categoria(){
		
		List<Object> Categoria = new ArrayList<Object>();
		
		Categoria.add("");
		Categoria.add("Moderna");
		Categoria.add("Barroca");
		Categoria.add("Cubista");
		Categoria.add("Realista");
		Categoria.add("Outro");
		
		
		
		return Categoria;
		
		
	}
	
	public List<Object> Localizacao (){
		
		List<Object> Local = new ArrayList<Object>();
		Local.add("");
		Local.add("Salao Principal");
		Local.add("Primeiro Andar");
		Local.add("Subterraneo");
		Local.add("Outro");
		
		
		
		
		return Local;
		
		
	}

	
	
	
}
