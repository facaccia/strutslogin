package com.candidjava.dto;

import java.sql.Date;

public class DatiLavoratore {
	
	public int idUsers;
	public String lavoroSvolto;
	public Date data;
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public String getLavoroSvolto() {
		return lavoroSvolto;
	}
	public void setLavoroSvolto(String lavoroSvolto) {
		this.lavoroSvolto = lavoroSvolto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "DatiLavoratore [idUsers=" + idUsers + ", lavoroSvolto=" + lavoroSvolto + ", data=" + data + "]";
	}
	public DatiLavoratore(int idUsers, String lavoroSvolto, Date date) {
		this.idUsers = idUsers;
		this.lavoroSvolto = lavoroSvolto;
		this.data = date;
	}
	
	public DatiLavoratore() {
		// TODO Auto-generated constructor stub
	}

}
