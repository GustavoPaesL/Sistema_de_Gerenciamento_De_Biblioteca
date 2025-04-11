package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import entities.enuns.Categoria;

public class Livro {
	
	private String titulo;
	private String autor;
	private int ano;
	private String ISBN;
	private Categoria categoria;
	
	
	public Livro(String titulo, String autor, int ano, String ISBN, String categoria) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.ISBN = ISBN;
		this.categoria = Categoria.valueOf(categoria);
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
		

	
	public void inserirLivro() {
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnnection();
			
			st = conn.createStatement();
			
			st.executeUpdate("INSERT INTO livros (titulo, autor, ano, isbn, categoria)\r\n"
					+ "VALUES ('" + titulo +"', '" + autor + "'," + ano +", '" + ISBN + "', '" + categoria.toString() + "');");
		
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.CloseStatement(st);
			DB.closeConnection();
		}
		
	}


}