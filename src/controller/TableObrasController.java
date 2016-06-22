package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Obras;
import persistence.ObrasDAO;

public class TableObrasController implements TableModel{
	private List<Obras> lista = new ArrayList<Obras>();
	
	public List<Obras> getLista() {
		return lista;
	}

	public void setLista(List<Obras> lista) {
		this.lista = lista;
	}

	public TableObrasController() {
	getObras();
	}
	
	public void ConsultaPorObra(String nomeObra){
		
		ObrasDAO oDao = new ObrasDAO();
		try {
			List<Obras> obras= oDao.ConsultaByObras(nomeObra);
			preencheTable(obras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ConsultaPorNomeAutor(String nomeAutor){
		
		ObrasDAO oDao = new ObrasDAO();
		try {
			List<Obras> obras= oDao.ConsultaByAutor(nomeAutor);
			preencheTable(obras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void preencheTable (List<Obras> obras){
		lista.clear();
		
		for(Obras ob : obras){
			
			lista.add(ob);
		}
		
	}

	private void getObras() {
		
		
		ObrasDAO oDao = new ObrasDAO();
		try {
			List<Obras> obras= oDao.getLista();
			preencheTable(obras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: return int.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return String.class;
		case 4: return Date.class;
		case 5: return String.class;
			
		}

		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String nomeColuna[] = {"id","Data Cadastro", "Nome", "Autor", "Data Obra", "Disponibilidade"};
		return nomeColuna[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	Obras ob = lista.get(rowIndex);
	switch (columnIndex) {
	case 0: return ob.getIdObras();
	case 1: return ob.getDataCadastro();
	case 2: return ob.getNomeObra();
	case 3: return ob.getNomeAutor();
	case 4: return ob.getDataObra();
	case 5: return ob.getDisponiblidade();
		
	}
	
		return ob;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

}
