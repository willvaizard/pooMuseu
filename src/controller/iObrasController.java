package controller;

import entity.Obras;

public interface iObrasController {
	public void inserir(Obras ob);
	public void alterar(Obras ob);
	public void DeletarObra(int idObra);
	public Obras getObrasByID(int idObra);
	public Obras consultar();
	
	
	
}
