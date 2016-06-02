package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entity.Obras;

public class ObrasDAO implements iObrasDAO{
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
	
	public List<Obras> ConsultaByObras (String nomeObra) throws SQLException{
		
		List<Obras> lista = new ArrayList<Obras>();
		String sql = "SELECT obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia, "
				+ "tip.nome as tipoObra, cat.nome as categoria, loc.nome as localizacao from obra  "
				+ "inner join obra_tipo_obra tip  ON tip.id=obra.obra_id_tipo  "
				+ "inner join obra_categoria cat  ON cat.id=obra.obra_id_categoria "
				+ "inner join obra_localizacao loc  on loc.id=obra.obra_id_localizacao  "
				+ "where obra_nome like ?";
	
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setString(1,nomeObra);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Obras obras = new Obras();			
			obras.setIdObras(rs.getInt("obra_id"));
			obras.setDataCadastro(rs.getString("obra_sysdata"));
			obras.setNomeObra(rs.getString("obra_nome"));
			obras.setNomeAutor(rs.getString("obra_autor"));
			obras.setDataObra(rs.getString("obra_data"));
			obras.setTipoObra(rs.getString("tipoObra"));
			obras.setCategoria(rs.getString("categoria"));
			obras.setLocalizacao(rs.getString("localizacao"));
			obras.setDisponiblidade(rs.getString("disponibilidade"));
			lista.add(obras);
			
		}
		ps.close();
		rs.close();
		
		
		return lista;
		
		
		
	}

	@Override
	public void Inserir(Obras ob) throws SQLException {
		ob.toString();
		String SQL = "INSERT INTO obra (obra_nome, obra_autor, obra_data, obra_biografia,"
				+ "obra_id_tipo, obra_id_categoria,obra_id_localizacao,obra_disponibilidade) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setString(1, ob.getNomeObra());
		ps.setString(2, ob.getNomeAutor());
		ps.setString(3, ob.getDataObra());
		ps.setString(4,ob.getBiografia());
		ps.setInt(5, ob.getIdTipoObra());
		ps.setInt(6, ob.getIdCategoria());
		ps.setInt(7, ob.getIdLocalizacao());
		ps.setString(8, ob.getDisponiblidade());
		ps.executeUpdate();
		
		ps.close();	
	}

	@Override
	public Obras getObraPorId(int id) throws SQLException {
		
		String sql =  "SELECT obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia, "
				+ "tip.nome as tipoObra, cat.nome as categoria, loc.nome as localizacao, obra_disponibilidade from obra  "
				+ "inner join obra_tipo_obra tip  ON tip.id=obra.obra_id_tipo  "
				+ "inner join obra_categoria cat  ON cat.id=obra.obra_id_categoria "
				+ "inner join obra_localizacao loc  on loc.id=obra.obra_id_localizacao  "
				+ "where obra_id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Obras ob = new Obras();
		if(rs.next()){
			
			ob.setIdCategoria(rs.getInt("obra_id"));
			ob.setNomeObra(rs.getString("obra_nome"));
			ob.setNomeAutor(rs.getString("obra_autor"));
			ob.setDataObra(rs.getString("obra_data"));
			ob.setBiografia(rs.getString("obra_biografia"));
			ob.setTipoObra(rs.getString("tipoObra"));
			ob.setCategoria(rs.getString("categoria"));
			ob.setLocalizacao(rs.getString("localizacao"));
			ob.setDisponiblidade(rs.getString("obra_disponibilidade"));
		}
		ps.close();
		rs.close();

		return ob;
	}
	
	
	
	
	
	

}
