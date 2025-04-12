package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	
	public static boolean autenticarUsuario(String email, String senhaDigitada) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = DB.getConnnection();

	        ps = conn.prepareStatement("SELECT senha FROM usuarios WHERE email = ?");
	        ps.setString(1, email);

	        rs = ps.executeQuery();

	        if (rs.next()) {
	            String senhaHashBanco = rs.getString("senha");
	            String senhaHashDigitada = HashUtil.gerarHashSHA256(senhaDigitada);

	            return senhaHashBanco.equals(senhaHashDigitada);
	        } else {
	            System.out.println("Usuário não encontrado.");
	            return false;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        DB.CloseResultSet(rs);
	        DB.CloseStatement(ps);
	        DB.closeConnection();
	    }
	}
	
	
}