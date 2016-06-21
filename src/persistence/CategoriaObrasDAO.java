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
		String sql = "SELECT id, nome from obra_categoria ORDER BY id";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			CategoriaObras co = new CategoriaObras();	
			co.setIdCategoria(rs.getInt("id"));
			co.setCategoria(rs.getString("nome"));
			lista.add(co);
			
		}
		ps.close();
		rs.close();
		
		
		return lista;
	}
	
	public void insere(CategoriaObras cat) throws SQLException{
		
		String sql = "INSERT INTO obra_categoria (nome) values (?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cat.getCategoria());
		ps.execute();
		ps.close();
		
		
	}

}
