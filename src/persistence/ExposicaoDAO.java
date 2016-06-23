package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.Exposicao;

public class ExposicaoDAO implements iExposicaoDAO{
	private Connection con;
	public ExposicaoDAO() throws SQLException {
	con = JDBCUtil.getConnection();
	}
	@Override
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

	@Override
	public List<Exposicao> getTodasExposicoes() throws SQLException {
		List<Exposicao> listaExp = new ArrayList<Exposicao>();
		String sql = "SELECT * FROM exposicao";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Exposicao exp = new Exposicao();
			exp.setExposicao_id(rs.getInt("exposicao_id"));
			exp.setExposicao_nome(rs.getString("exposicao_nome"));
			exp.setDataInicio(rs.getDate("data_inicio"));
			exp.setDataFim(rs.getDate("data_fim"));
			exp.setValor(rs.getDouble("valor"));
			listaExp.add(exp);
		}
		return listaExp;
	}

}