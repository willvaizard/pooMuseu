package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LocalizacaoObras;
import persistence.ILocalizacaoObrasDAO;
import persistence.LocalizacaoObrasDAO;

public class LocalizacaoObrasController {

	public LocalizacaoObrasController() {

	}

	public List<LocalizacaoObras> Localizacao() {
		List<LocalizacaoObras> local = new ArrayList<LocalizacaoObras>();
		try {
			ILocalizacaoObrasDAO lDao = new LocalizacaoObrasDAO();
			local = lDao.ConsultaLocalizacao();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return local;

	}

	public void adicionaNovaLocalizacao(LocalizacaoObras loc) {
		try {
			ILocalizacaoObrasDAO lDao = new LocalizacaoObrasDAO();
			lDao.insere(loc);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
