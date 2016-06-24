package persistence;

import java.sql.SQLException;

import entity.EmprestimoDeObra;

public interface iEmprestimoDeObraDAO {
	void insertEmprestimo(EmprestimoDeObra eo)throws SQLException;
}
