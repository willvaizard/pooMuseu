package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.Local;

public interface ILocalDAO {
	public void InsereLocal (Local local);
	public List<Local> ConsultaLocal(String nome);
	public void AtualizaLocal (Local local);
	public void ExcluiLocal (int codigo);
	

}
