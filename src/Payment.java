package travel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Payment extends JFrame {

    private static Payment instance;

    private Payment() {
        setLayout(null);
        setBounds(600, 220, 800, 600);

        JLabel label = new JLabel("Select Payment Method");
        label.setFont(new Font("Raleway", Font.BOLD, 40));
        label.setBounds(50, 20, 600, 45);
        add(label);

        JButton creditCardButton = new JButton("Credit Card");
        creditCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processPayment("credit");
            }
        });
        creditCardButton.setBounds(150, 100, 150, 40);
        add(creditCardButton);

        JButton debitCardButton = new JButton("Debit Card");
        debitCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processPayment("debit");
            }
        });
        debitCardButton.setBounds(350, 100, 150, 40);
        add(debitCardButton);

        JButton upiButton = new JButton("UPI");
        upiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processPayment("upi");
            }
        });
        upiButton.setBounds(550, 100, 150, 40);
        add(upiButton);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static Payment getInstance() {
        if (instance == null) {
            instance = new Payment();
        }
        return instance;
    }

    private void processPayment(String methodType) {
        // Open a new window for entering payment details based on the selected method
        switch (methodType.toLowerCase()) {
            case "credit":
                new CreditCardPaymentForm().setVisible(true);
                break;
            case "debit":
                new DebitCardPaymentForm().setVisible(true);
                break;
            case "upi":
                new UpiPaymentForm().setVisible(true);
                break;
            default:
                // Handle unsupported payment method
                JOptionPane.showMessageDialog(this, "Unsupported payment method: " + methodType);
        }
    }

    public static void main(String[] args) {
        Payment.getInstance().setVisible(true);
    }
}


