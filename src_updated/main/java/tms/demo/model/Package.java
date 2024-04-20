package tms.demo.model;

public class Package {

    private Long id;
    private String packageName;
    private double price;
    // Other package attributes

    // Constructors
    // public Package() {
    // }

    public Package(Long id, String packageName, double price) {
        this.id = id;
        this.packageName = packageName;
        this.price = price;
        // Set other attributes
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
