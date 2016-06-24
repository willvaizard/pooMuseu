package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import com.toedter.calendar.JDateChooser;

import controller.ExposicaoController;
import entity.Exposicao;

public class CadastroExposicaoBoundary implements ActionListener, MouseListener, ListSelectionListener{
	private JPanel panelExposicao;
	private JDialog CadDialog = new JDialog();
	private ExposicaoController control = new ExposicaoController();
	private JTable tabelaExposicao;
	private JScrollPane panTableExposicao;
	private JDateChooser dtExposicaoChooserInicio;
	private JDateChooser dtExposicaoChooserFinal;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnSalvar;
	private JFormattedTextField txtValor;
	private JTextField txtNomeExposicao;
	private Long idExposicao;
	private String nomeExposicao;
	public CadastroExposicaoBoundary() {
	
		panelExposicao = new JPanel(new BorderLayout());
		panelExposicao.setBackground(Color.WHITE);
		
		panelExposicao.add(topo(),BorderLayout.NORTH);
		panelExposicao.add(Centro(),BorderLayout.CENTER);
		panelExposicao.add(Componentes(),BorderLayout.SOUTH);
	
		

		CadDialog.setModal(true);
		CadDialog.setLocationRelativeTo(null);
		CadDialog.setResizable(false);
		CadDialog.setContentPane(panelExposicao);
		CadDialog.setSize(720, 600);
		
		CadDialog.setLocationRelativeTo(null);
		CadDialog.setVisible(true);
	}
	
	public JComponent topo() {
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Cadastro de Exposições");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelTopo.add(titulo);
		
		return panelTopo;
	}
	
	
	public JComponent Centro() {
		JPanel JPaneCentro = new JPanel(new GridLayout(1,1));
		panTableExposicao = new JScrollPane();
		tabelaExposicao = new JTable(control);
		panTableExposicao.getViewport().add(tabelaExposicao);
		tabelaExposicao.getSelectionModel().addListSelectionListener(this);
		tabelaExposicao.addMouseListener(this);
		
		
		JPaneCentro.add(panTableExposicao);
		
		
		
		
		return JPaneCentro;
	}
	public JComponent Componentes() {
		JPanel botoes = new JPanel(new GridLayout(2,1));
		JPanel linha1 = new JPanel(new FlowLayout());
		JPanel linha2 = new JPanel(new FlowLayout());
		
		linha1.add(new JLabel("Nome Exposição"));
		txtNomeExposicao = new JTextField(20);
		linha1.add(txtNomeExposicao);
		
		linha1.add(new Label("Data Inicio"));
		dtExposicaoChooserInicio = new JDateChooser("dd/MM/yy", "##/##/####", '-');
		linha1.add(dtExposicaoChooserInicio);

		linha2.add(new Label("Data Final"));
		dtExposicaoChooserFinal = new JDateChooser("dd/MM/yy", "##/##/####", '-');
		linha2.add(dtExposicaoChooserFinal);
		
		linha2.add(new JLabel("Preço Ingresso R$"));
		txtValor = new JFormattedTextField();
		
		
		txtValor.setFormatterFactory(mascara());
		txtValor.setPreferredSize(dtExposicaoChooserInicio.getPreferredSize());
		linha2.add(txtValor);
		
		btnCancelar = new JButton("Cancelar");
		btnAlterar = new JButton("Alterar");
		btnSalvar = new JButton("Salvar");
		btnCancelar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnSalvar.addActionListener(this);
		
		linha2.add(btnCancelar);
		linha2.add(btnAlterar);
		linha2.add(btnSalvar);
		
		
		botoes.add(linha1);
		botoes.add(linha2);
		
		return botoes;
	}
	
	public void limpaCampo(){
		txtNomeExposicao.setText("");
		txtValor.setText("");
		dtExposicaoChooserInicio.setDate(null);
		dtExposicaoChooserFinal.setDate(null);
		
	}
	public boolean validaDados(){
	if(txtNomeExposicao.getText().length()<1)
	return false;
	else if(txtValor.getText().length()<1)
		return false;
	else if(dtExposicaoChooserFinal == null)
		return false;
	else if(dtExposicaoChooserInicio == null)
		return false;
	else if(dtExposicaoChooserFinal.getDate().getTime() <= dtExposicaoChooserInicio.getDate().getTime()){
		JOptionPane.showMessageDialog(null, "A data final não pode ser menor que a data inicial");
		return false;
	}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnSalvar == e.getSource()){
			if(validaDados()){
				
			control.insereNovaExposicao(getDadosDigitados());
			
			
			try {
				idExposicao=control.getUltimoID();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tabelaExposicao.invalidate();
			tabelaExposicao.revalidate();
			
			nomeExposicao = txtNomeExposicao.getText();
			
			String[] exposicao = {idExposicao.toString(),nomeExposicao };
			ExposicaoAdicionaObraBoundary expAdd = new ExposicaoAdicionaObraBoundary(exposicao);
			}else{
				JOptionPane.showMessageDialog(null, "Deve ser preenchidos todos os campos");
			}
			
		}
		
	}
	
	
	
	public DefaultFormatterFactory mascara(){
		DecimalFormat dFormat = new DecimalFormat("#####.00") ;
        NumberFormatter formatter = new NumberFormatter(dFormat) ;
        formatter.setFormat(dFormat) ;
        formatter.setAllowsInvalid(false) ; 
        return new DefaultFormatterFactory ( formatter ) ;
	}

	private Exposicao getDadosDigitados() {
		Exposicao exp = new Exposicao();
		exp.setExposicao_nome(txtNomeExposicao.getText());
		exp.setDataInicio(dtExposicaoChooserInicio.getDate());
		exp.setDataFim(dtExposicaoChooserFinal.getDate());
		exp.setValor(Double.parseDouble(txtValor.getText().replace(",",".")));
		return exp;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2){
			String[] exposicao = {idExposicao.toString(),nomeExposicao };
			ExposicaoAdicionaObraBoundary expAdd = new ExposicaoAdicionaObraBoundary(exposicao);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		int linha = tabelaExposicao.getSelectedRow();
		idExposicao = (Long) tabelaExposicao.getValueAt(linha, 0);
		nomeExposicao = (String) tabelaExposicao.getValueAt(linha, 1);
		
	}

}
