
package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

public class CadastroVisitanteBoundary extends JFrame{
	
	private JPanel panelVisitantes;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnRemover;
	private JButton btnPesquisar;
	private JFormattedTextField txtCPF;
	private JTextField txtIdade;
	private JCheckBox cbBrasileiro;
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
		janela.setSize(780,650);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new CadastroVisitanteBoundary();
	}
	
	
	
	
	public JComponent Campos(){
		JPanel panelCampos = new JPanel(new GridLayout(5,1));
		
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
		txtIdade = new JTextField();
		panelCampos.add(txtIdade);
		
		panelCampos.add(new JLabel("Brasileiro?"));
		cbBrasileiro = new JCheckBox("Sim");
		panelCampos.add(cbBrasileiro);
		panelCampos.add(new JLabel("Sexo"));
		
		cbSexo = new JComboBox<>();
		cbSexo.addItem("");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		panelCampos.add(cbSexo);
		
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
		JPanel panelBotoes = new JPanel( new GridLayout(1,4,5,5));
		btnSalvar = new JButton("Salvar");
		btnAlterar = new JButton("Alterar");
		btnRemover = new JButton("Remover");
		btnPesquisar = new JButton("Pesquisar");
		
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnRemover);
		panelBotoes.add(btnPesquisar);
		
		
		
		return panelBotoes;
		
		
	}
	

}
