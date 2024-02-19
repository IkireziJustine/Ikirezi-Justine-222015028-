package tickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Mytickets {
	private int ticket_id;
	private String user_id;
	private String source;
	private String destination;
	private String departure_time;
	public Mytickets() {
	}
	
	
	public Mytickets(int ticket_id, String user_id, String source, String destination, String departure_time) {
		super();
		this.ticket_id = ticket_id;
		this.user_id = user_id;
		this.source = source;
		this.destination = destination;
		this.departure_time = departure_time;
	}



	public int getTicket_id() {
		return ticket_id;
	}


	public void setTicket_id(int string) {
		this.ticket_id = string;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String User_id) {
		this.user_id =User_id ;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getDeparture_time() {
		return departure_time;
	}


	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}


	public void makeconnection() {
	}
			public void insertData() {
		
	    String host = "jdbc:mysql://localhost/ikirezi_justine_ottb";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO tickets (user_id, source,destination,departure_time) VALUES (?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       
	        preparedStatement.setInt(1, this.ticket_id);
	        preparedStatement.setString(2, this.user_id);
	        preparedStatement.setString(3, this.source);
	        preparedStatement.setString(3, this.destination);
	        preparedStatement.setString(3, this.departure_time);
	  
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
			    String sql = "SELECT * FROM tickets";

			    try {
			        Connection con = DriverManager.getConnection(host, user, password);
			        PreparedStatement preparedStatement = con.prepareStatement(sql);
			        return preparedStatement.executeQuery();
			    } catch (SQLException e) {
			        e.printStackTrace();
			        return null;
			    }
			}

	public void update(int inputticket_id) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE ticket SET  ticket_id=?, user_id=?, source=?,destination=?,departure_time=?";

	    try (
	        // Establish the co
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement tick = co.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	tick.setInt(1, this.getTicket_id());
	    	tick.setString(2, this.getUser_id());
	    	tick.setString(3, this.getSource()); 
	    	tick.setString(4, this.getDestination());
	    	tick.setString(5, this.getDeparture_time());
	    	// Assuming there is a column named 'id' for the WHERE clause
	    	tick.setInt(6, inputticket_id);
	       
	        // Execute the update
	        int rowsAffected = tick.executeUpdate();

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
	public void delete(int inputticket_id) {
		
	    String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM ticket WHERE ticket_Id=?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputticket_id); // Assuming there is a column named 'id' for the WHERE clause

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


	public void setColumnCount(int i) {
		// TODO Auto-generated method stub
		
	}


	public void addColumn(String string) {
		// TODO Auto-generated method stub
		
	}


	public void addRow(Object[] objects) {
		// TODO Auto-generated method stub
		
	}


	}

	