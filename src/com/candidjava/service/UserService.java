package com.candidjava.service;

import java.util.List;

import com.candidjava.dto.DatiLavoratore;
import com.candidjava.dto.Notizie;
import com.candidjava.dto.User;

public interface UserService {
	
	public String login(String nome, String password);


	public User getUser(String uname, String pass);


	public User getUserById(int id);
	
	public String modifica(int id, String campo, String modifica);


	public String creaUser(String uname, String cognome, String email, String pass);


	public List<DatiLavoratore> getDatiLavoratore(int id);


	public String creaCommessa(int id, String lavoroSvolto, String data);


	public String getPassword(int id);


	public void setPassword(int id, String passwordNuova);


	public String controllaCommessa(int id, String data);


	public List<Notizie> getNotizie();
	

}
