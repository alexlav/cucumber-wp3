package validations;

import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;

import com.swql.myapp.database.DAOFactory;
import com.swql.myapp.database.DAOUser;
import com.swql.myapp.database.Database;
import com.swql.myapp.database.User;

public class DatabaseValidation {
	public void mySQLConnect() throws Exception {		
		Database.getInstance().connect();		
	}
	public void mySQLDisconnect() {
		Database.getInstance().Disconnect();
	}	
	public void mySQLGetUser(String userLogin, String website, String displayname) throws SQLException{
		try {
			mySQLConnect();
		} catch (Exception e) {
			new Exception("Connection to MySQL database failed");
		}		
		DAOUser daoUser = DAOFactory.getDAOUser();
		List<User> people = daoUser.getUsers(userLogin);
		Assert.assertEquals(people.size(), 1, "There are more identical users in database - Validation");
		Assert.assertEquals(people.get(0).getUser_url(), website);
		Assert.assertEquals(people.get(0).getDisplay_name(), displayname);
		System.out.println("First and lastname MySQL: " + people.get(0).getDisplay_name());
		System.out.println("First and lastname Web: " + displayname);
		mySQLDisconnect();
	}
	
	public void mySQlGetUserNull(String userLogin) throws SQLException{
		try {
			mySQLConnect();
		} catch (Exception e) {
			new Exception("Connection to MySQL database failed!");
		}
		DAOUser daoUser = DAOFactory.getDAOUser();
		List<User> people = daoUser.getUsers(userLogin);
		System.out.println("Value of correct  deleted user in Database should be null: " + people.size());
		Assert.assertEquals(people.size(), 0, "There are yet "+people.size()+"users");
	}
	
}
