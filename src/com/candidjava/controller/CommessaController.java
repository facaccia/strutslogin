package com.candidjava.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.candidjava.dto.DatiLavoratore;
import com.candidjava.dto.User;
import com.candidjava.service.UserService;
import com.candidjava.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
public class CommessaController extends ActionSupport implements ServletResponseAware, ServletRequestAware{	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public User user= new User();
	private UserService userService = new UserServiceImpl() ;
	public List<DatiLavoratore> datiLavoratore;
	DatiLavoratore commessa= new DatiLavoratore();
	
	
	private String data;
	private String lavoroSvolto;
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




	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLavoroSvolto() {
		return lavoroSvolto;
	}

	public void setLavoroSvolto(String lavoroSvolto) {
		this.lavoroSvolto = lavoroSvolto;
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
		String controlloCommessa=  userService.controllaCommessa(id, getData());
		if(controlloCommessa=="success") {
			
		userService.creaCommessa(id ,getLavoroSvolto(), getData());
		datiLavoratore=userService.getDatiLavoratore(id);
		user= userService.getUserById(id);
		setModifica("Commessa aggiunta con successo");
		setMsg("welcome "+user.nome);
		}
		else {datiLavoratore=userService.getDatiLavoratore(id);
		user= userService.getUserById(id);
		setModifica("Errore: Giorno già registrato nel database");
		setMsg("welcome "+user.nome);}
		return "success";
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
