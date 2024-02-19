package vehicles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Myvehicles {
	private int vehicle_id;
	private String vehicle_name;
	private String capacity;
	private String route_id;
	private Myvehicles(int vehicle_id, String vehicle_name, String capacity, String route_id) {
		super();
		this.vehicle_id = vehicle_id;
		this.vehicle_name = vehicle_name;
		this.capacity = capacity;
		this.route_id = route_id;
	}
	public Myvehicles() {
		// TODO Auto-generated constructor stub
	}
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public String getCapacity() {
		return capacity;
	}
	public void  setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	
public void makeconnection() {
}
public void insertData() {

String host = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

// SQL query to insert data
String sql = "INSERT INTO vehicles (vehicle_id,vehicle_name,capacity,route_id) VALUES (?,?,?,?)";

try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	   PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setInt(1, this.vehicle_id);
preparedStatement.setString(2, this.vehicle_name);
preparedStatement.setString(3, this.capacity);
preparedStatement.setString(4, this.route_id);


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
    String sql = "SELECT * FROM vehicles";

    try {
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        return preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

public void update(int inputvehicle_id) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

// SQL query to update data
String sql = "UPDATE vehicles SET  vehicle_id=?, vehicle_name=?, capacity=?,route_id=?";

try (
// Establish the co
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement veh = co.prepareStatement(sql);
) {
// Set the new values for the update
	veh.setInt(1, this.getVehicle_id());
	veh.setString(2, this.getVehicle_name());
	veh.setString(3, this.getCapacity()); 
	veh.setString(4, this.getRoute_id());

// Assuming there is a column named 'id' for the WHERE clause
veh.setInt(5, inputvehicle_id);

// Execute the update
int rowsAffected = veh.executeUpdate();

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
public void delete(int inputvehicle_id) {

String url = "jdbc:mysql://localhost/ikirezi_justine_ottb";
String user = "root";
String password = "";

// SQL query to delete data
String sql = "DELETE FROM vehicles WHERE vehicle_Id=?";

try (
// Establish the 
Connection co = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement pl = co.prepareStatement(sql);
) {
// Set the value for the WHERE clause
pl.setInt(1, inputvehicle_id); // Assuming there is a column named 'id' for the WHERE clause

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
public void setVehicle_id(String text) {
	// TODO Auto-generated method stub
	
}}
