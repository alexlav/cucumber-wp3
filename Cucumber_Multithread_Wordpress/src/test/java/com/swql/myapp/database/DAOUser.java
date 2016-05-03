package com.swql.myapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

public class DAOUser {
	public int AddUser(User user) throws SQLException{
		Connection connection = Database.getInstance().getConnection();
		String sql = "insert into wp_users (user_login, user_pass, user_email, display_name ) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, user.getUser_login());
		ps.setString(2, user.getUser_pass());
		ps.setString(3, user.getUser_email());
		ps.setString(4, user.getDisplay_name());
		
		int updated = ps.executeUpdate();
		ps.close();
		return updated;		
	}
	
	public User getUser(String user_login) throws SQLException{
		Connection connection  = Database.getInstance().getConnection();
		Statement query;
		query = connection.createStatement();
		String sql = "select * from wp_users where user_login = '" + user_login+"'";
		//PreparedStatement ps = connection.prepareStatement(sql);
		//ps.setString(1, user_login);
		ResultSet resultSet = query.executeQuery(sql);
		User user = null;
		resultSet.close();
		query.close();
		return user;
	}
	
	public List<User> getUsers(String userLogin) throws SQLException{
		List<User> users = new ArrayList<User>();
		Connection connection = Database.getInstance().getConnection();
		String sql = "select * from wp_users where user_login = '" + userLogin+"'";
		Statement selectStament =  connection.createStatement();
		ResultSet results = selectStament.executeQuery(sql);
		while(results.next()){
			int id = results.getInt("ID");
			String user_login = results.getString("user_login");
			String user_pass = results.getString("user_pass");
			String user_nicename = results.getString("user_nicename");
			String user_email = results.getString("user_email");
			String user_url = results.getString("user_url");
			Timestamp user_registered = results.getTimestamp("user_registered");
			String user_activation_key = results.getString("user_activation_key");
			int user_status = results.getInt("user_status");
			String display_name = results.getString("display_name");
			
			User user = new User(id, user_login, user_pass, user_nicename,user_email, 
					user_url, user_registered, user_activation_key, user_status, display_name);
			users.add(user);			
		}
		results.close();
		selectStament.close();
		return users;		
	}	
}
