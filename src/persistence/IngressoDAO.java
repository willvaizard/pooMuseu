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
		String sql = "INSERT INTO `venda` (`id`,`Obra`, `ValorInt`, `Desconto`, `Total`)"
				+ "VALUES (?, ?, ?, ?, ?)";
		try{
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, venda.getId());
		ps.setString(2, venda.getObrasexp());
		ps.setString(3, venda.getValor());
		ps.setString(4, venda.getDesconto());
		ps.setString(5, venda.getTotal());
		
		ps.execute();
		ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}