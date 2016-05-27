package controller;

import java.util.ArrayList;
import java.util.List;

public class DadosEstaticos {
	
	public DadosEstaticos() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Object> tipoObra (){
		
		List<Object> tpObra = new ArrayList<Object>();
		tpObra.add("");
		tpObra.add("Pintura");
		tpObra.add("Escultura");
		tpObra.add("Fotografia");
		tpObra.add("Livro");
		tpObra.add("Outro");
		
		
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
