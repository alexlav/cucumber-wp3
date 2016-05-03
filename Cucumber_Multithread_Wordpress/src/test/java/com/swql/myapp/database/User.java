package com.swql.myapp.database;

import java.sql.Timestamp;

public class User {
	private int id;
	private String user_login;
	private String user_pass;
	private String user_nicename;
	private String user_email;
	private String user_url;
	private Timestamp user_registered;
	private String user_activation_key;
	private int user_status;
	private String display_name;
		
	public User(int id, String user_login, String user_pass, String user_nicename, String user_email, String user_url,
			Timestamp user_registered, String user_activation_key, int user_status, String display_name) {
		this.id = id;
		this.user_login = user_login;
		this.user_pass = user_pass;
		this.user_nicename = user_nicename;
		this.user_email = user_email;
		this.user_url = user_url;
		this.user_registered = user_registered;
		this.user_activation_key = user_activation_key;
		this.user_status = user_status;
		this.display_name = display_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_login() {
		return user_login;
	}
	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_nicename() {
		return user_nicename;
	}
	public void setUser_nicename(String user_nicename) {
		this.user_nicename = user_nicename;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_url() {
		return user_url;
	}
	public void setUser_url(String user_url) {
		this.user_url = user_url;
	}
	public Timestamp getUser_registered() {
		return user_registered;
	}
	public void setUser_registered(Timestamp user_registered) {
		this.user_registered = user_registered;
	}
	public String getUser_activation_key() {
		return user_activation_key;
	}
	public void setUser_activation_key(String user_activation_key) {
		this.user_activation_key = user_activation_key;
	}
	public int getUser_status() {
		return user_status;
	}
	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((display_name == null) ? 0 : display_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((user_activation_key == null) ? 0 : user_activation_key.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_login == null) ? 0 : user_login.hashCode());
		result = prime * result + ((user_nicename == null) ? 0 : user_nicename.hashCode());
		result = prime * result + ((user_pass == null) ? 0 : user_pass.hashCode());
		result = prime * result + ((user_registered == null) ? 0 : user_registered.hashCode());
		result = prime * result + user_status;
		result = prime * result + ((user_url == null) ? 0 : user_url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (display_name == null) {
			if (other.display_name != null)
				return false;
		} else if (!display_name.equals(other.display_name))
			return false;
		if (id != other.id)
			return false;
		if (user_activation_key == null) {
			if (other.user_activation_key != null)
				return false;
		} else if (!user_activation_key.equals(other.user_activation_key))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_login == null) {
			if (other.user_login != null)
				return false;
		} else if (!user_login.equals(other.user_login))
			return false;
		if (user_nicename == null) {
			if (other.user_nicename != null)
				return false;
		} else if (!user_nicename.equals(other.user_nicename))
			return false;
		if (user_pass == null) {
			if (other.user_pass != null)
				return false;
		} else if (!user_pass.equals(other.user_pass))
			return false;
		if (user_registered == null) {
			if (other.user_registered != null)
				return false;
		} else if (!user_registered.equals(other.user_registered))
			return false;
		if (user_status != other.user_status)
			return false;
		if (user_url == null) {
			if (other.user_url != null)
				return false;
		} else if (!user_url.equals(other.user_url))
			return false;
		return true;
	}		
}
