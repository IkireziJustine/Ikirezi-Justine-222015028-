package Mymenu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import Mypayment.Paymentforms;
import Myroutes.Routesform;
import Mytickets.ticketform;
import Myvehicles.Vehiclesform;
import Users.Myusers;




	public class menu extends JFrame implements ActionListener {
	    private JMenuBar menuBar;
	    private JMenu homeMenu;
	    private JMenuItem MyusersItem;
	    private JMenuItem PaymentItem;
	    private JMenuItem  RoutesItem;
	    private JMenuItem ticketItem;
	    private JMenuItem VehiclesItem;
	    private JMenuItem settingsItem;
	    private JMenuItem logoutItem;
	    private String loggedInUser;

	    public menu(String username) {
	        this.loggedInUser = username;
	        setTitle("Dashboard");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Create menu bar
	        menuBar = new JMenuBar();

	        // Create home menu
	        homeMenu = new JMenu("Home");

	        // Create menu items
	        MyusersItem = new JMenuItem(" Myusers");
	        MyusersItem.addActionListener(this);
	        PaymentItem = new JMenuItem("Payment");
	        PaymentItem.addActionListener(this);
	        RoutesItem = new JMenuItem("Routes");
	        RoutesItem.addActionListener(this);
	        ticketItem = new JMenuItem("ticket");
	        ticketItem.addActionListener(this);
	        VehiclesItem = new JMenuItem("Vehicles");
	        VehiclesItem.addActionListener(this);
	        settingsItem = new JMenuItem("Settings");
	        settingsItem.addActionListener(this);
	        logoutItem = new JMenuItem("Logout");
	        logoutItem.addActionListener(this);

	        // Add menu items to home menu
	        homeMenu.add(MyusersItem);
	        homeMenu.add(PaymentItem);
	        homeMenu.add(RoutesItem);
	        homeMenu.add(ticketItem);
	        homeMenu.add(VehiclesItem);
	        homeMenu.add(settingsItem);
	        homeMenu.addSeparator();
	        homeMenu.add(logoutItem);

	        // Add home menu to menu bar
	        menuBar.add(homeMenu);

	        // Set menu bar to frame
	        setJMenuBar(menuBar);

	        // Initialize dashboard panel
	        JPanel dashboardPanel = new JPanel();
	        dashboardPanel.setLayout(new BorderLayout());

	        // Add components to dashboard panel
	        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Dashboard");
	        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
	        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

	        // Add dashboard panel to frame
	        add(dashboardPanel);

	        setVisible(true);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == MyusersItem) {
	            JOptionPane.showMessageDialog(this, "Myusers Form...");
	            new Myusers();
	        } else if (e.getSource() ==PaymentItem) {
	            JOptionPane.showMessageDialog(this, "Payment Form...");
	            new Paymentforms();
	        } else if (e.getSource() == RoutesItem) {
	            JOptionPane.showMessageDialog(this, "Routes Form...");
	            new Routesform();
	        } else if (e.getSource() == ticketItem) {
	            JOptionPane.showMessageDialog(this, "ticket Form...");
	            new ticketform();
	        } else if (e.getSource() == VehiclesItem) {
	            JOptionPane.showMessageDialog(this, "Vehicles Form...");
	            new Vehiclesform();
	        } else if (e.getSource() == settingsItem) {
	            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
	            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
	            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
	        } else if (e.getSource() == logoutItem) {
	            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
	            if (choice == JOptionPane.YES_OPTION) {
	                dispose();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new menu("online_transport_ticket_booking"));
	    }
	}

