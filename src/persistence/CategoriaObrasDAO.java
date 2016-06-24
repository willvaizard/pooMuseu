package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.CategoriaObras;
import entity.tipoObras;

public class CategoriaObrasDAO implements ICategoriaObrasDAO {
	public List<CategoriaObras> ConsultaCategoria () throws SQLException{
		List<CategoriaObras> lista = new ArrayList<CategoriaObras>();
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "SELECT id, nome from obra_categoria ORDER BY id";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			CategoriaObras co = new CategoriaObras();	
			co.setIdCategoria(rs.getInt("id"));
			co.setCategoria(rs.getString("nome"));
			lista.add(co);			
		}
		rs.close();		
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}
	
	public void insere(CategoriaObras cat) throws SQLException{
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "INSERT INTO obra_categoria (nome) values (?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cat.getCategoria());
		ps.execute();
		JDBCUtil.getInstancia().closeConnection();	
	}

}
