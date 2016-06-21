package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LocalizacaoObras;

public class LocalizacaoObrasDAO {
	Connection con;
	
	public LocalizacaoObrasDAO() throws SQLException {
		con = JDBCUtil.getConnection();
	}
	
	public List<LocalizacaoObras> ConsultaLocalizacao () throws SQLException{
		List<LocalizacaoObras> lista = new ArrayList<LocalizacaoObras>();
		String sql = "SELECT id, nome from obra_localizacao ORDER BY id";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			LocalizacaoObras loc = new LocalizacaoObras();	
			loc.setIdLocalizacao(rs.getInt("id"));
			loc.setLocalizacao(rs.getString("nome"));
			lista.add(loc);
			
		}
		ps.close();
		rs.close();
		
		
		
		return lista;
	}
	public void insere (LocalizacaoObras loc) throws SQLException{
		String sql = "INSERT INTO obra_localizacao (nome) values (?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, loc.getLocalizacao());
		ps.execute();
		ps.close();
		
		
	}

}
