package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.Obras;
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
		ps.executeUpdate();
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
		ps.close();
		rs.close();
		return listaExp;
	}
	
	public void incluiObraExposicao (Obras ob) throws SQLException{
		String sql = "INSERT INTO exposicao_obra values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, ob.getExposicao_id());
		ps.setLong(2, ob.getIdObras());
		ps.executeUpdate();
		
		ps.close();
		
	}
	
	public int deleteObras (Obras ob) throws SQLException{
		String sql = "DELETE FROM exposicao_obra WHERE exposicao_id = ? and obra_id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, ob.getExposicao_id());
		ps.setLong(2, ob.getIdObras());
		int affects = ps.executeUpdate();
		
		
		return affects;
	}
	
	public long ultimoID(){
		long idMax=0;
		String sql = "SELECT MAX(exposicao_id) as idMax from exposicao";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				idMax = rs.getInt("idMax");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idMax;
	}
	

}
