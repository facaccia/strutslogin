package com.candidjava.service;

import java.util.List;

import com.candidjava.dao.UserDao;
import com.candidjava.dao.UserDaoImpl;
import com.candidjava.dto.DatiLavoratore;
import com.candidjava.dto.Notizie;
import com.candidjava.dto.User;

public class UserServiceImpl implements UserService{
	

	UserDao userDao= new UserDaoImpl();
	
	
	@Override
	public String modifica(int id, String campo, String modifica) {
		// TODO Auto-generated method stub
		return userDao.modifica(id, campo, modifica);
	}
	

	@Override
	public String login(String nome, String password) {
		String risposta= userDao.login(nome, password);
		return risposta;
	}


	@Override
	public User getUser(String nome, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(nome, password);
	}


	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}


	@Override
	public String creaUser(String uname, String cognome, String email, String pass) {
		return userDao.creaUser(uname, cognome, email, pass);
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<DatiLavoratore> getDatiLavoratore(int id) {
		// TODO Auto-generated method stub
		return userDao.getDatiLavoratori(id);
	}


	@Override
	public String creaCommessa(int id, String lavoroSvolto, String data) {
		// TODO Auto-generated method stub
		return userDao.creaCommessa(id,lavoroSvolto, data);
	}


	@Override
	public String getPassword(int id) {
		return userDao.getPassword(id);
		
	}


	@Override
	public void setPassword(int id, String passwordNuova) {
		userDao.setPassword(id, passwordNuova);
		
	}


	@Override
	public String controllaCommessa(int id, String data) {
		// TODO Auto-generated method stub
		return userDao.controllaCommessa(id, data);
	}


	@Override
	public List<Notizie> getNotizie() {
		// TODO Auto-generated method stub
		return userDao.getNotizie();
	}


}
