package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import entity.EmprestimoDeObra;

public class EmprestimoDeObraDAO implements iEmprestimoDeObraDAO{

	@Override
	public void insertEmprestimo(EmprestimoDeObra eo) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "INSERT INTO from emprestimo_obra(idEmprestimo, nomeLocal, nomeResponsavel, dataEmprestimo, dataDevolucao'+"
				+ "idLocal, nomeObra, idObra) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, eo.getIdEmprestimo());
		ps.setString(2, eo.getNomeLocal());
		ps.setString(3, eo.getNomeResponsavel());
		java.sql.Date d1 = new java.sql.Date( eo.getDataEmprestimo().getTime() );
		ps.setDate(4, d1);
		java.sql.Date d2 = new java.sql.Date( eo.getDataDevolucao().getTime() );
		ps.setDate(5, d2);
		ps.setInt(6, eo.getIdLocal());
		ps.setString(7, eo.getNomeObra());
		ps.setInt(8, eo.getIdObra());
		ps.execute();
		JDBCUtil.getInstancia().closeConnection();
		
	}

	@Override
	public void AtualizaEmprestimo(EmprestimoDeObra eo) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "UPDATE emprestimo_obra SET nomeLocal = ?, nomeResponsavel=?, dataEmprestimo=?, dataDevolucao=?'+"
				+ "idLocal=?, nomeObra=?, idObra=? WHERE idEmprestimo = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, eo.getNomeLocal());
		ps.setString(2, eo.getNomeResponsavel());
		java.sql.Date d1 = new java.sql.Date( eo.getDataEmprestimo().getTime() );
		ps.setDate(3, d1);
		java.sql.Date d2 = new java.sql.Date( eo.getDataDevolucao().getTime() );
		ps.setDate(4, d2);
		ps.setInt(5, eo.getIdLocal());
		ps.setString(6, eo.getNomeObra());
		ps.setInt(7, eo.getIdObra());
		ps.setInt(8, eo.getIdEmprestimo());
		ps.execute();
		JDBCUtil.getInstancia().closeConnection();		
	}

	@Override
	public void ExcluiEmprestimo(int idEmprestimo) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "DELETE FROM emprestimo_obra WHERE idEmprestimo LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, idEmprestimo);
		ps.execute();
		JDBCUtil.getInstancia().closeConnection();
		
	}


	
}
