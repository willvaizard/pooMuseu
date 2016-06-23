package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.LocalEntity;

public interface ILocalDAO {
	public void InsereLocal (LocalEntity local);
	public List<LocalEntity> ConsultaLocal(String nome);
	public void AtualizaLocal (LocalEntity local);
	public void ExcluiLocal (int codigo);
	

}
