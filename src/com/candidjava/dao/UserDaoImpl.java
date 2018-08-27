package com.candidjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.candidjava.controller.Connessione;
import com.candidjava.dto.DatiLavoratore;
import com.candidjava.dto.Notizie;
import com.candidjava.dto.User;

public class UserDaoImpl implements UserDao{
	
	List<User> status= new ArrayList<User>();

	@Override
	public	String login(String nome, String password) {
		
		
		
		String risposta = null;

		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "select * from users";
			    
			    ResultSet rs = st.executeQuery(query);  
			   
			   while (rs.next()) {
					
				   status.add(new User(rs.getInt("id_users"),rs.getString("nome"),rs.getString("cognome"),rs.getString("email"),rs.getString("password")));	
					for (User string : status) {
						if(nome.equals(string.getNome())&& password.equals(string.getPassword())){
							risposta ="success";
							break;
							}
					else 
						
						risposta = "error";
					}
						
					}
		} catch (SQLException e) {
			e.printStackTrace();
			
	}
		return risposta;
	}

	@Override
	public User getUser(String nome,String password) {
		User user = new User();
		for (User user1 : status) {
			if(nome.equals(user1.getNome())&& password.equals(user1.getPassword())){
			 user = user1;
			 
			 break;
			}
			else {user= null;}
		}
		return user;
	}

	@Override
	public User getUserById(int id) {
		
		User user= null;
		
		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "select * from users where id_users= '"+id+"';";
	
		 ResultSet rs = st.executeQuery(query);  
		 while (rs.next()) {
				
			  user =new User(rs.getInt("id_users"),rs.getString("nome"),rs.getString("cognome"),rs.getString("email"),rs.getString("password"));	
			  break;
						} 
			  
			} catch (SQLException e) {
		e.printStackTrace();
	}
		return user;
	}
	
	@Override
	public String modifica(int id,String campo, String modifica) {

		String risposta = null;

		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "UPDATE users SET "+campo+" = '"+modifica+"' WHERE id_users = '"+ id+"';";
			    
			     st.execute(query);  
			  
			} catch (SQLException e) {
		e.printStackTrace();
	}

		return risposta;
	}

	@Override
	public String creaUser(String uname, String cognome, String email, String pass) {
	
		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
			PreparedStatement p = con.prepareStatement("insert into users (nome, cognome, email, password) values (?,?,?,?);");
					
					p.setString(1, uname);
					p.setString(2, cognome);
					p.setString(3, email);
					p.setString(4, pass);
					
					p.execute();
			    
			   
		} catch (SQLException e) {
			e.printStackTrace();
			
	}
		return "success";
	}

	@Override
	public List<DatiLavoratore> getDatiLavoratori(int id) {
	List<DatiLavoratore> datiLavoratore = new ArrayList<>();
	
	
		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "select * from dati_lavoratore where id_user= '"+id+"';";
	
		 ResultSet rs = st.executeQuery(query);  
		 while (rs.next()) {
			  datiLavoratore.add(new DatiLavoratore(rs.getInt("id_user"),rs.getString("lavoro_svolto"),rs.getDate("data")));	
			  
						} 
			  
			} catch (SQLException e) {
		e.printStackTrace();
	}
		return datiLavoratore;
		
	}

	@Override
	public String creaCommessa(int id, String lavoroSvolto, String data) {
		
		
		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
			PreparedStatement p = con.prepareStatement("insert into dati_lavoratore (id_user, lavoro_svolto, data) values (?,?,?);");
					
					p.setInt(1, id);
					p.setString(2, lavoroSvolto);
					p.setString(3, data);
					
					p.execute();
			    
			   
		} catch (SQLException e) {
			e.printStackTrace();
			
	}
		return "success";
	}

	@Override
	public String getPassword(int id) {
		String risposta = null;

		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "select * from users where id_users =' "+id+"';";
			    
			    ResultSet rs = st.executeQuery(query);  
			   
			   while (rs.next()) {
					
				   risposta=rs.getString("password");	
				
						
					}
		} catch (SQLException e) {
			e.printStackTrace();
			
	}
		return risposta;
	}

	@Override
	public void setPassword(int id, String passwordNuova) {

		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "UPDATE users SET password  = '"+passwordNuova+"' WHERE id_users = '"+ id+"';";
			    
			     st.execute(query);  
			  
			} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public String controllaCommessa(int id, String data) {
		DatiLavoratore datiLavoratore = new DatiLavoratore();
		
		
		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "select * from dati_lavoratore where id_user= '"+id+"' and data ='"+data+"';";
	
		 ResultSet rs = st.executeQuery(query);  
		 while (rs.next()) {
			  datiLavoratore= new DatiLavoratore(rs.getInt("id_user"),rs.getString("lavoro_svolto"),rs.getDate("data"));	
						} 
			  
			} catch (SQLException e) {
		e.printStackTrace();
	}
		if(datiLavoratore.lavoroSvolto!=null){ 
			return "error";
		}
		
		return "success";
	}

	@Override
	public List<Notizie> getNotizie() {

		
		List<Notizie> notizie = new ArrayList<>();
		
		
		try(Connection con = Connessione.getConnection();
				Statement st = con.createStatement();)
		{
		
		 String query = "select * from notizie;";
	
		 ResultSet rs = st.executeQuery(query);  
		 while (rs.next()) {
			 notizie.add(new Notizie(rs.getInt("id_notizie"),rs.getString("notizie"),rs.getDate("data")));	
			 Collections.reverse(notizie);
						} 
			  
			} catch (SQLException e) {
		e.printStackTrace();
	}
		return notizie;
		
	}
	


}
