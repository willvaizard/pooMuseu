package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controller.CategoriaObrasController;
import controller.LocalizacaoObrasController;
import controller.ObrasController;
import controller.tipoObrasController;
import entity.CategoriaObras;
import entity.LocalizacaoObras;
import entity.Obras;
import entity.tipoObras;


public class ObrasBondary implements ActionListener{
	private JPanel 	 panelObras = new JPanel(new BorderLayout());
	private JButton btnPesquisarObra;
	private JTextField txtNomeObra;
	private JTextField txtNomeAutor;
	private JTextArea txtBiografia;
	private JDateChooser dtObraChooser;
	private JComboBox<Object> cbTipoObra;
	private JComboBox<Object> cbCategoria;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JDialog ObraDialog = new JDialog();
	private JComboBox<Object> cbLocalizacao;
	private JTextField txtNovoTipoObra;
	private JTextField txtNovaCategoria;
	private JTextField txtNovaLocalizacao;
	private JButton btnIncluirTipoObra;
	private JButton btnIncluirCategoria;
	private JButton btnIncluirLocalizacao;
	private JLabel lblNovaCategoria;
	private JLabel lblTpObra;
	private JLabel lblNovaLocalizacao;
	private JButton btnNovoTipoObra;
	private JButton btnNovaCategoria;
	private JButton btnNovaLocalizacao;
	private List<tipoObras> listaObras;
	private List<CategoriaObras> listaCat;
	private List<LocalizacaoObras> listaLocalizacao;
	private JLabel lblLocalizacao;
	private TableObrasBoundary obras;
	private JCheckBox chkDisponibilidade;
	private int idObra;
	
	public ObrasBondary() {

	
	
	panelObras.add(topo(),BorderLayout.NORTH);
	panelObras.add(principal(), BorderLayout.CENTER);
	panelObras.add(botoes(), BorderLayout.SOUTH);

	ObraDialog.setModal(true);
	ObraDialog.setLocationRelativeTo(null);
	ObraDialog.setResizable(false);
	ObraDialog.setContentPane(panelObras);
	ObraDialog.setSize(720, 492);
	ObraDialog.setLocationRelativeTo(null);
	ObraDialog.setVisible(true);

		 
		 
		 
	
	}


