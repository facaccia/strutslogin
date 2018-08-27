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


public class LoginController extends ActionSupport implements ServletResponseAware, ServletRequestAware {	
	
	private static final long serialVersionUID = 1L;
	
	
	private UserService userService = new UserServiceImpl() ;
	
	public User user= new User();
	public List<DatiLavoratore> datiLavoratore;
	public List<Notizie> notizie; 
	
	public List<DatiLavoratore> getDatiLavoratore() {
		return datiLavoratore;
	}

	public void setDatiLavoratore(List<DatiLavoratore> datiLavoratore) {
		this.datiLavoratore = datiLavoratore;
	}


	private String uname;
	private String pass;
	private String msg;
	private String errore;
	
	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}

	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public String execute()
	{
		
		for(int i =0; i<1000000; i++){
			System.out.println(i);
		}

		String risposta= null;
		
	
		risposta = userService.login(getUname(), getPass());
		
		if (risposta=="success") {
			user= userService.getUser(getUname(), getPass());
			datiLavoratore= userService.getDatiLavoratore(user.idUsers);
			notizie= userService.getNotizie();
			
			  Cookie div = new Cookie("id", Integer.toString(user.idUsers));
			  div.setMaxAge(60*60*24); 
			  servletResponse.addCookie(div);
			setMsg("Welcome "+user.nome);
		} else {
			
			setErrore("Login Fail...");
		}

	return risposta;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
