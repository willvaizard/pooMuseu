package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.obra;

public interface iExposicaoDAO {
	void insert (obra exp) throws SQLException;
	List<obra> getTodasExposicoes() throws SQLException;
}
