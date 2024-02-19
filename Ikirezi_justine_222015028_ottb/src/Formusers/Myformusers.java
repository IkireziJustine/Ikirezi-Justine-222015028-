package Formusers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Payment.Mypayment;
import Users.Myusers;



public class Myformusers implements ActionListener {
	
	JFrame frame;
	
	JLabel id_Ib=new JLabel("id");
	JLabel name_Ib=new JLabel("name");
	JLabel email_Ib=new JLabel("email");
	JLabel phone_number_Ib=new JLabel("phone_number");
	JLabel address_Ib=new JLabel("address");
	
	JTextField id_txf=new JTextField();
	JTextField name_txf=new JTextField();
	JTextField email_txf=new JTextField();
	JTextField phone_number_txf=new JTextField();
	JTextField address_txf=new JTextField();
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("uptade");
	JButton delete_btn=new JButton("Delete");
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public Myformusers() {
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
			frame.setTitle("USER FORM");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				id_Ib.setBounds(10,10,100,30);
				name_Ib.setBounds(10,50,100,30);
				email_Ib.setBounds(10,130,100,30);
				phone_number_Ib.setBounds(10,90,100,30);
				address_Ib.setBounds(10,170,100,30);
				
				id_txf.setBounds(160,10,130,30);
				name_txf.setBounds(160,50,130,30);
				email_txf.setBounds(160,130,130,30);
				phone_number_txf.setBounds(160,90,130,30);
				address_txf.setBounds(160,170,130,30);
				//ButtonCRUD
				insert_btn.setBounds(10,250,85,30);
				Read_btn.setBounds(100,250,85,30);
				update_btn.setBounds(190,250,85,30);
				delete_btn.setBounds(280,250,85,30);
				table.setBounds(500, 10, 600,240);
			}
		private void setFontforall() {
			Font font=new Font("Georgia",Font.BOLD,18);
			id_Ib.setFont(font);
			name_Ib.setFont(font);
			email_Ib.setFont(font);
			phone_number_Ib.setFont(font);
			address_Ib.setFont(font);
			
			id_txf.setFont(font);
			name_txf.setFont(font);
			email_txf.setFont(font);
			phone_number_txf.setFont(font);
			address_txf.setFont(font);
			//Button CRUD
			Font fonti=new Font("Courier New",
					Font.ITALIC,12);
			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_btn.setFont(fonti);
			delete_btn.setFont(fonti);
		}
		private void addcomponentforFrame() {
			frame.add(id_Ib);
			frame.add(name_Ib);
			frame.add(email_Ib);
			frame.add(phone_number_Ib);
			frame.add(address_Ib);
			
			frame.add(id_txf);
			frame.add(name_txf);
			frame.add(email_txf);
			frame.add(phone_number_txf);
			frame.add(address_txf);
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
			frame.add(table);
		}
              @Override
	       public void actionPerformed(ActionEvent e) {
            	  Myusers us = new Myusers();
		    
			if(e.getSource()==insert_btn) {
				us.setName(name_txf.getText());
				us.setEmail(email_txf.getText());
				us.setPhone_number(phone_number_txf.getText());
				us.setAddress(address_txf.getText());
				
			    us.insertData();
			    }
			else if (e.getSource() == Read_btn) {
	            model.setColumnCount(0);
	            model.setRowCount(1);
	            model.addColumn("user_id");
	            model.addColumn("name_id");
	            model.addColumn("email");
               model.addColumn("phone_number");
               model.addColumn("address");
	           
	            ResultSet resultSet =Myusers.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            
             else if (e.getSource()==update_btn) {
				int id=Integer.parseInt(id_txf.getText());
				us.setName(name_txf.getText());
				us.setEmail(email_txf.getText());
				us.setPhone_number(phone_number_txf.getText());
				us.setAddress(address_txf.getText());
				us.update(id);
				}}
             else {
				int id=Integer.parseInt(id_txf.getText());
				us.delete(id);
				}}

       
		public static void main(String[]args){
	    Myformusers   us= new  Myformusers();
		System.out.println( us);

}
		}

