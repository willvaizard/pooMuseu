package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Obras;
import entity.obraExposicao;
import persistence.ExposicaoDAO;
import persistence.iExposicaoDAO;

public class ExposicaoController implements TableModel{
	private List<obraExposicao> lista = new ArrayList<obraExposicao>();
	
	
	public List<obraExposicao> getLista() {
		return lista;
	}

	public void setLista(List<obraExposicao> lista) {
		this.lista = lista;
	}

	public ExposicaoController() {

		getExposicao();
	}
	public void insereNovaObraEmExposicao(Obras ob){
		try {
			ExposicaoDAO eDao = new ExposicaoDAO();
			eDao.incluiObraExposicao(ob);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insereNovaExposicao(obraExposicao exp){
		try {
			iExposicaoDAO eDao = new ExposicaoDAO();
			eDao.insert(exp);
			JOptionPane.showMessageDialog(null, "Nova exposição Cadastrada com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void getExposicao() {
		try {
			ExposicaoDAO eDao = new ExposicaoDAO();
			preencheTable(eDao.getTodasExposicoes());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void preencheTable(List<obraExposicao> expo) {
		lista.clear();
		for (obraExposicao ex : expo) {
			lista.add(ex);
		}
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: return int.class;
		case 1: return String.class;
		case 2: return Date.class;
		case 3: return Date.class;
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
		String nomeColuna[] = {"id","Exposição", "Data Inicio", "Data Fim", "Valor Ingresso"};
		return nomeColuna[columnIndex];
	}

	@Override
	public int getRowCount() {

		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		obraExposicao ex = lista.get(rowIndex);
		switch (columnIndex) {
		case 0: return ex.getExposicao_id();
		case 1: return ex.getExposicao_nome();
		case 2: return ex.getDataInicio();
		case 3: return ex.getDataFim();
		case 4: return ex.getValor();
			

		}
		return ex;
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
