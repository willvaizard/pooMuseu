package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.VisitanteEntity;

public interface iGenericDao {
	public void InsereVisitante (VisitanteEntity vst) throws SQLException;
	public List<VisitanteEntity> ConsultaVisitantes() throws SQLException;
	

}
