package tms.demo.model;

// Concrete implementation of Payment for UPI transactions
public class UpiTransaction implements Payment {
    private Long id; // Assuming payment ID is stored in the UpiTransaction class
    private String upiId;

    public UpiTransaction(Long id, String upiId) {
        this.id = id;
        this.upiId = upiId;
    }
    @Override
    public Payment clone() {
        return new UpiTransaction(this.id, this.upiId);
    }
    @Override
    public void processPayment() {
        System.out.println("Processing UPI transaction...");
    }
    @Override
    public Long getId() {
        return id;
    }
}