	public JComponent topo(){
		JPanel panelTopo = new JPanel();
		JLabel titulo = new JLabel("Cadastro de Obras");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelTopo.add(titulo);
		
		
		
		return panelTopo;
		
	}
	
	
	public JComponent principal (){
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		JLabel lblNomeObra = new JLabel("Nome da Obra:");
		lblNomeObra.setBounds(20, 25, 110, 14);
		panelPrincipal.add(lblNomeObra);
		txtNomeObra = new JTextField(50);
		txtNomeObra.setBounds(125, 22, 500, 20);
		panelPrincipal.add(txtNomeObra);
		btnPesquisarObra = new JButton("");
		btnPesquisarObra.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/lupa.png")));
		btnPesquisarObra.setBounds(635, 11, 40, 40);
		panelPrincipal.add(btnPesquisarObra);
		btnPesquisarObra.addActionListener(this);
		
		JLabel lblNomeAutor = new JLabel("Nome Autor:");
		lblNomeAutor.setBounds(20, 80, 110, 14);
		panelPrincipal.add(lblNomeAutor);
		txtNomeAutor = new JTextField(60);
		txtNomeAutor.setBounds(125, 77, 550, 20);
		panelPrincipal.add(txtNomeAutor);
		
		
		JLabel lblBiografia = new JLabel("Biografia:");
		lblBiografia.setBounds(20, 123, 95, 14);
		panelPrincipal.add(lblBiografia);
		txtBiografia = new JTextArea(5,60);
		txtBiografia.setLineWrap(true);
			
		txtBiografia.setBounds(125, 118, 558, 64);
		panelPrincipal.add(txtBiografia);
		dtObraChooser = new JDateChooser("dd/MM/yyyy", "##/##/#####", '-');
		dtObraChooser.setBounds(104, 343, 124, 20);
		panelPrincipal.add(dtObraChooser);
		
		chkDisponibilidade = new JCheckBox("Disponivel para empréstimo");
		chkDisponibilidade.setBounds(261, 343, 327, 23);
		panelPrincipal.add(chkDisponibilidade);
		JLabel lblTipoObra = new JLabel("Tipo de Obra:");
		lblTipoObra.setBounds(20, 202, 76, 14);
		panelPrincipal.add(lblTipoObra);
		cbTipoObra = new JComboBox<Object>();
		cbTipoObra.setBounds(104, 199, 136, 20);
		panelPrincipal.add(cbTipoObra);
		
		
		
		
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(20, 246, 76, 14);
		panelPrincipal.add(lblCategoria);
		cbCategoria = new JComboBox<Object>();
		cbCategoria.setBounds(104, 243, 136, 20);
		panelPrincipal.add(cbCategoria);
		
		lblLocalizacao = new JLabel("Localização:");
		lblLocalizacao.setBounds(20, 290, 92, 14);
		panelPrincipal.add(lblLocalizacao);
		
		cbLocalizacao = new JComboBox<Object>();
		cbLocalizacao.setBounds(104, 287, 136, 20);
		panelPrincipal.add(cbLocalizacao);
		
		JLabel lblDtObra = new JLabel("Data da Obra:");
		lblDtObra.setBounds(18, 347, 110, 14);
		panelPrincipal.add(lblDtObra);
		
		btnNovaCategoria = new JButton("");
		btnNovaCategoria.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/add.png")));
		btnNovaCategoria.setBounds(261, 237, 59, 33);
		panelPrincipal.add(btnNovaCategoria);
		btnNovaCategoria.addActionListener(this);
		
		btnNovoTipoObra = new JButton("");
		btnNovoTipoObra.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/add.png")));
		btnNovoTipoObra.setBounds(261, 193, 59, 33);
		panelPrincipal.add(btnNovoTipoObra);
		
		
		btnNovaLocalizacao = new JButton("");
		btnNovaLocalizacao.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/add.png")));
		btnNovaLocalizacao.setBounds(261, 281, 59, 33);
		panelPrincipal.add(btnNovaLocalizacao);
		btnNovaCategoria.addActionListener(this);
		btnNovaLocalizacao.addActionListener(this);
		btnNovoTipoObra.addActionListener(this);
		
		lblTpObra = new JLabel("Obra:");
		lblTpObra.setBounds(335, 202, 69, 14);
		panelPrincipal.add(lblTpObra);
		
		lblNovaCategoria = new JLabel("Categoria:");
		lblNovaCategoria.setBounds(335, 246, 95, 14);
		panelPrincipal.add(lblNovaCategoria);
		
		lblNovaLocalizacao = new JLabel("Localização:");
		lblNovaLocalizacao.setBounds(336, 290, 116, 14);
		panelPrincipal.add(lblNovaLocalizacao);
		
		txtNovoTipoObra = new JTextField();
		txtNovoTipoObra.setBounds(414, 199, 188, 20);
		panelPrincipal.add(txtNovoTipoObra);
		txtNovoTipoObra.setColumns(10);
		
		txtNovaCategoria = new JTextField();
		txtNovaCategoria.setBounds(414, 243, 188, 20);
		panelPrincipal.add(txtNovaCategoria);
		txtNovaCategoria.setColumns(10);
		
		txtNovaLocalizacao = new JTextField();
		txtNovaLocalizacao.setBounds(414, 287, 189, 20);
		panelPrincipal.add(txtNovaLocalizacao);
		txtNovaLocalizacao.setColumns(10);
		
		btnIncluirTipoObra = new JButton("Incluir");
		btnIncluirTipoObra.setBounds(615, 198, 89, 23);
		panelPrincipal.add(btnIncluirTipoObra);
		btnIncluirTipoObra.addActionListener(this);
		
		btnIncluirCategoria = new JButton("Incluir");
		btnIncluirCategoria.setBounds(615, 242, 89, 23);
		panelPrincipal.add(btnIncluirCategoria);
		btnIncluirCategoria.addActionListener(this);
		
		btnIncluirLocalizacao = new JButton("Incluir");
		btnIncluirLocalizacao.setBounds(615, 286, 89, 23);
		panelPrincipal.add(btnIncluirLocalizacao);
		btnIncluirLocalizacao.addActionListener(this);
		
		
		ocultaBotoes();
		CarregaCombox ();
		
		return panelPrincipal;
		
		
	}
	public void ocultaBotoes(){
		
		
		lblTpObra.setVisible(false);
		btnIncluirTipoObra.setVisible(false);
		txtNovoTipoObra.setVisible(false);
		txtNovoTipoObra.setText("");
		
		
		lblNovaCategoria.setVisible(false);
		btnIncluirCategoria.setVisible(false);
		txtNovaCategoria.setVisible(false);
		txtNovaCategoria.setText("");
		
		
		
		lblNovaLocalizacao.setVisible(false);
		btnIncluirLocalizacao.setVisible(false);
		txtNovaLocalizacao.setVisible(false);
		txtNovaLocalizacao.setText("");
		
		
		
		
	}
	
