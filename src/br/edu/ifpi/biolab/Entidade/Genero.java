package br.edu.ifpi.biolab.Entidade;

public class Genero {
	private int id;
	private String nome;
	private Familia familia;

	public Genero() {
		
	}
	public Genero( String nome) {
		this.nome = nome;
	}
	
	public Genero( String nome, Familia familia) {
		this.nome = nome;
		this.familia = familia;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;

	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Familia getFamilia() {
		return familia;
	}

}
