
package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.CellRendererPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.MaskFormatter;

import com.mysql.jdbc.NonRegisteringDriver;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import controller.VisitanteController;
import entity.VisitanteEntity;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import sun.swing.SwingAccessor.JLightweightFrameAccessor;

public class CadastroVisitanteBoundary extends JFrame implements ActionListener{
	
	private JPanel panelVisitantes;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnNovo;
	private JButton btnPesquisar;
	private JFormattedTextField txtCPF;
	private JTextField txtIdade;
	private JComboBox cbNacionalidade;
	private JComboBox cbGrauInstrucao;
	private JComboBox cbSexo;
	private JComboBox cbTransporte;
	private JTable tabelaVisitante;
	private VisitanteController control = new VisitanteController();
	
	 
	
	
	
	public CadastroVisitanteBoundary(){
		JPanel panelPrincipal = new JPanel(new FlowLayout());
		JFrame janela = new JFrame("Cadastro de Visitantes");
		
		//JScrollPane panTableVisitante = new JScrollPane();
		panelVisitantes = new JPanel(new BorderLayout());
		panelVisitantes.setBackground(Color.WHITE);
		
				panelVisitantes.add(botoes(), BorderLayout.PAGE_END);
		
		
		
		//panelPrincipal.add(panTableVisitante);
	
		panelVisitantes.add(principal(),BorderLayout.NORTH);
		panelVisitantes.add(Campos(),BorderLayout.CENTER);
		tabelaVisitante = new JTable(control);
		
		
		//panTableVisitante.getViewport().add(tabelaVisitante);
	
		
		janela.setContentPane(panelVisitantes);
		janela.setSize(780,680);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new CadastroVisitanteBoundary();
	}
	
	
	
	
	public JComponent Campos(){
		JPanel panelCampos = new JPanel(new GridLayout(6,1));
		
		panelCampos.add(new JLabel ("CPF"));
				txtCPF = new JFormattedTextField();
		
		try {
			MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
			maskCPF.install(txtCPF);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelCampos.add(txtCPF);
		
		
		panelCampos.add(new JLabel("Idade"));
		txtIdade = new JTextField(2);
		panelCampos.add(txtIdade);
		
		
		panelCampos.add(new JLabel("Sexo"));
		cbSexo = new JComboBox<>();
		cbSexo.addItem("");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		panelCampos.add(cbSexo);
		
		panelCampos.add(new JLabel("Nacionalidade"));
		cbNacionalidade = new JComboBox<>();
		cbNacionalidade.addItem("");
		cbNacionalidade.addItem("Brasileiro");
		cbNacionalidade.addItem("Outros");
		panelCampos.add(cbNacionalidade);
		
		panelCampos.add(new JLabel("Grau de instrução"));
		cbGrauInstrucao = new JComboBox<>();
		cbGrauInstrucao.addItem	("");
		cbGrauInstrucao.addItem	("Analfabeto");
		cbGrauInstrucao.addItem("Ensino Fundamental");
		cbGrauInstrucao.addItem("Ensino Médio");
		cbGrauInstrucao.addItem("Ensino Superior");
		cbGrauInstrucao.addItem("Pós Graduação");
		cbGrauInstrucao.addItem("Doutorado");
		cbGrauInstrucao.addItem("Mestrado");
		panelCampos.add(cbGrauInstrucao);
			
		panelCampos.add(new JLabel("Meio de Transporte"));
		cbTransporte = new JComboBox<>();
		cbTransporte.addItem("");
		cbTransporte.addItem("Coletivo Privado");
		cbTransporte.addItem("Coletivo Público");
		cbTransporte.addItem("Próprio");
		panelCampos.add(cbTransporte);
		
		
		

		
		
		return panelCampos;
		
		
		
	}
	
	
	
	public JComponent principal(){
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		JScrollPane panTableVisitante = new JScrollPane();
		
		JLabel nomeJanela = new JLabel("Cadastro de Visitante");
		nomeJanela.setFont(new Font("Tahoma",Font.BOLD,19));
		nomeJanela.setHorizontalAlignment(JLabel.CENTER);
		nomeJanela.setVerticalAlignment(JLabel.NORTH);
		panelPrincipal.add(nomeJanela, BorderLayout.NORTH);

		

		
		
		
		tabelaVisitante = new JTable(control);
		tabelaVisitante.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelaVisitante.getColumnModel().getColumn(2).setPreferredWidth(10);
		tabelaVisitante.getColumnModel().getColumn(4).setPreferredWidth(110);
		tabelaVisitante.getColumnModel().getColumn(5).setPreferredWidth(135);
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0;i<7;i++)
		tabelaVisitante.getColumnModel().getColumn(i).setCellRenderer(centro);
		
		

		
		
		panTableVisitante.getViewport().add(tabelaVisitante);
		panelPrincipal.add(panTableVisitante, BorderLayout.CENTER);
	
		
		return panelPrincipal;
	}
	
	
	
	public JComponent botoes (){
		JPanel panelBotoes = new JPanel( new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnNovo = new JButton("Novo");
		btnPesquisar = new JButton("Pesquisar");
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnNovo.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnNovo.setEnabled(false);
		btnAlterar.setEnabled(false);
		panelBotoes.add(btnNovo);
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnPesquisar);
		
		
		
		return panelBotoes;
		
		
	}







	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSalvar){
			
			if(validaCampo()){
				VisitanteEntity vst = new VisitanteEntity();
				vst.setCpf(txtCPF.getText());
				vst.setIdade(Integer.parseInt(txtIdade.getText()));
				vst.setNacionalidade(cbNacionalidade.getSelectedItem().toString());
				vst.setSexo(cbSexo.getSelectedItem().toString());
				vst.setInstrucao(cbGrauInstrucao.getSelectedItem().toString());
				vst.setTransporte(cbTransporte.getSelectedItem().toString());
					
				control.incluivisitante(vst);
				
			}
			
			
			
			
		}
		
	}







	private boolean validaCampo() {
		if(txtCPF.getText().replace(".","").replace("-", "").trim().length() <= 0){
			JOptionPane.showMessageDialog(null, "O Cpf deve ser informado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;			
		}
		else if(txtIdade.getText().trim().length()<=0){
			JOptionPane.showMessageDialog(null, "A idade deve ser informado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else if(cbSexo.getSelectedItem().toString() == ""){
			JOptionPane.showMessageDialog(null, "O Sexo deve ser informado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else if(cbNacionalidade.getSelectedItem().toString() == ""){
			JOptionPane.showMessageDialog(null, "A Nacionalidade deve ser informada", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else if (cbGrauInstrucao.getSelectedItem().toString()== ""){
			JOptionPane.showMessageDialog(null, "O grau de instrução deve ser informado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else if (cbTransporte.getSelectedItem().toString()==""){
			JOptionPane.showMessageDialog(null, "O Meio de transporte deve ser informado", "Alerta", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
		
		return true;
		}
		
		
		
	}








}