	public void NovoTipoObra(){
		lblTpObra.setVisible(true);
		btnIncluirTipoObra.setVisible(true);
		txtNovoTipoObra.setVisible(true);
		btnNovoTipoObra.setEnabled(false);
	}
	
	public void NovaCategoria(){
		lblNovaCategoria.setVisible(true);
		btnIncluirCategoria.setVisible(true);
		txtNovaCategoria.setVisible(true);
		btnNovaCategoria.setEnabled(false);
	}
	public void NovaLocalizacao(){
		
		lblNovaLocalizacao.setVisible(true);
		btnIncluirLocalizacao.setVisible(true);
		txtNovaLocalizacao.setVisible(true);
		btnNovaLocalizacao.setEnabled(false);
		
	}
	

	private JComponent botoes() {
		JPanel panelBotoes = new JPanel(new FlowLayout());
		btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/salvar.png")));
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/edit.png")));
		btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(ObrasBondary.class.getResource("/resources/delete.png")));
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnDeletar.addActionListener(this);
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnDeletar);
		
		
		return panelBotoes;
	}
	
	public void CarregaCombox (){
		tipoObrasController to = new tipoObrasController();
		CategoriaObrasController co = new CategoriaObrasController();
		LocalizacaoObrasController lo = new LocalizacaoObrasController();
		
		listaObras = to.tipoObra();
		listaCat = co.Categoria();
		listaLocalizacao = lo.Localizacao();
		
		
		if(cbCategoria == null || cbCategoria.getSelectedIndex()< 1){	
			cbCategoria.removeAllItems();
		cbCategoria.addItem("Selecione");	
		for(CategoriaObras categoria: listaCat)
			cbCategoria.addItem(categoria.getCategoria());
		}
		
		if(cbLocalizacao == null || cbLocalizacao.getSelectedIndex() < 1){
			cbLocalizacao.removeAllItems();
		cbLocalizacao.addItem("Selecione");
		for(LocalizacaoObras local: listaLocalizacao)
			cbLocalizacao.addItem(local.getLocalizacao());
		}
		
		if(cbTipoObra == null || cbTipoObra.getSelectedIndex() < 1){
			cbTipoObra.removeAllItems();
		cbTipoObra.addItem("Selecione");
		for(tipoObras obras: listaObras)
		cbTipoObra.addItem(obras.getObra());
		}
		
		
		
	}
	public void IncluirTipoObra(){
		tipoObrasController control = new tipoObrasController();
		tipoObras to = new tipoObras();
		to.setObra(txtNovoTipoObra.getText());
		control.adicionaNovoTipoObra(to);
		CarregaCombox();
		cbTipoObra.setSelectedIndex(cbTipoObra.getItemCount()-1);
		ocultaBotoes();
		
	}
	public void IncluirCategoria(){
		CategoriaObrasController control = new CategoriaObrasController();
		CategoriaObras co = new CategoriaObras();
		co.setCategoria(txtNovaCategoria.getText());
		control.adicionarNovaCategoria(co);
		CarregaCombox();
		cbCategoria.setSelectedIndex(cbCategoria.getItemCount()-1);
		ocultaBotoes();
		
	}
	private void IncluirLocalizacao() {
		LocalizacaoObrasController control = new LocalizacaoObrasController();
		LocalizacaoObras loc = new LocalizacaoObras();
		loc.setLocalizacao(txtNovaLocalizacao.getText());
		control.adicionaNovaLocalizacao(loc);
		listaLocalizacao.clear();
		CarregaCombox();
		cbLocalizacao.setSelectedIndex(cbLocalizacao.getItemCount()-1);
		ocultaBotoes();
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNovoTipoObra){
			
				NovoTipoObra();	
			
			
			
		}
		if(e.getSource() == btnIncluirTipoObra){
			if(txtNovoTipoObra.getText().length() <1){
				JOptionPane.showMessageDialog(null, "O campo Tipo de Obra não pode ser vazio");
			}else{
			IncluirTipoObra();
			}
		
		}
		
		if(e.getSource() == btnNovaCategoria){
			
			NovaCategoria();
			
		}
		
		
		if(e.getSource() == btnIncluirCategoria){
			if(txtNovaCategoria.getText().length() <1){
				JOptionPane.showMessageDialog(null, "O campo Categoria não pode ser vazio");
			}else{
			IncluirCategoria();
			}
		}
		
		if(e.getSource() == btnNovaLocalizacao){
			NovaLocalizacao();
		}
		if(e.getSource() == btnIncluirLocalizacao){
			if(txtNovaLocalizacao.getText().length() <1){
				JOptionPane.showMessageDialog(null, "O campo Localização não pode ser vazio");
			}else{
			
			IncluirLocalizacao();
			}
		}
		if(e.getSource() == btnPesquisarObra){
			
			obras = new TableObrasBoundary();
			
			populaDados(obras.getDadosObras());
			
		}
			
		if(e.getSource() == btnSalvar){
			if(ValidacaoCampos()){
			ObrasController control = new ObrasController();
			control.inserir(getDadosDigitados());
			limparCampos();
			}
			
		}
		if(e.getSource() == btnAlterar){
			if(ValidacaoCampos()){
				ObrasController control = new ObrasController();
				control.alterar(getDadosDigitados());
			}
		}
	}
	
	public void populaDados (Obras ob){
		idObra =ob.getIdObras();
		txtNomeObra.setText(ob.getNomeObra());
		txtNomeAutor.setText(ob.getNomeAutor());
		txtBiografia.setText(ob.getBiografia());
		cbTipoObra.setSelectedItem(ob.getTipoObra());
		cbCategoria.setSelectedItem(ob.getCategoria());
		cbLocalizacao.setSelectedItem(ob.getLocalizacao());
		if(ob.getDisponiblidade().contains("ind")){
			chkDisponibilidade.setSelected(false);
		}else{
			chkDisponibilidade.setSelected(true);
		}
		dtObraChooser.setDate(ob.getDataObra());
		
	}
	
	public Obras getDadosDigitados(){
		
		Obras ob = new Obras();
		ob.setIdObras(idObra);
		ob.setNomeObra(txtNomeObra.getText());
		ob.setNomeAutor(txtNomeAutor.getText());
		ob.setBiografia(txtBiografia.getText());
		ob.setDataObra(dtObraChooser.getDate());
		ob.setIdTipoObra(cbTipoObra.getSelectedIndex());
		ob.setIdCategoria(cbCategoria.getSelectedIndex());
		ob.setIdLocalizacao(cbLocalizacao.getSelectedIndex());
		if(chkDisponibilidade.isSelected()){
			ob.setDisponiblidade("Disponível");
		}else
		{
			ob.setDisponiblidade("Indisponível");
		}
		
		
		
		return ob;
	}

