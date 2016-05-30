package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CategoriaObras;
import persistence.CategoriaObrasDAO;

public class CategoriaObrasController {
	
	public CategoriaObrasController() {

	}
	

	
	public List<CategoriaObras> Categoria() {
		
		List<CategoriaObras> listaCategoria = new ArrayList<CategoriaObras>();
		
		
		try {
			CategoriaObrasDAO cDao = new CategoriaObrasDAO();
			listaCategoria = cDao.ConsultaCategoria();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return listaCategoria;
		
		
	}
	
	public void adicionarNovaCategoria(CategoriaObras cat){
		
		try {
			CategoriaObrasDAO cDao = new CategoriaObrasDAO();
			cDao.insere(cat);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	
}
