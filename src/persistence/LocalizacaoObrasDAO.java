package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LocalizacaoObras;

public class LocalizacaoObrasDAO implements ILocalizacaoObrasDAO {
	public List<LocalizacaoObras> ConsultaLocalizacao() throws SQLException {
		List<LocalizacaoObras> lista = new ArrayList<LocalizacaoObras>();
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "SELECT id, nome from obra_localizacao ORDER BY id";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			LocalizacaoObras loc = new LocalizacaoObras();
			loc.setIdLocalizacao(rs.getInt("id"));
			loc.setLocalizacao(rs.getString("nome"));
			lista.add(loc);
		}
		rs.close();
		JDBCUtil.getInstancia().closeConnection();
		return lista;
	}

	public void insere(LocalizacaoObras loc) throws SQLException {
		Connection con = JDBCUtil.getInstancia().getConnection();
		String sql = "INSERT INTO obra_localizacao (nome) values (?)";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, loc.getLocalizacao());
		ps.execute();
		JDBCUtil.getInstancia().closeConnection();

	}

}
