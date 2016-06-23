package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Ingresso;
import persistence.IngressoDAO;

public class TableIngressosVendidosController implements TableModel{
	private List<Ingresso> lista = new ArrayList<Ingresso>();
	
	public TableIngressosVendidosController() {
		getIngressos ();
	
	}
	
	
	private void getIngressos() {
		IngressoDAO ing = new IngressoDAO();
		try {
			List<Ingresso> listaVendidos = ing.ListaIngressoVendidos();
			PreencheTable(listaVendidos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void PreencheTable(List<Ingresso> listaVendidos) {
		lista.clear();
		for(Ingresso ing: listaVendidos){
			lista.add(ing);
		}
		
	}


	public List<Ingresso> getLista() {
		return lista;
	}


	public void setLista(List<Ingresso> lista) {
		this.lista = lista;
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
		case 2: return Double.class;
		case 3: return Double.class;
		case 4: return Double.class;
					}

		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		String [] nomeColunas = {"ID", "Nome Exposição","Valor Ingresso","Valor Desconto", "Valor Pago"};
		return  nomeColunas[columnIndex];
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ingresso ing = lista.get(rowIndex);
		switch (columnIndex) {
		case 0: return ing.getId();
		case 1: return ing.getObrasexp();
		case 2: return ing.getValor();
		case 3: return ing.getDesconto();
		case 4: return ing.getTotal();

		}
		return ing;
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
