package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LocalEntity;

public class LocalDAO {
	Connection con;
	
	public LocalDAO() throws SQLException {
		con = JDBCUtil.getConnection();
	}
	
	public void InsereLocal (LocalEntity local) throws SQLException{
		String sql = "INSERT INTO `local` (`Codigo`,`Nome`, `Email`, `Telefone`, "
				+ "`Responsavel`, `CEP`, `Logradouro`, `Numero`, `Complemento`, "
				+ "`Bairro`, `Cidade`, `UF`)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, local.getCodigo());
		ps.setString(2, local.getNome());
		ps.setString(3, local.getEmail());
		ps.setInt(4, local.getTelefone());
		ps.setString(5, local.getResponsavel());
		ps.setInt(6, local.getCep());
		ps.setString(7, local.getLogradouro());
		ps.setInt(8, local.getNumero());
		ps.setString(9, local.getComplemento());
		ps.setString(10, local.getBairro());
		ps.setString(11, local.getCidade());
		ps.setString(12, local.getUf());
		ps.execute();
		ps.close();
	}

	public List<LocalEntity> ConsultaLocal() throws SQLException {
		
		List<LocalEntity> list = new ArrayList<LocalEntity>();
		
		String sql ="SELECT Codigo, Nome, Email, Telefone, "
				+ "Responsavel, CEP, Logradouro, Numero, Complemento, "
				+ "Bairro, Cidade, UF FROM as dataVisita FROM local";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			LocalEntity local = new LocalEntity();
			
			local.setCodigo(rs.getInt("Codigo"));
			local.setNome(rs.getString("Nome"));
			local.setEmail(rs.getString("Email"));
			local.setTelefone(rs.getInt("Telefone"));
			local.setResponsavel(rs.getString("Responsavel"));
			local.setCep(rs.getInt("CEP"));
			local.setLogradouro(rs.getString("Logradouro"));
			local.setNumero(rs.getInt("Numero"));
			local.setComplemento(rs.getString("Complemento"));
			local.setBairro(rs.getString("Bairro"));
			local.setCidade(rs.getString("Cidade"));
			local.setUf(rs.getString("UF"));
			list.add(local);
		}
		ps.execute();
		ps.close();
		return list;
	}
	
	public void AtualizaLocal (LocalEntity local)  throws SQLException{
		
		String sql = "UPDATE local set Nome = ?, Email = ?, Telefone = ?, "
				+ "Responsavel = ?, CEP = ?, Logradouro = ?, Numero = ?,"
				+ "Complemento = ?, Bairro = ?, Cidade = ?, UF = ? where Codigo = ?";
		PreparedStatement ps = con.prepareStatement(sql);
			
		ps.setString(1, local.getNome());
		ps.setString(2, local.getEmail());
		ps.setInt(3, local.getTelefone());
		ps.setString(4, local.getResponsavel());
		ps.setInt(5, local.getCep());
		ps.setString(6, local.getLogradouro());
		ps.setInt(7, local.getNumero());
		ps.setString(8, local.getComplemento());
		ps.setString(9, local.getBairro());
		ps.setString(10, local.getCidade());
		ps.setString(11, local.getUf());
		ps.setInt(12, local.getCodigo());
		ps.execute();
		ps.close();
		
	}
	
	public int proximoCodigo() throws SQLException{
		String sql = "SELECT MAX(codigo) + 1 AS proximo_codigo FROM local";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			return rs.getInt("proximo_codigo");
		} else {
			return 1;
		}
	}

}