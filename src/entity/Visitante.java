package entity;

public class Visitante {
	private String cpf;
	private String nacionalidade;
	private int idade;
	private String sexo;
	private String instrucao;
	private String Transporte;
	private String dataVisita;
	
	public String getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(String dataVisita) {
		this.dataVisita = dataVisita;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getInstrucao() {
		return instrucao;
	}
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}
	public String getTransporte() {
		return Transporte;
	}
	public void setTransporte(String transporte) {
		Transporte = transporte;
	}
	@Override
	public String toString() {
		return "VisitanteEntity [cpf=" + cpf + ", nacionalidade=" + nacionalidade + ", idade=" + idade + ", sexo="
				+ sexo + ", instrucao=" + instrucao + ", Transporte=" + Transporte + ", dataVisita=" + dataVisita + "]";
	}
	

}
