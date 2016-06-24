package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.obraExposicao;

public interface iExposicaoDAO {
	void insert (obraExposicao exp) throws SQLException;
	List<obraExposicao> getTodasExposicoes() throws SQLException;
}
