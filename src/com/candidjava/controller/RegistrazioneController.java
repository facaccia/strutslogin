package com.candidjava.controller;


import com.candidjava.dto.User;
import com.candidjava.service.UserService;
import com.candidjava.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
public class RegistrazioneController extends ActionSupport{	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public User user= new User();
	private UserService userService = new UserServiceImpl() ;
	
	
	private String cognome;
	private String email;
	private String msg;
	private String modifica;
	private String uname;
	private String pass;
	
	
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getModifica() {
		return modifica;
	}

	public void setModifica(String modifica) {
		this.modifica = modifica;
	}

	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String execute()
	{
		
		userService.creaUser(getUname(), getCognome(), getEmail(),getPass());
		setModifica("Registrazione effettuata con successo");
		setMsg("welcome "+user.nome);
		
		return "success";
	}
	
}
