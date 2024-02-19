package Mypayment;

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
import Payment.Mypayment;

public class Paymentforms implements ActionListener {
JFrame frame;
	
	JLabel id_Ib=new JLabel("id");
	JLabel ticket_id_Ib=new JLabel("ticket_id");
	JLabel amount_Ib=new JLabel("amount");
	JLabel payment_date_Ib=new JLabel("payment_date");
	
	
	JTextField id_txf=new JTextField();
	JTextField ticket_id_txf=new JTextField();
	JTextField amount_txf=new JTextField();
	JTextField payment_date_txf=new JTextField();
	
	
	
	
	JButton insert_btn=new JButton("insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("uptade");
	JButton delete_btn=new JButton("Delete");
	
	DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
	
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int W=(int)screensize.getWidth();
	int h=(int)screensize.getHeight();
	public  Paymentforms() {
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
			frame.setTitle("PAYMENT FORM");
			frame.setBounds(0,0,W/2,h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			
			
		}
    private void setLocationSize() {
				 id_Ib.setBounds(10,10,100,30);
				 ticket_id_Ib.setBounds(10,50,100,30);
				 amount_Ib.setBounds(10,130,100,30);
				 payment_date_Ib.setBounds(10,90,100,30);
				
				
				 id_txf.setBounds(160,10,130,30);
				 ticket_id_txf.setBounds(160,50,130,30);
				 amount_txf.setBounds(160,130,130,30);
				 payment_date_txf.setBounds(160,90,130,30);
				
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
			 ticket_id_Ib.setFont(font);
			 amount_Ib.setFont(font);
			 payment_date_Ib.setFont(font);
			
			
			 id_txf.setFont(font);
			 ticket_id_txf.setFont(font);
			 amount_txf.setFont(font);
			 payment_date_txf.setFont(font);
			
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
			frame.add (ticket_id_Ib);
			frame.add(amount_Ib);
			frame.add( payment_date_Ib);
			
			
			frame.add(id_txf);
			frame.add( ticket_id_txf);
			frame.add(amount_txf);
			frame.add( payment_date_txf);
			
			//Button CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_btn);
			frame.add(delete_btn);
			frame.add(table);
			ActionEvent();
			
		}
		
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			Mypayment pay=new Mypayment();
				if(e.getSource()==insert_btn) {
					pay.setTicket_id(ticket_id_txf.getText());
					pay.setAmount(amount_txf.getText());
					pay.setPayment_date(payment_date_txf.getText());
	                pay.insertData();
				    }
	    
				else if (e.getSource() == Read_btn) {
		            model.setColumnCount(0);
		            model.setRowCount(1);
		            model.addColumn("payment_id");
		            model.addColumn("ticket_id");
		            model.addColumn("amount");
		            model.addColumn("payment_id");
		       
		           
		            ResultSet resultSet =Mypayment.viewData();
		            if (resultSet != null) {
		                try {
		                    while (resultSet.next()) {
		                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
		                                resultSet.getString(3), resultSet.getString(4)});
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
	                else if (e.getSource()==update_btn) {
					int id=Integer.parseInt(id_txf.getText());
					pay.setTicket_id(ticket_id_txf.getText());
					pay.setAmount(amount_txf.getText());
					pay.setPayment_date(payment_date_txf.getText());
					pay.update(id);
					}
	                else {
					int id=Integer.parseInt(id_txf.getText());
					pay.delete(id);
					}
				}}
			public static void main(String[] args) {
			Paymentforms pay= new Paymentforms();
			System.out.println(pay);

	}
			
}