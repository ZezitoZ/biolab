package br.edu.ifpi.biolab.Entidade;

public class Classe {

	private int id;
	private String nome;
	private Filo filo;

	public Classe(){
		
	}
	
	public Classe(String nome) {
		this.nome = nome;
	

	}
	
	public Classe(String nome, Filo filo) {
		this.nome = nome;
		this.filo = filo;

	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Filo getFilo() {
		return filo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFilo(Filo filo) {
		this.filo = filo;
	}

}
