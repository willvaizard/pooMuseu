package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Exposicao;
import entity.Obras;

public interface iExposicaoDAO {
	void insert (Exposicao exp) throws SQLException;
	List<Exposicao> getTodasExposicoes() throws SQLException;
	void incluiObraExposicao (Obras ob) throws SQLException;
	int deleteObras (Obras ob) throws SQLException;
	void updateExposicao (Exposicao exp)throws SQLException;
	long ultimoID();
}
