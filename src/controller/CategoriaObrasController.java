package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CategoriaObras;
import persistence.CategoriaObrasDAO;
import persistence.ICategoriaObrasDAO;

public class CategoriaObrasController {
	
	public CategoriaObrasController() {

	}
	
	public List<CategoriaObras> Categoria() {		
		List<CategoriaObras> listaCategoria = new ArrayList<CategoriaObras>();			
		try {
			ICategoriaObrasDAO cDao = new CategoriaObrasDAO();
			listaCategoria = cDao.ConsultaCategoria();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return listaCategoria;		
	}
	
	public void adicionarNovaCategoria(CategoriaObras cat){		
		try {
			ICategoriaObrasDAO cDao = new CategoriaObrasDAO();
			cDao.insere(cat);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
				
	}
	
}
