package persistence;

import java.sql.SQLException;
import java.util.List;

import entity.CategoriaObras;

public interface ICategoriaObrasDAO {
		public List<CategoriaObras> ConsultaCategoria() throws SQLException;
		public void insere(CategoriaObras cat) throws SQLException;
}
