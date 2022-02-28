import java.time.LocalDate;

public class Meat extends Material implements Discount{
    double weight;

    public Meat(){
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    double getCost() {
        return weight * super.getUnitCost();
    }
    @Override
    LocalDate getExpiryDate(){
        return super.manufacturingDate.plusDays(7);
    }
    @Override
    public String toString() {
        return "Meat{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
    @Override
    public double getRealCost() {
        LocalDate d = java.time.LocalDate.now();
        if (getExpiryDate().isBefore(d.plusDays(5))){
            return super.cost * 70 / 100;
        }
        else
            return super.cost * 10 / 100;
    }

}
