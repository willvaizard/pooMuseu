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

public class ObrasDAO implements iObrasDAO{
	@Override
	public List<Obras> getLista() throws SQLException{
		List<Obras> lista = new ArrayList<Obras>();
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "Select obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia,"
				 +"tip.nome as tipoObra, cat.nome as categoria, loc.nome as localizacao, obra_disponibilidade from obra "
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
			ob.setDataObra(rs.getDate("obra_data"));
			ob.setTipoObra(rs.getString("tipoObra"));
			ob.setCategoria(rs.getString("categoria"));
			ob.setLocalizacao(rs.getString("localizacao"));
			ob.setDisponiblidade(rs.getString("obra_disponibilidade"));
			lista.add(ob);
		}
		rs.close();
		JDBCUtil.getInstancia().closeConnection();
		return lista;
		
				
	}
	@Override
	public List<Obras> ConsultaByObras (String nomeObra) throws SQLException{
		List<Obras> lista = new ArrayList<Obras>();
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "SELECT obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia, "
				+ "tip.nome as tipoObra, cat.nome as categoria, loc.nome as localizacao, obra_disponibilidade from obra  "
				+ "inner join obra_tipo_obra tip  ON tip.id=obra.obra_id_tipo  "
				+ "inner join obra_categoria cat  ON cat.id=obra.obra_id_categoria "
				+ "inner join obra_localizacao loc  on loc.id=obra.obra_id_localizacao  "
				+ "where obra_nome like ?";
	
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,"%"+nomeObra+"%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Obras obras = new Obras();			
			obras.setIdObras(rs.getInt("obra_id"));
			obras.setDataCadastro(rs.getString("obra_sysdata"));
			obras.setNomeObra(rs.getString("obra_nome"));
			obras.setNomeAutor(rs.getString("obra_autor"));
			
			obras.setDataObra(rs.getDate("obra_data"));
			obras.setTipoObra(rs.getString("tipoObra"));
			obras.setCategoria(rs.getString("categoria"));
			obras.setLocalizacao(rs.getString("localizacao"));
			obras.setDisponiblidade(rs.getString("obra_disponibilidade"));
			lista.add(obras);
			
		}
		rs.close();
		
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}

	@Override
	public void Inserir(Obras ob) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String SQL = "INSERT INTO obra (obra_nome, obra_autor, obra_data, obra_biografia,"
				+ "obra_id_tipo, obra_id_categoria,obra_id_localizacao,obra_disponibilidade) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setString(1, ob.getNomeObra());
		ps.setString(2, ob.getNomeAutor());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date d = new java.sql.Date( ob.getDataObra().getTime());
		ps.setDate(3,   d);
		ps.setString(4,ob.getBiografia());
		ps.setInt(5, ob.getIdTipoObra());
		ps.setInt(6, ob.getIdCategoria());
		ps.setInt(7, ob.getIdLocalizacao());
		ps.setString(8, ob.getDisponiblidade());
		ps.executeUpdate();

		JDBCUtil.getInstancia().closeConnection();
	}

	@Override
	public Obras ConsultaObraById(int id) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql =  "SELECT obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia, "
				+ "obra_id_tipo, obra_id_categoria, obra_id_localizacao,"
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
			ob.setIdObras(rs.getInt("obra_id"));
			ob.setNomeAutor(rs.getString("categoria"));
			ob.setNomeObra(rs.getString("obra_nome"));
			ob.setNomeAutor(rs.getString("obra_autor"));
			ob.setDataObra(rs.getDate("obra_data"));
			ob.setBiografia(rs.getString("obra_biografia"));
			ob.setIdTipoObra(rs.getInt("obra_id_tipo"));
			ob.setTipoObra(rs.getString("tipoObra"));
			ob.setIdCategoria(rs.getInt("obra_id_categoria"));
			ob.setCategoria(rs.getString("categoria"));
			ob.setIdLocalizacao(rs.getInt("obra_id_localizacao"));
			ob.setLocalizacao(rs.getString("localizacao"));
			ob.setDisponiblidade(rs.getString("obra_disponibilidade"));
		}
		rs.close();
		JDBCUtil.getInstancia().closeConnection();
		return ob;
	}
	
	@Override
	public List<Obras> ConsultaObrasDaExposicao(long idExposicao) throws SQLException {
		List<Obras> list = new ArrayList<Obras>();
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql =  "SELECT ob.obra_id, ob.obra_nome, ob.obra_autor, loc.nome as localizacao from exposicao_obra "+
				" inner join obra ob"+ 
                " on ob.obra_id = exposicao_obra.obra_id"+
				" inner join obra_localizacao loc"+  
                " on loc.id=ob.obra_id_localizacao"+ 
				" where exposicao_id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setLong(1, idExposicao);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Obras ob = new Obras();
			ob.setIdObras(rs.getInt("obra_id"));
			ob.setNomeObra(rs.getString("obra_nome"));
			ob.setNomeAutor(rs.getString("obra_autor"));
			ob.setLocalizacao(rs.getString("localizacao"));
			list.add(ob);
		}
		rs.close();
		JDBCUtil.getInstancia().closeConnection();
		return list;
	}

	
	@Override
	public void update (Obras ob) throws SQLException{
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "UPDATE obra SET  obra_nome = ? , obra_autor  = ? , obra_data  = ? , obra_biografia  = ? ,"
				+ "obra_id_tipo  = ? , obra_id_categoria = ? ,obra_id_localizacao = ? ,obra_disponibilidade = ? where obra_id = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, ob.getNomeObra());
		ps.setString(2, ob.getNomeAutor());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		java.sql.Date d = new java.sql.Date( ob.getDataObra().getTime());
		ps.setDate(3,   d);
		ps.setString(4,ob.getBiografia());
		ps.setInt(5, ob.getIdTipoObra());		
		ps.setInt(6, ob.getIdCategoria());
		ps.setInt(7, ob.getIdLocalizacao());
		ps.setString(8, ob.getDisponiblidade());
		ps.setInt(9,ob.getIdObras());
		ps.executeUpdate();		
		JDBCUtil.getInstancia().closeConnection();			
	}
	
	@Override
	public void delete(int idObra) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "DELETE FROM obra where obra_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,idObra);
		ps.execute();
		JDBCUtil.getInstancia().closeConnection();
	}
	
	@Override
	public List<Obras> ConsultaByAutor(String nomeAutor) throws SQLException {
		List<Obras> lista = new ArrayList<Obras>();
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "SELECT obra_id,obra_sysdata, obra_nome, obra_autor, obra_data,	obra_biografia, "
				+ "tip.nome as tipoObra, cat.nome as categoria, loc.nome as localizacao, obra_disponibilidade from obra  "
				+ "inner join obra_tipo_obra tip  ON tip.id=obra.obra_id_tipo  "
				+ "inner join obra_categoria cat  ON cat.id=obra.obra_id_categoria "
				+ "inner join obra_localizacao loc  on loc.id=obra.obra_id_localizacao  "
				+ "where obra_autor like ?";
	
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,"%"+nomeAutor+"%");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Obras obras = new Obras();			
			obras.setIdObras(rs.getInt("obra_id"));
			obras.setDataCadastro(rs.getString("obra_sysdata"));
			obras.setNomeObra(rs.getString("obra_nome"));
			obras.setNomeAutor(rs.getString("obra_autor"));			
			obras.setDataObra(rs.getDate("obra_data"));
			obras.setTipoObra(rs.getString("tipoObra"));
			obras.setCategoria(rs.getString("categoria"));
			obras.setLocalizacao(rs.getString("localizacao"));
			obras.setDisponiblidade(rs.getString("obra_disponibilidade"));
			lista.add(obras);			
		}
		rs.close();
		JDBCUtil.getInstancia().closeConnection();
		
		return lista;
	}
	
	
}
