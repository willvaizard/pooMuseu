package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.IngressoEntity;

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
	public void InsereVenda(IngressoEntity venda) {
		String sql = "INSERT INTO `venda` (id ,Exposicao , IdadeMenor5 , IdadeMaior60, Estudante, Professor, Outros, ValorInt, Desconto, Total)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try{
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, venda.getId());
		ps.setString(2, venda.getObrasexp());
		ps.setBoolean(3,venda.isIdade5());
		ps.setBoolean(4, venda.isIdade60());
		ps.setBoolean(5,venda.isEstudante());
		ps.setBoolean(6, venda.isProfessor());
		ps.setBoolean(7, venda.isOutros());
		ps.setDouble(8, venda.getValor());
		ps.setDouble(9, venda.getDesconto());
		ps.setDouble(10, venda.getTotal());
		
		ps.execute();
		ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}