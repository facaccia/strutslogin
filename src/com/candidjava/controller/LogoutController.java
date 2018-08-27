package com.candidjava.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.candidjava.dto.User;
import com.opensymphony.xwork2.ActionSupport;
public class LogoutController extends ActionSupport implements ServletResponseAware, ServletRequestAware{	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public User user= new User();
	
	private String uname;
	private String pass;
	private String msg = "ciao";
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
		
			Cookie[] cookies = servletRequest.getCookies();
			int id= 0;
			if (cookies != null) {
			 for (Cookie cookie : cookies) {
			   if (cookie.getName().equals("id")) {
			     id=Integer.parseInt( cookie.getValue());
			    }
			  }
			}
			if (id==0) {
				setErrore("Logout non possibile");
				return "error";
			}
			else {
			setErrore("Logout Effettuato");
			
			  Cookie div = new Cookie("id", "empty");
			  div.setMaxAge(60); 
			  servletResponse.addCookie(div);
			  
			return "success";}
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
