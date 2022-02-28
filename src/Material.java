import java.time.LocalDate;

public abstract class Material {
    String id, name;
    LocalDate manufacturingDate;
    double cost;

    // Constructor
    public Material(){
    }
    public Material(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }

    // Getter
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }
    public double getUnitCost() {
        return cost;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    // Function
    abstract double getRealCost();
    abstract double getCost();
    abstract LocalDate getExpiryDate();
}
