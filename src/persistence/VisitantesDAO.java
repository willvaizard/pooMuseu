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
	public void InsereVisitante() {
		
		
		
		
	}

	@Override
	public List<VisitanteEntity> ConsultaVisitantes() throws SQLException {
	
		List<VisitanteEntity> list = new ArrayList<VisitanteEntity>();
		
		String sql ="SELECT CPF, Nacionalidade, Idade, Sexo, GrauInstrucao, MeioTransporte, DATE_FORMAT(dataVisita, '%d/%m/%Y') as dataVisita FROM visitantes;";
		
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

	
}
