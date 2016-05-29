package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CategoriaObras;
import entity.tipoObras;

public class CategoriaObrasDAO {
	Connection con;
	
	public CategoriaObrasDAO() throws SQLException {
		con = JDBCUtil.getConnection();
	}
	
	public List<CategoriaObras> ConsultaCategoria () throws SQLException{
		List<CategoriaObras> lista = new ArrayList<CategoriaObras>();
		String sql = "SELECT id, concat(id, ' - ', nome) as nome from obra_categoria";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			CategoriaObras co = new CategoriaObras();	
			co.setIdCategoria(rs.getInt("id"));
			co.setCategoria(rs.getString("nome"));
			lista.add(co);
			
		}
		
		
		
		return lista;
	}

}
