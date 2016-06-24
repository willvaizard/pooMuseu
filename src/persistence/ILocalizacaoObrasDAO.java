package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.LocalizacaoObras;

public interface ILocalizacaoObrasDAO {	
	public List<LocalizacaoObras> ConsultaLocalizacao() throws SQLException;
	public void insere(LocalizacaoObras loc) throws SQLException;

}
