package com.candidjava.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connessione {
	
	public static Connection getConnection() {
		
		final String URL= "jdbc:mysql://localhost:3306/prova";
		final String USER= "root";
		final String PASSWORD="scaiscai";
		Connection connessione = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		 connessione=  DriverManager.getConnection(URL, USER, PASSWORD);
						
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return connessione;
		
		}
}