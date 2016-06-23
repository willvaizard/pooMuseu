package controller;

import entity.Ingresso;
import persistence.IIngressoDAO;
import persistence.IngressoDAO;

public class IngressoController {
	private IIngressoDAO ingDao = new IngressoDAO(); 

	public void salvar(Ingresso ingressoEntity) {
		ingDao.InsereVenda(ingressoEntity);
	}
}