package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;
import entities.Livro;
import entities.Usuario;
import entities.enuns.Categoria;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		boolean rodando = true;

		while (rodando) {
		    System.out.println("=== Sistema Biblioteca ===");
		    System.out.println("1. Login");
		    System.out.println("2. Cadastrar usuário");
		    System.out.println("3. Sair");
		    System.out.println("4. Admin");

		    int opcao = sc.nextInt();
		    sc.nextLine(); // limpar buffer

		    switch (opcao) {
		        case 1:  //login
		            
		        	String emailLogin;
		        	String senha;
		        	do {
		        		System.out.println("email:");
						emailLogin = sc.nextLine();

						System.out.println("senha:");
						senha = sc.nextLine();

		        	} while (Usuario.autenticarUsuario(emailLogin, senha) == false);
				
		        	break;
		        case 2:  //criar usuario
		        	
		        	System.out.println("insira o nome: ");
		        	String nome = sc.nextLine();

		        	System.out.println("insira o email: ");
		        	String email = sc.nextLine();

		        	System.out.println("insira o tel: ");
		        	String tel = sc.nextLine();

		        	System.out.println("insira o tipo usuario (PROFESSOR/ALUNO): ");
		        	String tipoUsuario = sc.nextLine();

		        	
		        	String senha1;
		        	String senha2;
		        	
		        	do {
						System.out.println("insira a senha: ");
						senha1 = sc.nextLine();

						System.out.println("insira a senha novamente: ");
						senha2 = sc.nextLine();

					} while (!senha1.equals(senha2));
		        	
		        	Usuario user = new Usuario(nome, email, tel, tipoUsuario, senha1);
		        	user.inserirUsuario();
		        	
		            break;
		        case 3:
		            rodando = false;
		            System.out.println("Encerrando sistema...");
		            break;
		        case 4:
		        	//chama método admin
		        default:
		            System.out.println("Opção inválida.");
		    }
		}
		sc.close();
		
		
	}

}
