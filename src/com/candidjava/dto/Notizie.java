package com.candidjava.dto;

import java.sql.Date;

public class Notizie {
	
	public int idNotizia;
	public String notizia;
	public Date data;
	public int getIdNotizia() {
		return idNotizia;
	}
	public void setIdNotizia(int idNotizia) {
		this.idNotizia = idNotizia;
	}
	public String getNotizia() {
		return notizia;
	}
	public void setNotizia(String notizia) {
		this.notizia = notizia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	@Override
	public String toString() {
		return "Notizie [idNotizia=" + idNotizia + ", notizia=" + notizia + ", data=" + data + "]";
	}

	
	public Notizie(int idNotizia, String notizia, Date data) {
		this.idNotizia = idNotizia;
		this.notizia = notizia;
		this.data = data;
	}
	public Notizie() {
		// TODO Auto-generated constructor stub
	}

}
