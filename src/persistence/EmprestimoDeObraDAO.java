package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.sql.PreparedStatement;

import entity.EmprestimoDeObra;

public class EmprestimoDeObraDAO implements iEmprestimoDeObraDAO{

	@Override
	public void insertEmprestimo(EmprestimoDeObra eo) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "INSERT INTO from emprestimo_obra(dataEmprestimo, dataDevolucao,idObra, obra_id, local_id)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, eo.getIdEmprestimo());
		ps.setString(2, eo.getNomeLocal());
		ps.setString(3, eo.getNomeResponsavel());
		java.sql.Date d1 = new java.sql.Date( eo.getDataEmprestimo().getTime() );
		ps.setDate(4, d1);
		java.sql.Date d2 = new java.sql.Date( eo.getDataDevolucao().getTime() );
		ps.setDate(5, d2);
		ps.setInt(6, eo.getIdLocal());
		//ps.setString(7, eo.getNomeObra());
		ps.setInt(8, eo.getIdObra());
		ps.execute();

		
	}

}
