package entities;

import entities.enuns.TipoUsuario;

public class Usuario {

	private String nome;
	private String email;
	private String tel;
	private TipoUsuario tipoUsuario;
	
	
	
	public Usuario(String nome, String email, String tel, TipoUsuario tipoUsuario) {

		this.nome = nome;
		this.email = email;
		this.tel = tel;
		this.tipoUsuario = tipoUsuario;
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
	
	
	
	
}
