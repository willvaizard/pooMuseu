package persistence;

import java.sql.SQLException;
import java.util.List;
import entity.tipoObras;

public interface IObrasTipoObraDAO {	
	public List<tipoObras> ConsultaTipoObra () throws SQLException;	
	public void insere(tipoObras tpObra) throws SQLException;

}
