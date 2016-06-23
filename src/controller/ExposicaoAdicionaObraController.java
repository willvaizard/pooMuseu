package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Obras;

public class ExposicaoAdicionaObraController implements TableModel{
	List<Obras> lista = new ArrayList<Obras>();
	public ExposicaoAdicionaObraController() {
	
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
		case 0: obra.getIdObras();
		case 1: obra.getNomeObra();
		case 2: obra.getNomeAutor();
		case 3: obra.getLocalizacao();
							
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
