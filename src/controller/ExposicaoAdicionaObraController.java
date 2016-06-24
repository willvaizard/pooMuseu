package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Obras;
import persistence.ObrasDAO;

public class ExposicaoAdicionaObraController implements TableModel{
	private List<Obras> lista = new ArrayList<Obras>();
	private long idExposicao;
	public ExposicaoAdicionaObraController(long idExposicao) {
	this.idExposicao=idExposicao;
	getListaObraExposicao();
	}
	private void getListaObraExposicao() {
		
		ObrasDAO oDao = new ObrasDAO();
		try {
			List<Obras> obras = oDao.ConsultaObrasDaExposicao(idExposicao);
			preencheTable (obras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
	
	
	private void preencheTable(List<Obras> listObExp) {
			lista.clear();
				for(Obras ob: listObExp){
					
					lista.add(ob);
				}
		
	}
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: return long.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return String.class;
					

		}
		return null;
	}

	@Override
	public int getColumnCount() {

		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String [] nomeColunas= {"idObra","Nome Obra", "Autor Obra", "Localizacao"};
		return nomeColunas[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Obras obra = lista.get(rowIndex);
		switch (columnIndex) {
		case 0: return obra.getIdObras();
		case 1: return obra.getNomeObra();
		case 2: return obra.getNomeAutor();
		case 3: return obra.getLocalizacao();
							
		}
				
		return obra;
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
