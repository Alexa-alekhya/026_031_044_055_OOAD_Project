/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;

import java.sql.*;

import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;


public class ViewTicket extends Frame implements ActionListener {

    Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    Button b1, b2;
    Frame f;

    public ViewTicket() {

        f = new Frame("Travel Management System - View Tickets");
        f.setVisible(true);
        f.setSize(410, 600);
        f.setLocation(440, 20);
        f.setLayout(null);

        l1 = new Label("Username");
        l1.setBounds(50, 50, 150, 30);
        f.add(l1);
        t1 = new TextField();
        t1.setBounds(220, 50, 150, 30);
        f.add(t1);

        l2 = new Label("Package");
        l2.setBounds(50, 90, 150, 30);
        f.add(l2);
        t2 = new TextField();
        t2.setBounds(220, 90, 150, 30);
        f.add(t2);

        l3 = new Label("Persons");
        l3.setBounds(50, 130, 150, 30);
        f.add(l3);
        t3 = new TextField();
        t3.setBounds(220, 130, 150, 30);
        f.add(t3);

        l4 = new Label("ID");
        l4.setBounds(50, 170, 150, 30);
        f.add(l4);
        t4 = new TextField();
        t4.setBounds(220, 170, 150, 30);
        f.add(t4);

        l5 = new Label("Number");
        l5.setBounds(50, 210, 150, 30);
        f.add(l5);
        t5 = new TextField();
        t5.setBounds(220, 210, 150, 30);
        f.add(t5);

        l6 = new Label("Phone");
        l6.setBounds(50, 250, 150, 30);
        f.add(l6);
        t6 = new TextField();
        t6.setBounds(220, 250, 150, 30);
        f.add(t6);

        l7 = new Label("Price");
        l7.setBounds(50, 290, 150, 30);
        f.add(l7);
        t7 = new TextField();
        t7.setBounds(220, 290, 150, 30);
        f.add(t7);

        l8 = new Label("Hotel Name");
        l8.setBounds(50, 330, 150, 30);
        f.add(l8);
        t8 = new TextField();
        t8.setBounds(220, 330, 150, 30);
        f.add(t8);

        l9 = new Label("Days");
        l9.setBounds(50, 370, 150, 30);
        f.add(l9);
        t9 = new TextField();
        t9.setBounds(220, 370, 150, 30);
        f.add(t9);

        l10 = new Label("AC");
        l10.setBounds(50, 410, 150, 30);
        f.add(l10);
        t10 = new TextField();
        t10.setBounds(220, 410, 150, 30);
        f.add(t10);

        l11 = new Label("Food");
        l11.setBounds(50, 450, 150, 30);
        f.add(l11);
        t11 = new TextField();
        t11.setBounds(220, 450, 150, 30);
        f.add(t11);

        l12 = new Label("Cost");
        l12.setBounds(50, 490, 150, 30);
        f.add(l12);
        t12 = new TextField();
        t12.setBounds(220, 490, 150, 30);
        f.add(t12);

        b1 = new Button("Fetch Ticket Details");
        b1.setBounds(120, 530, 150, 30);
        f.add(b1);
        b1.addActionListener(this);

        b2 = new Button("Close");
        b2.setBounds(140, 570, 100, 30);
        f.add(b2);
        b2.addActionListener(this);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                String username = t1.getText().trim();
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username!");
                    return;
                }
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/tms", "root", "1234");

                // Fetching booked package details
                Statement stmt = con.createStatement();
                ResultSet rsPackage = stmt.executeQuery("select * from bookPackage where username='" + username + "'");
                if (rsPackage.next()) {
                    t2.setText(rsPackage.getString(2)); // Package
                    t3.setText(rsPackage.getString(3)); // Persons
                    t4.setText(rsPackage.getString(4)); // ID
                    t5.setText(rsPackage.getString(5)); // Number
                    t6.setText(rsPackage.getString(6)); // Phone
                    t7.setText(rsPackage.getString(7)); // Price
                } else {
                    JOptionPane.showMessageDialog(null, "No package booking found for the given username!");
                }

                // Fetching booked hotel details
                ResultSet rsHotel = stmt.executeQuery("select * from bookHotel where username='" + username + "'");
                if (rsHotel.next()) {
                    t8.setText(rsHotel.getString(2)); // Hotel Name
                    t9.setText(rsHotel.getString(4)); // Days
                    t10.setText(rsHotel.getString(5)); // AC
                    t11.setText(rsHotel.getString(6)); // Food
                    t12.setText(rsHotel.getString(10)); // Cost
                } else {
                    JOptionPane.showMessageDialog(null, "No hotel booking found for the given username!");
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == b2) {
            f.setVisible(false);
        }
    }

    public static void main(String args[]) {
        new ViewTicket();
    }
}
