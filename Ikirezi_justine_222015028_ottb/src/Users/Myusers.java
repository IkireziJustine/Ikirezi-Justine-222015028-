package Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Myusers {
	private int user_id;
	private String  name ;
	private String email;
	private String phone_number;
	private String address;
	public Myusers() {
		// TODO Auto-generated constructor stub
	}

	
public Myusers(int user_id, String name, String email, String phone_number, String address) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
	}


public int getUser_id() {
	return user_id;
}


public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPhone_number() {
	return phone_number;
}


public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public void makeconnection() {
}
public void insertData() {
//JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

//SQL query to insert dataFirst_Name
String sql = "INSERT INTO users ( user_id, name, email,phone_number,address) VALUES (?,?,?,?,?)";

try (
//Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

//Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
  ) {
//Set the values for the prepared statement

preparedStatement.setInt(1, this. user_id);
preparedStatement.setString(2, this. name);
preparedStatement.setString(3, this. email);
preparedStatement.setString(4, this. phone_number);
preparedStatement.setString(5, this. address);

//Execute the query
int rowsAffected = preparedStatement.executeUpdate();

//Check the result
if (rowsAffected > 0) {
	System.out.println("Data inserted sucessfully");
  JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
} else {
  System.out.println("Failed to insert data.");
  JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

}

} catch (SQLException e) {
e.printStackTrace();
}	
}
public static ResultSet viewData() {
    String host = "jdbc:mysql://localhost/ikirezi_justine_ottb";
    String user = "root";
    String password = "";
    String sql = "SELECT * FROM users";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}
public void update(int inputid) {
//JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/"
		+ "ikirezi_justine_ottb";
String user = "root";
String password = "";

//SQL query to update data

String sql = "UPDATE users SET  user_id=?, name=?, email=? ,phone_number=? ,address=? WHERE user_id = ?";

try (
//Establish the cone
Connection co = DriverManager.getConnection(url, user, password);

//Create a prepared statement
PreparedStatement us = co.prepareStatement(sql);
) {
//Set the new values for the update
us.setInt(1, this.getUser_id());
us.setString(2, this.getName());
us.setString(3, this.getEmail()); // Assuming there is a column named 'id' for the WHERE clause
us.setString(4, this.getPhone_number());
us.setString(5, this.getAddress());
us.setInt(6, inputid);

//Execute the update
int rowsAffected = us.executeUpdate();

//Check the result
if (rowsAffected > 0) {
  System.out.println("Data updated successfully!");
  JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
} else {
  System.out.println("Failed to update data. No matching record found.");
  JOptionPane.showMessageDialog(null, "Failed to update data!","After update",JOptionPane.INFORMATION_MESSAGE);
}

} catch (SQLException e) {
e.printStackTrace();
}   
}
public void delete(int inputid) {
//JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

//SQL query to delete data
String sql = "DELETE FROM  users WHERE user_Id = ?";

try (
//Establish the 
Connection co = DriverManager.getConnection(url, user, password);

//Create a prepared statement
PreparedStatement pl = co.prepareStatement(sql);
) {
//Set the value for the WHERE clause
pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause

//Execute the delete
int rowsAffected = pl.executeUpdate();

//Check the result
if (rowsAffected > 0) {
  System.out.println("Data deleted successfully!");
  JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
} else {
  System.out.println("Failed to delete data. No matching record found.");
  JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
}

} catch (SQLException e) {
e.printStackTrace();
}}}




	