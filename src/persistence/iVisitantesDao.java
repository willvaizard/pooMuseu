package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.VisitanteEntity;

public interface iVisitantesDao {
	public void InsereVisitante ();
	public List<VisitanteEntity> ConsultaVisitantes() throws SQLException;
	

}
