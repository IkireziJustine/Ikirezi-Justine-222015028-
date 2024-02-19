package Myvehicles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Mytickets.ticketform;
import tickets.Mytickets;
import vehicles.Myvehicles;


public class Vehiclesform implements ActionListener{
JFrame frame;
	
	JLabel Vehicle_id_Ib=new JLabel("id");
	JLabel vehicle_name_Ib=new JLabel("vehicle_name");
	JLabel capacity_Ib=new JLabel("capacity");
	JLabel route_id_Ib=new JLabel("route_id");
	
	
	JTextField Vehicle_id_txf=new JTextField();
	JTextField   vehicle_name_txf=new JTextField();
	JTextField capacity_txf=new JTextField();
	JTextField route_id_txf=new JTextField();
	
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new
	JButton("uptade");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public  Vehiclesform() {
		createForm();
		setLocationSize();
		setFontforall();
		addcomponentforFrame();
		ActionEvent();
	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);
	}
	private void createForm() {
			frame=new JFrame();
			frame.setTitle("VEHICLES FORM");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
    	        Vehicle_id_Ib.setBounds(10,10,100,30);
				vehicle_name_Ib.setBounds(10,50,100,30);
				capacity_Ib.setBounds(10,130,100,30);
				route_id_Ib.setBounds(10,90,100,30);
				
				
				Vehicle_id_txf.setBounds(160,10,130,30);
				vehicle_name_txf.setBounds(160,50,130,30);
				capacity_txf.setBounds(160,130,130,30);
				route_id_txf.setBounds(160,90,130,30);
				
				//ButtonCRUD
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				table.setBounds(500, 10, 600,240);
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			Vehicle_id_Ib.setFont(font);
			vehicle_name_Ib.setFont(font);
			capacity_Ib.setFont(font);
			route_id_Ib.setFont(font);
			
			
			Vehicle_id_txf.setFont(font);
			vehicle_name_txf.setFont(font);
			capacity_txf.setFont(font);
			route_id_txf.setFont(font);
			
			//Button CRUD
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(Vehicle_id_Ib);
			frame.add (vehicle_name_Ib);
			frame.add( capacity_Ib);
			frame.add( route_id_Ib);
			
			
			frame.add(Vehicle_id_txf);
			frame.add( vehicle_name_txf);
			frame.add(capacity_txf);
			frame.add(route_id_txf);
			
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
			frame.add(table);
		}
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Myvehicles veh=new Myvehicles();
					if(e.getSource()==insert_btn) {
						
						veh.setVehicle_id(Vehicle_id_txf.getText());
						veh.setVehicle_name(vehicle_name_txf.getText());
						veh.setCapacity(capacity_txf.getText());
						veh.setRoute_id(route_id_txf.getText());
						
						veh.insertData();
					    }
		    
					else if (e.getSource() == Read_btn) {
			        
			          
						model.addColumn("vehicle_id");
						model.addColumn("vehicle_name");
						model.addColumn("capacity");
						model.addColumn("route_id");
			           
			            ResultSet resultSet =Myvehicles.viewData();
			            if (resultSet != null) {
			                try {
			                    while (resultSet.next()) {
			                    	model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
			                                resultSet.getString(3), resultSet.getString(4)});
			                    }
			                } catch (SQLException ex) {
			                    ex.printStackTrace();
			                }
			            }}
		                else if (e.getSource()==update_btn) {
						int id=Integer.parseInt(Vehicle_id_txf.getText());
						veh.setVehicle_id(Vehicle_id_txf.getText());
						veh.setVehicle_name(vehicle_name_txf.getText());
						veh.setCapacity(capacity_txf.getText());
						veh.setRoute_id(route_id_txf.getText());
						veh.update(id);
						}
		                else {
						int id=Integer.parseInt(Vehicle_id_txf.getText());
						veh.delete(id);
						}
					}
				public static void main(String[] args) {
					Vehiclesform veh=new Vehiclesform();
				System.out.println(veh);

		}
				
	}
		
		
		
