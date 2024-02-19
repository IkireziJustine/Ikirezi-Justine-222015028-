package Routes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Myroutes {
	private int route_id;
	private String source;
	private String destination;
	private String distance;
	private Myroutes(int route_id, String source, String destination, String distance) {
		super();
		this.route_id = route_id;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	public Myroutes() {
		// TODO Auto-generated constructor stub
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int route_id) {
		this.route_id = route_id;
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
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}

public void makeconnection() {
}
public void insertData() {

String host = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

// SQL query to insert data
String sql = "INSERT INTO routes (route_id,source,destination,distance) VALUES (?,?,?,?)";

try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setInt(1, this.route_id);
preparedStatement.setString(2, this.source);
preparedStatement.setString(3, this.destination);
preparedStatement.setString(4, this.distance);


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
    String sql = "SELECT * FROM routes";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

public void update(int inputroute_id) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

// SQL query to update data
String sql = "UPDATE routes SET  route_id=?, source=?, capacity=?,distance=?";

try (
// Establish the co
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement rout = co.prepareStatement(sql);
) {
// Set the new values for the update
	rout.setInt(1, this.getRoute_id());
	rout.setString(2, this.getSource());
	rout.setString(3, this.getDestination()); 
	rout.setString(4, this.getDistance());

// Assuming there is a column named 'id' for the WHERE clause
rout.setInt(5, inputroute_id);

// Execute the update
int rowsAffected = rout.executeUpdate();

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
public void delete(int inputroute_id) {

String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

// SQL query to delete data
String sql = "DELETE FROM routes WHERE route_id=?";

try (
// Establish the 
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement pl = co.prepareStatement(sql);
) {
// Set the value for the WHERE clause
pl.setInt(1, inputroute_id); // Assuming there is a column named 'id' for the WHERE clause

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
public void addColumn(String string) {
	// TODO Auto-generated method stub
	
}
public void addRow(Object[] objects) {
	// TODO Auto-generated method stub
	
}
public void setRoute_id(String text) {
	// TODO Auto-generated method stub
	
}

}

