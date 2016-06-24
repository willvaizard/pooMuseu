package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Obras;

public interface iObrasDAO {
	List<Obras> ConsultaByObras (String nomeObra) throws SQLException;
	List<Obras> ConsultaByAutor (String nomeAutor) throws SQLException;
	List<Obras> getLista() throws SQLException;
	Obras ConsultaObraById(int id) throws SQLException;
	void Inserir(Obras ob)throws SQLException;
	void update (Obras ob) throws SQLException;
	void delete (int idObra) throws SQLException;
	List<Obras> ConsultaObrasDaExposicao(long idExposicao) throws SQLException;
}
