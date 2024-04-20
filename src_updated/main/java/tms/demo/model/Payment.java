package tms.demo.model;

// Payment interface
public interface Payment {
    Payment clone(); // Cloning method

    void processPayment(); // Method to process the payment

    Long getId();
}
