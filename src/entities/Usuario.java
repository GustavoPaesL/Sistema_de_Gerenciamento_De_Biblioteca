package entities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import entities.enuns.TipoUsuario;
import util.HashUtil;

public class Usuario {

	private String nome;
	private String email;
	private String tel;
	private TipoUsuario tipoUsuario;
	private String senha;
	
	
	public Usuario(String nome, String email, String tel, String tipoUsuario, String senha) {

		this.nome = nome;
		this.email = email;
		this.tel = tel;
		this.tipoUsuario = TipoUsuario.valueOf(tipoUsuario);
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getTel() {
		return tel;
	}



	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	
	public void inserirUsuario() {
	    
	    Connection conn = null;
	    Statement st = null;
	    
	    try {
	        conn = DB.getConnnection();
	        st = conn.createStatement();
	    
	        
	        String senhaHash = HashUtil.gerarHashSHA256(senha);
	        
	        
	        st.executeUpdate(
	            "INSERT INTO usuarios (nome, email, tel, tipoUsuario, senha) " +
	            "VALUES ('" + nome + "', '" + email + "', '" + tel + "', '" + tipoUsuario.toString() + "', '" + senhaHash + "');"
	        );
	        
	        System.out.println("usuario criado com sucesso!");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DB.CloseStatement(st);
	        DB.closeConnection();
	    }
	}

	
}