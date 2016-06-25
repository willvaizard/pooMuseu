package persistence;

import java.sql.SQLException;

import entity.EmprestimoDeObra;
import entity.Local;

public interface iEmprestimoDeObraDAO {
	public void insertEmprestimo(EmprestimoDeObra eo)throws SQLException;
	public void AtualizaEmprestimo (EmprestimoDeObra eo) throws SQLException;
	public void ExcluiEmprestimo (int idEmprestimo) throws SQLException;
}
