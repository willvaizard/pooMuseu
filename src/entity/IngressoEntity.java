package entity;

public class IngressoEntity {

	private int id;
	private String obrasexp;
	private boolean idade5;
	private boolean idade60;
	private boolean estudante;
	private boolean professor;
	private boolean outros;
	private Double valor;
	private Double desconto;
	private Double total;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObrasexp() {
		return obrasexp;
	}
	public void setObrasexp(String obrasexp) {
		this.obrasexp = obrasexp;
	}
	public boolean isIdade5() {
		return idade5;
	}
	public void setIdade5(boolean idade5) {
		this.idade5 = idade5;
	}
	public boolean isIdade60() {
		return idade60;
	}
	public void setIdade60(boolean idade60) {
		this.idade60 = idade60;
	}
	public boolean isEstudante() {
		return estudante;
	}
	public void setEstudante(boolean estudante) {
		this.estudante = estudante;
	}
	public boolean isProfessor() {
		return professor;
	}
	public void setProfessor(boolean professor) {
		this.professor = professor;
	}
	public boolean isOutros() {
		return outros;
	}
	public void setOutros(boolean outros) {
		this.outros = outros;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}