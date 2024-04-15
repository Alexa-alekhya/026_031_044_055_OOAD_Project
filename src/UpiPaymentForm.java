package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpiPaymentForm extends JFrame {

    public UpiPaymentForm() {
        setLayout(null);
        setBounds(600, 220, 400, 200);

        JLabel label = new JLabel("Enter UPI ID");
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setBounds(120, 20, 200, 30);
        add(label);

        JLabel upiIdLabel = new JLabel("UPI ID:");
        upiIdLabel.setBounds(50, 70, 100, 30);
        add(upiIdLabel);

        JTextField upiIdField = new JTextField();
        upiIdField.setBounds(160, 70, 200, 30);
        add(upiIdField);

        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.setBounds(120, 120, 150, 40);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to process UPI payment
                JOptionPane.showMessageDialog(null, "UPI payment successful!");
                dispose(); // Close the payment form after successful payment

                // Open the ViewTicket frame
                SwingUtilities.invokeLater(() -> {
                    new ViewTicket().setVisible(true);
                });
            }
        });
        add(confirmButton);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UpiPaymentForm().setVisible(true);
        });
    }
}
