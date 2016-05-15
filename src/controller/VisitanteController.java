package controller;
import entity.VisitanteEntity;
import persistence.VisitantesDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;



public class VisitanteController implements TableModel{
	List<VisitanteEntity> lista = new ArrayList<VisitanteEntity>();
	public VisitanteController() {
		VisitantesDAO vDao;
		try {
			vDao = new VisitantesDAO();
			 List<VisitanteEntity> list = vDao.ConsultaVisitantes();
			 
			for (VisitanteEntity V : list){
				lista.add(V);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
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
				"Grau de Instru��o", "Meio de Transporte", "Data Visita"};
		
		
		
		
		
		
		
		
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
		

		
		return v;
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
		

		
		return lista;
			
		
	}

	public void incluiVisitante (VisitanteEntity vst){
		try {
			VisitantesDAO vDao = new VisitantesDAO();
			vDao.InsereVisitante(vst);
			JOptionPane.showMessageDialog(null, "Visitante  cadastrado com sucesso","Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
	}
	
	public void atualizaVisitante (VisitanteEntity vst ){
		
		try {
			VisitantesDAO vDao = new VisitantesDAO();
			vDao.AtualizaCliente(vst);
			JOptionPane.showMessageDialog(null, "Visitante  atualizado com sucesso","Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public List<VisitanteEntity> pesquisar (String cpf){
		
		List<VisitanteEntity> resultado = new ArrayList<VisitanteEntity>();
		
		for(VisitanteEntity vst: lista){
			if(vst.getCpf().contains(cpf)){
				resultado.add(vst);
			}
			
		}
		
		return resultado;
	}

}
