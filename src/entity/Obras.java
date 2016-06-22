package entity;

import java.util.Date;

public class Obras {

	private int idObras;
	private String nomeObra;
	private String dataCadastro;
	private String nomeAutor;
	private String biografia;
	private String tipoObra;
	private int idTipoObra;
	private String categoria;
	private int idCategoria;
	private String localizacao;
	private int idLocalizacao;
	private Date dataObra;
	private String disponiblidade;
	public int getIdObras() {
		return idObras;
	}
	public void setIdObras(int idObras) {
		this.idObras = idObras;
	}
	public String getNomeObra() {
		return nomeObra;
	}
	public void setNomeObra(String nomeObra) {
		this.nomeObra = nomeObra;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public String getTipoObra() {
		return tipoObra;
	}
	public void setTipoObra(String tipoObra) {
		this.tipoObra = tipoObra;
	}
	public int getIdTipoObra() {
		return idTipoObra;
	}
	public void setIdTipoObra(int idTipoObra) {
		this.idTipoObra = idTipoObra;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getIdLocalizacao() {
		return idLocalizacao;
	}
	public void setIdLocalizacao(int idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}
	

	public String getDisponiblidade() {
		return disponiblidade;
	}
	public void setDisponiblidade(String disponiblidade) {
		this.disponiblidade = disponiblidade;
	}
	public Date getDataObra() {
		return dataObra;
	}
	public void setDataObra(Date dataObra) {
		this.dataObra = dataObra;
	}
	@Override
	public String toString() {
		return "Obras [idObras=" + idObras + ", nomeObra=" + nomeObra + ", dataCadastro=" + dataCadastro
				+ ", nomeAutor=" + nomeAutor + ", biografia=" + biografia + ", tipoObra=" + tipoObra + ", idTipoObra="
				+ idTipoObra + ", categoria=" + categoria + ", idCategoria=" + idCategoria + ", localizacao="
				+ localizacao + ", idLocalizacao=" + idLocalizacao + ", dataObra=" + dataObra + ", disponiblidade="
				+ disponiblidade + "]";
	}
	
	
	
	
	
	
	
}
