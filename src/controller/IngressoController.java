package controller;

import entity.Ingresso;
import persistence.iIngressoDAO;
import persistence.IngressoDAO;

public class IngressoController {
	private iIngressoDAO ingDao = new IngressoDAO(); 

	public void salvar(Ingresso ingressoEntity) {
		ingDao.InsereVenda(ingressoEntity);
	}
	
	public Ingresso getValoresTotal(){
		
		IngressoDAO iDao = new IngressoDAO();
			Ingresso ing = iDao.getValoresTotal();
		return  ing;
		
		
	}
}