package persistence;

import java.sql.SQLException;

import entity.EmprestimoDeObra;

public class EmprestimoDeObraDAO implements iEmprestimoDeObraDAO{

	@Override
	public void insertEmprestimo(EmprestimoDeObra eo) throws SQLException {
		String sql = "INSERT INTO from emprestimo_obra(dataEmprestimo, dataDevolucao,idObra, obra_id, local_id)";
		
		
	}

}
