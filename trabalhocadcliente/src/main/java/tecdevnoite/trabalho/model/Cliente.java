package tecdevnoite.trabalho.model;

public class Cliente {
	
	private Long id;
	private int idade, qtdMasc, qtdFem;
	private String nome;
	private String endereco;
	private Long numero;
	private String email;
	private String produto;
	private String faixa_etaria;
	private Genero genero;
	
	
	public int getQtdMasc() {
		return qtdMasc;
	}
	public void setQtdMasc(int qtdMasc) {
		this.qtdMasc = qtdMasc;
	}
	public int getQtdFem() {
		return qtdFem;
	}
	public void setQtdFem(int qtdFem) {
		this.qtdFem = qtdFem;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getFaixa_etaria() {
		return faixa_etaria;
	}
	public void setFaixa_etaria(String faixa_etaria) {
		this.faixa_etaria = faixa_etaria;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
