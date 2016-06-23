package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Visitante;

public interface iGenericDao {
	public void InsereVisitante (Visitante vst) throws SQLException;
	public List<Visitante> ConsultaVisitantes() throws SQLException;
	

}
