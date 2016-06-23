package controller;

import entity.IngressoEntity;
import persistence.IIngressoDAO;
import persistence.IngressoDAO;

public class IngressoController {
	private IIngressoDAO ingDao = new IngressoDAO(); 

	public void salvar(IngressoEntity ingressoEntity) {
		ingDao.InsereVenda(ingressoEntity);
	}
}