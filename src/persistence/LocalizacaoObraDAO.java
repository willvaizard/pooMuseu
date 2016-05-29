package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CategoriaObras;
import entity.LocalizacaoObras;

public class LocalizacaoObraDAO {
	Connection con;
	
	public LocalizacaoObraDAO() throws SQLException {
		con = JDBCUtil.getConnection();
	}
	
	public List<LocalizacaoObras> ConsultaLocalizacao () throws SQLException{
		List<LocalizacaoObras> lista = new ArrayList<LocalizacaoObras>();
		String sql = "SELECT id, concat(id, ' - ', nome) as nome from obra_categoria";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			LocalizacaoObras co = new LocalizacaoObras();	
			co.setIdLocalizacao(rs.getInt("id"));
			co.setLocalizacaoObra(rs.getString("nome"));
			lista.add(co);
			
		}
		
		
		
		return lista;
	}

}
