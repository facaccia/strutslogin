package com.candidjava.dto;

public class User {
	
	public int idUsers;
	public String  cognome, email, password;
	public String nome ;
	public boolean controllo = false;
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int idUsers, String nome, String cognome, String email, String password) {
		this.idUsers = idUsers;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password = password;
	}
	
	
	public boolean getControllo() {
		return controllo;
	}
	public void setControllo(boolean controllo) {
		this.controllo = controllo;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [idUsers=" + idUsers + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
}
