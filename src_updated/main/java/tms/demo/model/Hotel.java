package tms.demo.model;

public class Hotel {
    private String name;
    private String costPerDay;
    private String foodCharges;
    private String acCharges;

    public Hotel(String name, String costPerDay, String foodCharges, String acCharges) {
        this.name = name;
        this.costPerDay = costPerDay;
        this.foodCharges = foodCharges;
        this.acCharges = acCharges;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(String costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getFoodCharges() {
        return foodCharges;
    }

    public void setFoodCharges(String foodCharges) {
        this.foodCharges = foodCharges;
    }

    public String getAcCharges() {
        return acCharges;
    }

    public void setAcCharges(String acCharges) {
        this.acCharges = acCharges;
    }
}
