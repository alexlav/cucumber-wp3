package com.swql.myapp.database;

public class DAOFactory {
	public static DAOUser getDAOUser(){
		return new DAOUser();
	}	
}