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
		switch (columnIndex) {
		case 0: return String.class;
		case 1: return String.class;
		case 2: return int.class;
		case 3: return String.class;
		case 4: return String.class;
		case 5: return String.class;
		case 6: return String.class;

		}
					

		return null;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
	}



	public void setLista(List<VisitanteEntity> lista) {
		this.lista = lista;
	}

	@Override
	public String getColumnName(int columnIndex) {
		
		String nomeColunas[] = {"CPF","Nacionalidade", "Idade", "Sexo", 
				"Grau de Instrução", "Meio de Transporte", "Data Visita"};
		
		
		
		
		
		
		
		
		return nomeColunas[columnIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		VisitanteEntity v = lista.get(rowIndex);
		switch (columnIndex) {
		case 0: return v.getCpf();
		case 1: return v.getNacionalidade();
		case 2: return v.getIdade();
		case 3: return v.getSexo();
		case 4: return v.getInstrucao();
		case 5: return v.getTransporte();
		case 6: return v.getDataVisita();
				
		}
		

		
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
			for (VisitanteEntity V : list){
						V.getCpf();
						V.getDataVisita();
				
				
				
				list.add(V);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
			
		
	}

}