public boolean ValidacaoCampos(){
	Calendar DataObra = dtObraChooser.getCalendar();
	System.out.println(dtObraChooser.getCalendar());
	Calendar hoje= Calendar.getInstance();
	
	if(txtNomeObra.getText().length()<1){
		JOptionPane.showMessageDialog(null, "O Nome da Obra não pode ser vazio");
		return false;
	}else if (txtNomeAutor.getText().length()<1){
		JOptionPane.showMessageDialog(null, "O Nome do Autor não pode ser vazio");
		return false;
	}else if (txtBiografia.getText().length()<1){
		JOptionPane.showMessageDialog(null, "A biografia não pode ser vazia");
		return false;
	}else if(cbTipoObra.getSelectedIndex()<1){
		JOptionPane.showMessageDialog(null, "Você deve escolher um tipo de Obra, caso não encontre, clique no botão verde para adicionar");
		return false;
	}
	else if(cbCategoria.getSelectedIndex()<1){
		JOptionPane.showMessageDialog(null, "Você deve escolher uma Categoria, caso não encontre, clique no botão verde para adicionar");
		return false;
	}else if(cbLocalizacao.getSelectedIndex()<1){
		JOptionPane.showMessageDialog(null, "Você deve escolher uma Localização, caso não encontre, clique no botão verde para adicionar");
		return false;
	}else if(dtObraChooser.getDate() == null){
		JOptionPane.showMessageDialog(null, "Você deve escolher uma data");
		return false;
	}else if(hoje.before(DataObra)){
		JOptionPane.showMessageDialog(null, "Você deve escolher uma data anterior a de hoje");
		return false;
	}
	
	
	return true;
}

public void limparCampos(){
	txtNomeAutor.setText("");
	txtNomeObra.setText("");
	txtBiografia.setText("");
	cbCategoria.setSelectedIndex(0);
	cbTipoObra.setSelectedIndex(0);
	cbLocalizacao.setSelectedIndex(0);
	dtObraChooser.cleanup();
	chkDisponibilidade.setSelected(false);
	
}


	
}
