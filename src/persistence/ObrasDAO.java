package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Obras;

public class ObrasDAO {
	Connection con;
	public ObrasDAO() {
	
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public List<Obras> getLista() throws SQLException{
		List<Obras> lista = new ArrayList<Obras>();
		String sql = "Select obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia,"
				 +"tip.nome as tipoObra, cat.nome as categoria, loc.nome as localizacao from obra "
				 +"inner join obra_tipo_obra tip "
				 +"ON tip.id=obra.obra_id_tipo "
				 +"inner join obra_categoria cat "
				 +"ON cat.id=obra.obra_id_categoria "
				 +"inner join obra_localizacao loc "
				 +"on loc.id=obra.obra_id_localizacao";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Obras ob = new Obras();
			ob.setIdObras(rs.getInt("obra_id"));
			ob.setDataCadastro(rs.getString("obra_sysdata"));
			ob.setNomeObra(rs.getString("obra_nome"));
			ob.setNomeAutor(rs.getString("obra_autor"));
			ob.setDataObra(rs.getString("obra_data"));
			ob.setTipoObra(rs.getString("tipoObra"));
			ob.setCategoria(rs.getString("categoria"));
			ob.setLocalizacao(rs.getString("localizacao"));
			ob.setDisponiblidade("Disponivel");
			lista.add(ob);
		}
		ps.close();
		rs.close();
		
		
		return lista;
		
				
	}
	
	

}
