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

public class CategoriaObrasController {
	
	public CategoriaObrasController() {
		// TODO Auto-generated constructor stub
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
	

	
	
	
}
