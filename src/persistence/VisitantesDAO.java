package persistence;

import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.sql.*;

import entity.VisitanteEntity;

public class VisitantesDAO implements iGenericDao{
	Connection  con;
	public VisitantesDAO()throws SQLException {
	con =  JDBCUtil.getConnection();
	}
	
	@Override
	public void InsereVisitante(VisitanteEntity vst) throws SQLException {
		String sql = "INSERT INTO `visitantes` (`CPF`,`Nacionalidade`, `Idade`, `Sexo`, `GrauInstrucao`, `MeioTransporte`)"
				+ "VALUES (? , ? , ? , ? , ? , ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, vst.getCpf());
		ps.setString(2, vst.getNacionalidade());
		ps.setInt(3, vst.getIdade());
		ps.setString(4, vst.getSexo());
		ps.setString(5, vst.getInstrucao());
		ps.setString(6, vst.getTransporte());
		ps.execute();
		ps.close();
		
	}


	@Override
	public List<VisitanteEntity> ConsultaVisitantes() throws SQLException {
	
		List<VisitanteEntity> list = new ArrayList<VisitanteEntity>();
		
		String sql ="SELECT CPF, Nacionalidade, Idade, Sexo, GrauInstrucao, MeioTransporte,"
				+ " DATE_FORMAT(dataVisita, '%d/%m/%Y') as dataVisita FROM visitantes";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			VisitanteEntity visitante = new VisitanteEntity();
			visitante.setCpf(rs.getString("CPF"));
			visitante.setIdade(rs.getInt("Idade"));
			visitante.setInstrucao(rs.getString("GrauInstrucao"));
			visitante.setNacionalidade(rs.getString("Nacionalidade"));
			visitante.setSexo(rs.getString("Sexo"));
			visitante.setTransporte(rs.getString("MeioTransporte"));
			visitante.setDataVisita(rs.getString("dataVisita"));
			
			
			
			list.add(visitante);
		}
		
		
		return list;
	}

public void AtualizaCliente (VisitanteEntity vst)  throws SQLException{
	
	String sql = "UPDATE visitantes set Nacionalidade = ?, Idade = ?, Sexo = ?, GrauInstrucao = ?, MeioTransporte = ? where CPF = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, vst.getNacionalidade());
	ps.setInt(2, vst.getIdade());
	ps.setString(3, vst.getSexo());
	ps.setString(4, vst.getInstrucao());
	ps.setString(5, vst.getTransporte());
	ps.setString(6, vst.getCpf());
	ps.execute();
	ps.close();
	
	
	
	
	
	
	
}


	

	

	
}
