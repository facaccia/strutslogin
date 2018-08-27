package com.candidjava.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.candidjava.dto.DatiLavoratore;
import com.candidjava.dto.Notizie;
import com.candidjava.dto.User;
import com.candidjava.service.UserService;
import com.candidjava.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
public class ModificaController extends ActionSupport implements ServletResponseAware, ServletRequestAware{	
	
	private static final long serialVersionUID = 1L;
	
	
	public List<Notizie> notizie; 
	public User user= new User();
	private UserService userService = new UserServiceImpl() ;
	public List<DatiLavoratore> datiLavoratore;
	
	
	private String campoModifica;
	private String modificaInput;
	private String passwordVecchia;
	private String passwordNuova;
	private String passwordNuova1;
	private String msg;
	private String modifica;
	private String uname;
	private String pass;
	
	
	
	public String getPasswordVecchia() {
		return passwordVecchia;
	}

	public void setPasswordVecchia(String passwordVecchia) {
		this.passwordVecchia = passwordVecchia;
	}

	public String getPasswordNuova() {
		return passwordNuova;
	}

	public void setPasswordNuova(String passwordNuova) {
		this.passwordNuova = passwordNuova;
	}

	public String getPasswordNuova1() {
		return passwordNuova1;
	}

	public void setPasswordNuova1(String passwordNuova1) {
		this.passwordNuova1 = passwordNuova1;
	}

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

	public String getCampoModifica() { 
		return campoModifica;  
	}

	public void setCampoModifica(String campoModifica) {
		this.campoModifica = campoModifica;
	}
	  
	public String getModificaInput() {
		return modificaInput;
	}

	public void setModificaInput(String modificaInput) {
		this.modificaInput = modificaInput;
	}

	public String execute()
	{
		
		Cookie[] cookies = servletRequest.getCookies();
		int id= 0;
		if (cookies != null) {
		 for (Cookie cookie : cookies) {
		   if (cookie.getName().equals("id")) {
		     id=Integer.parseInt( cookie.getValue());
		    }
		  }
		}
		userService.modifica(id, getCampoModifica(), getModificaInput());
		datiLavoratore=userService.getDatiLavoratore(id);
		notizie= userService.getNotizie();
		user= userService.getUserById(id);
		setModifica("Modifica effettuata con successo");
		setMsg("welcome "+user.nome);
		
		return "success";
	}

	
	public String modificaPassword()
	{
		
		Cookie[] cookies = servletRequest.getCookies();
		int id= 0;
		if (cookies != null) {
		 for (Cookie cookie : cookies) {
		   if (cookie.getName().equals("id")) {
		     id=Integer.parseInt( cookie.getValue());
		    }
		  }
		}
		if (getPasswordNuova().equals(getPasswordNuova1())) {
			if (userService.getPassword(id).equals(getPasswordVecchia())) {
				userService.setPassword(id, getPasswordNuova());
				setModifica("Password modificata");
				return "success";
				
			}else {
				setModifica("Password vecchia non corretta");
				return"success";
				}
			
		}
		else{
			
			setModifica("ERRORE: Le password nuove devono essere uguali");
		}
		return "success";
//		setMsg("welcome "+user.nome);
	}
	
	protected HttpServletResponse servletResponse;   
	  @Override   
	  public void setServletResponse(HttpServletResponse servletResponse) {   
	   this.servletResponse = servletResponse;   
	  }   
	  protected HttpServletRequest servletRequest;   
	  @Override   
	  public void setServletRequest(HttpServletRequest servletRequest) {   
	   this.servletRequest = servletRequest;   
	  } 


	
}
