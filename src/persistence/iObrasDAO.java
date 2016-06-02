package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Obras;

public interface iObrasDAO {
	List<Obras> ConsultaByObras (String nomeObra) throws SQLException;
	List<Obras> getLista() throws SQLException;
	Obras getObraPorId(int id) throws SQLException;
	public void Inserir(Obras ob)throws SQLException;
}
