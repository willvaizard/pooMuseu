package controller;
import entity.VisitanteEntity;
import persistence.VisitantesDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



public class VisitanteController implements TableModel{
	List<VisitanteEntity> lista = new ArrayList<VisitanteEntity>();
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}



	public void setLista(List<VisitanteEntity> lista) {
		this.lista = lista;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		String nomeColunas[] = {"CPF", "Idade", "Sexo", "Grau de Instrução", "Meio de Transpornte", "Data Visita"}; 
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
	
	public List<VisitanteEntity> getLista(){
		List<VisitanteEntity> list = null;
		VisitantesDAO vDao;
		try {
			vDao = new VisitantesDAO();
			 list = vDao.ConsultaVisitantes();
			for (VisitanteEntity c : list){
							
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
			
		
	}

}
