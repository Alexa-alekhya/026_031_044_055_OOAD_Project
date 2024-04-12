package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCardPaymentForm extends JFrame {

    public CreditCardPaymentForm() {
        setLayout(null);
        setBounds(600, 220, 400, 300);

        JLabel label = new JLabel("Enter Credit Card Details");
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setBounds(50, 20, 300, 30);
        add(label);

        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(50, 70, 100, 30);
        add(cardNumberLabel);

        JTextField cardNumberField = new JTextField();
        cardNumberField.setBounds(160, 70, 200, 30);
        add(cardNumberField);

        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateLabel.setBounds(50, 120, 100, 30);
        add(expiryDateLabel);

        JTextField expiryDateField = new JTextField();
        expiryDateField.setBounds(160, 120, 200, 30);
        add(expiryDateField);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(50, 170, 100, 30);
        add(cvvLabel);

        JPasswordField cvvField = new JPasswordField();
        cvvField.setBounds(160, 170, 200, 30);
        add(cvvField);

        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(120, 220, 150, 40);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to process credit card payment
                JOptionPane.showMessageDialog(null, "Credit card payment successful!");
                dispose(); // Close the payment form after successful payment
            }
        });
        add(confirmButton);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CreditCardPaymentForm().setVisible(true);
        });
    }
}
