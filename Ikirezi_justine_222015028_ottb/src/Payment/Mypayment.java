package Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Mypayment {
	private int payment_id;
	private String ticket_id;
	private String amount;
	private String payment_date;
	private Mypayment(int payment_id, String ticket_id, String amount, String payment_date) {
		super();
		this.payment_id = payment_id;
		this.ticket_id = ticket_id;
		this.amount = amount;
		this.payment_date = payment_date;
	}
	
	
	
	
	public Mypayment() {
		// TODO Auto-generated constructor stub
	}




	public int getPayment_id() {
		return payment_id;
	}




	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}




	public String getTicket_id() {
		return ticket_id;
	}




	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}




	public String getAmount() {
		return amount;
	}




	public void setAmount(String amount) {
		this.amount = amount;
	}




	public String getPayment_date() {
		return payment_date;
	}




	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}




	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/ikirezi_justine_ottb";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO payment (ticket_id,amount, payment_date) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setString(1, this.ticket_id);
	        preparedStatement.setString(2, this.amount);
	        preparedStatement.setString(3, this.payment_date);
	  
	                // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
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
			    String sql = "SELECT * FROM payment";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputpayment_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE payment SET  ticket_id=?, amount=?, payment_date=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pay = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	pay.setString(1, this.getTicket_id());
	    	pay.setString(2, this.getAmount());
	    	pay.setString(3, this.getPayment_date()); // Assuming there is a column named 'id' for the WHERE clause
	    	pay.setInt(4, inputpayment_id);
	       
	        // Execute the update
	        int rowsAffected = pay.executeUpdate();

	        // Check the result
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
	public void delete(int inputpayment_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM payment WHERE payment_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputpayment_id); // Assuming there is a column named 'id' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result  
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	}