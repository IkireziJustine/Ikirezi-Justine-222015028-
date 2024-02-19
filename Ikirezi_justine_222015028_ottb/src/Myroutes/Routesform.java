package Myroutes;

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
import Routes.Myroutes;
import tickets.Mytickets;



public class Routesform implements ActionListener{
JFrame frame;
	
	JLabel route_id_Ib=new JLabel("id");
	JLabel source_Ib=new JLabel("source");
	JLabel distance_Ib=new JLabel("distance");
	JLabel destination_Ib=new JLabel("destination");
	
	JTextField route_id_txf=new JTextField();
	JTextField source_txf=new JTextField();
	JTextField distance_txf=new JTextField();
	JTextField destination_txf=new JTextField();
	
	
	
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
	public  Routesform() {
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
			frame.setTitle("ROUTES FORM");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
    	        route_id_Ib.setBounds(10,10,100,30);
				source_Ib.setBounds(10,50,100,30);
				distance_Ib.setBounds(10,90,100,30);
				destination_Ib.setBounds(10,130,100,30);
				
				route_id_txf.setBounds(160,10,130,30);
				source_txf.setBounds(160,50,130,30);
				distance_txf.setBounds(160,90,130,30);
				destination_txf.setBounds(160,130,130,30);
				//ButtonCRUD
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				table.setBounds(500, 10, 600,240);
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			route_id_Ib.setFont(font);
			source_Ib.setFont(font);
			distance_Ib.setFont(font);
			destination_Ib.setFont(font);
			
			route_id_txf.setFont(font);
			source_txf.setFont(font);
			distance_txf.setFont(font);
			destination_txf.setFont(font);
			//Button CRUD
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(route_id_Ib);
			frame.add (source_Ib);
			frame.add( distance_Ib);
			frame.add(destination_Ib);
			
			frame.add(route_id_txf);
			frame.add( source_txf);
			frame.add( distance_txf);
			frame.add(destination_txf);
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
			frame.add(table);
		}
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				Myroutes rout=new Myroutes();
					if(e.getSource()==insert_btn) {
						
						rout.setRoute_id(route_id_txf.getText());
						rout.setSource(source_txf.getText());
						rout.setDistance(distance_txf.getText());
						rout.setDestination(destination_txf.getText());
						rout.insertData();
					    }
		    
					else if (e.getSource() == Read_btn) {
			        
			          model.addColumn("route_id");
			          model.addColumn("source");
			          model.addColumn("Distance");
			          model.addColumn("Destination");
			           
			            ResultSet resultSet =Myroutes.viewData();
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
						int id=Integer.parseInt(route_id_txf.getText());
						rout.setRoute_id(route_id_txf.getText());
						rout.setSource(source_txf.getText());
						rout.setDistance(distance_txf.getText());
						rout.setDestination(destination_txf.getText());
						rout.update(id);
						}
		                else {
						int id=Integer.parseInt(route_id_txf.getText());
						rout.delete(id);
						}
					}
			
		public static void main(String[] args) {
			Routesform rout=new Routesform ();}
	
		}


