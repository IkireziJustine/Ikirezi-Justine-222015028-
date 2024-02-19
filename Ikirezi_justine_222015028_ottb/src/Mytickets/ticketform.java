package Mytickets;

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

import Formusers.Myformusers;
import Mypayment.Paymentforms;
import Payment.Mypayment;
import tickets.Mytickets;

public class ticketform implements ActionListener{
JFrame frame;
	
	JLabel ticket_id_Ib=new JLabel("ticket_id");
	JLabel user_id_Ib=new JLabel("user_id");
	JLabel source_Ib=new JLabel("source");
	JLabel destination_Ib=new JLabel("destination");
	JLabel departure_time_Ib=new JLabel("departure_time");
	
	JTextField ticket_id_txf=new JTextField();
	JTextField user_id_txf=new JTextField();
	JTextField source_txf=new JTextField();
	JTextField destination_txf=new JTextField();
	JTextField departure_time_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton ("uptade");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public  ticketform() {
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
			frame.setTitle("ticketform");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
    	         ticket_id_Ib.setBounds(10,10,100,30);
				 user_id_Ib.setBounds(10,50,100,30);
				 source_Ib.setBounds(10,90,100,30);
				 destination_Ib.setBounds(10,130,100,30);
				 departure_time_Ib.setBounds(10,170,100,30);
				
				 ticket_id_txf.setBounds(160,10,130,30);
				 user_id_txf.setBounds(160,50,130,30);
				 source_txf.setBounds(160,90,130,30);
				 destination_txf.setBounds(160,130,130,30);
				 departure_time_txf.setBounds(160,170,130,30);
				//ButtonCRUD
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				table.setBounds(500, 10, 600,240);
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			ticket_id_Ib.setFont(font);
			user_id_Ib.setFont(font);
			source_Ib.setFont(font);
			 destination_Ib.setFont(font);
			 departure_time_Ib.setFont(font);
			
			 ticket_id_txf.setFont(font);
			user_id_txf.setFont(font);
			source_txf.setFont(font);
			 destination_txf.setFont(font);
			 departure_time_txf.setFont(font);
			//Button CRUD
			Font fonti=new Font("Courier New",Font.ITALIC,12);
					
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(ticket_id_Ib);
			frame.add(user_id_Ib);
			frame.add(source_Ib);
			frame.add(destination_Ib);
			frame.add(departure_time_Ib);
			
			frame.add(ticket_id_txf);
			frame.add(user_id_txf);
			frame.add(source_txf);
			frame.add(destination_txf);
			frame.add(departure_time_txf);
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
			frame.add(table);
		}

		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			Mytickets tick=new Mytickets();
				if(e.getSource()==insert_btn) {
					
					tick.setUser_id(user_id_txf.getText());
					tick.setSource(source_txf.getText());
					tick.setDestination(destination_txf.getText());
					tick.setDeparture_time(departure_time_txf.getText());
					
					tick.insertData();
				    }
	    
				else if (e.getSource() == Read_btn) {
		        
		          model.addColumn("ticket_id");
		          model.addColumn("user_id");
		          model.addColumn("source");
		          model.addColumn("destination");
		          model.addColumn("departure_time");
		           
		            ResultSet resultSet =Mytickets.viewData();
		            if (resultSet != null) {
		                try {
		                    while (resultSet.next()) {
		                    	model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
		                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)});
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }}
	                else if (e.getSource()==update_btn) {
					int id=Integer.parseInt(ticket_id_txf.getText());
					tick.setUser_id(user_id_txf.getText());
					tick.setSource(source_txf.getText());
					tick.setDestination(destination_txf.getText());
					tick.setDeparture_time(departure_time_txf.getText());
					tick.update(id);
					}
	                else {
					int id=Integer.parseInt(ticket_id_txf.getText());
					tick.delete(id);
					}
				}
			public static void main(String[] args) {
		    ticketform tick=new ticketform();
			System.out.println(tick);

	}
			
}