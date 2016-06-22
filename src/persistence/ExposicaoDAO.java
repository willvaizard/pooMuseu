package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import entity.Exposicao;

public class ExposicaoDAO {
	private Connection con;
	public ExposicaoDAO() throws SQLException {
	con = JDBCUtil.getConnection();
	}
	
	public void insert (Exposicao exp) throws SQLException{
		
		String sql = "INSERT INTO exposicao (exposicao_nome, data_inicio, data_fim, valor) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, exp.getExposicao_nome());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date d = new java.sql.Date( exp.getDataInicio().getTime());
		ps.setDate(2,   d);
		java.sql.Date d2 = new java.sql.Date(exp.getDataFim().getTime());
		ps.setDate(3, d2);
		ps.setDouble(4, exp.getValor());
		ps.close();

		
	}

}
