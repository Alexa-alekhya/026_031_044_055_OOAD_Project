package tms.demo.model;

// Concrete implementation of Payment for Debit card payments
public class DebitCardPayment implements Payment {
    private Long id; // Assuming payment ID is stored in the DebitCardPayment class
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    // Constructor
    public DebitCardPayment(Long id, String cardNumber, String expiryDate, String cvv) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }
    @Override
    public Payment clone() {
        return new DebitCardPayment(this.id, this.cardNumber, this.expiryDate, this.cvv);
    }
    @Override
    public void processPayment() {
        System.out.println("Processing Debit card payment...");
    }
    @Override
    public Long getId() {
        return id;
    }
}
