package com.candidjava.dao;

import java.util.List;

import com.candidjava.dto.DatiLavoratore;
import com.candidjava.dto.Notizie;
import com.candidjava.dto.User;

public interface UserDao {
	
	String modifica(int id, String campo, String modifica);
	
	 public String  login(String nome,String password);

	 public User getUser(String nome,String password);

	public User getUserById(int id);

	String creaUser(String uname, String cognome, String email, String pass);

	List<DatiLavoratore> getDatiLavoratori(int id);

	String creaCommessa(int id, String lavoroSvolto, String data);

	String getPassword(int id);

	void setPassword(int id, String passwordNuova);

	String controllaCommessa(int id, String data);

	List<Notizie> getNotizie();

}
