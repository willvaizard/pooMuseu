package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.EmprestimoDeObra;
//private int idEmprestimo;
//private String nomeLocal;
//private String nomeResponsavel;
//private Date dataEmprestimo;
//private Date dataDevolucao;
//private int idLocal;
//private int idObra;
public class EmprestimoDeObraController implements TableModel{
private List<EmprestimoDeObra> lista = new ArrayList<EmprestimoDeObra>();
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
		case 3: return Date.class;
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
		String [] nomeColunas =  {"ID","Localizacao","Responsavel"
				+ "","Data Emprestimo","dataDevolucao", "Obra"};
		return nomeColunas[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
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
