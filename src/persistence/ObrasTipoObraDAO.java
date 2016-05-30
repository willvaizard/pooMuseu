package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.tipoObras;

public class ObrasTipoObraDAO {
	Connection con;
	
	public ObrasTipoObraDAO() throws SQLException {
		con = JDBCUtil.getConnection();
	}
	
	public List<tipoObras> ConsultaTipoObra () throws SQLException{
		List<tipoObras> lista = new ArrayList<tipoObras>();
		String sql = "SELECT id, concat(id, ' - ', nome) as nome from obra_tipo_obra ORDER BY ID";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			tipoObras to = new tipoObras();	
			to.setIdObra(rs.getInt("id"));
			to.setObra(rs.getString("nome"));
			lista.add(to);
			
		}
		ps.close();
		rs.close();
		
		
		return lista;
	}
	
	public void insere(tipoObras tpObra) throws SQLException{
		
		String sql = "INSERT INTO obra_tipo_obra  (nome) VALUES (?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tpObra.getObra());
		
		ps.execute();
		
		ps.close();
		
		
	}
	
	

}
