package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Obras;
import entity.Exposicao;


public class ExposicaoDAO implements iExposicaoDAO{
	@Override
	public void insert (Exposicao exp) throws SQLException{
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "INSERT INTO exposicao (exposicao_nome, data_inicio, data_fim, valor) values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, exp.getExposicao_nome());		
		java.sql.Date d = new java.sql.Date( exp.getDataInicio().getTime());
		ps.setDate(2,   d);
		java.sql.Date d2 = new java.sql.Date(exp.getDataFim().getTime());
		ps.setDate(3, d2);
		ps.setDouble(4, exp.getValor());
		ps.executeUpdate();
		JDBCUtil.getInstancia().closeConnection();	
	}

	@Override
	public List<Exposicao> getTodasExposicoes() throws SQLException {
		List<Exposicao> listaExp = new ArrayList<Exposicao>();
		Connection con = JDBCUtil.getInstancia().getConnection();
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
		rs.close();
		JDBCUtil.getInstancia().closeConnection();
		return listaExp;
	}
	
	@Override
	public void incluiObraExposicao (Obras ob) throws SQLException{
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "INSERT INTO exposicao_obra values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, ob.getExposicao_id());
		ps.setLong(2, ob.getIdObras());
		ps.executeUpdate();
		JDBCUtil.getInstancia().closeConnection();
		
	}
	@Override
	public int deleteObras (Obras ob) throws SQLException{
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "DELETE FROM exposicao_obra WHERE exposicao_id = ? and obra_id = ?";		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, ob.getExposicao_id());
		ps.setLong(2, ob.getIdObras());
		int affects = ps.executeUpdate();		
		JDBCUtil.getInstancia().closeConnection();
		return affects;
	}
	
	@Override
	public void updateExposicao (Exposicao exp)throws SQLException{
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql ="UPDATE exposicao SET exposicao_nome = ? , data_inicio = ? , "
				+ "data_fim = ?, valor = ? where exposicao_id = ? ";
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,exp.getExposicao_nome());
			java.sql.Date d = new java.sql.Date( exp.getDataInicio().getTime());
			ps.setDate(2,   d);
			java.sql.Date d2 = new java.sql.Date(exp.getDataFim().getTime());
			ps.setDate(3, d2);
			ps.setDouble(4, exp.getValor());
			ps.setLong(5, exp.getExposicao_id());			
			ps.executeUpdate();
			JDBCUtil.getInstancia().closeConnection();			
	}
	
	public long ultimoID(){
		Connection con = JDBCUtil.getInstancia().getConnection();
		long idMax=0;
		String sql = "SELECT MAX(exposicao_id) as idMax from exposicao";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				idMax = rs.getInt("idMax");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.getInstancia().closeConnection();
		return idMax;
	}
	

}
