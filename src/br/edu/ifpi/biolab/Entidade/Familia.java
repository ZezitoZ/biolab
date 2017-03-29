package br.edu.ifpi.biolab.Entidade;

public class Familia {
	private int id;
	private String nome;
	private Ordem ordem;

	public Familia() {

	}
	

	public Familia(String nome) {
		this.nome = nome;
	}
	
	public Familia(String nome, Ordem ordem) {
		this.nome = nome;
		this.ordem = ordem;
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

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	public Ordem getOrdem() {
		return ordem;
	}

}
