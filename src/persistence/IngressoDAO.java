package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Ingresso;

public class IngressoDAO implements IIngressoDAO {

Connection con;
	
	public IngressoDAO() {
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void InsereVenda(Ingresso venda) {
		String sql = "INSERT INTO `venda` (Exposicao , IdadeMenor5 , IdadeMaior60, Estudante, Professor, Outros, ValorInt, Desconto, Total)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try{
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setString(1, venda.getObrasexp());
		ps.setBoolean(2,venda.isIdade5());
		ps.setBoolean(3, venda.isIdade60());
		ps.setBoolean(4,venda.isEstudante());
		ps.setBoolean(5, venda.isProfessor());
		ps.setBoolean(6, venda.isOutros());
		ps.setDouble(7, venda.getValor());
		ps.setDouble(8, venda.getDesconto());
		ps.setDouble(9, venda.getTotal());
		
		ps.execute();
		ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public List<Ingresso> ListaIngressoVendidos () throws SQLException{
		List<Ingresso> listaVendidos = new ArrayList<Ingresso>();
		String sql = "SELECT * FROM venda";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Ingresso vendas = new Ingresso();
			vendas.setId(rs.getInt("id"));
			vendas.setObrasexp(rs.getString("Exposicao"));
			vendas.setValor(rs.getDouble("ValorInt"));
			vendas.setDesconto(rs.getDouble("Desconto"));
			vendas.setTotal(rs.getDouble("Total"));
			listaVendidos.add(vendas);
		}
		
		return listaVendidos;
		
	}
	
	
	
}