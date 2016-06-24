package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Exposicao;

public interface iExposicaoDAO {
	void insert (Exposicao exp) throws SQLException;
	List<Exposicao> getTodasExposicoes() throws SQLException;
}
