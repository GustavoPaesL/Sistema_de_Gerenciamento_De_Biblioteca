package entities;

import entities.enuns.Categoria;

public class Livro {
	
	private String titulo;
	private String autor;
	private int ano;
	private String ISBN;
	private Categoria categoria;
	
	
	public Livro(String titulo, String autor, int ano, String ISBN, Categoria categoria) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.ISBN = ISBN;
		this.categoria = categoria;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public int getAno() {
		return ano;
	}


	public String getISBN() {
		return ISBN;
	}


	public Categoria getCategoria() {
		return categoria;
	}
		



}


