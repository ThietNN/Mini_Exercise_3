import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount{
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public LocalDate getExpiryDate(){
        return super.manufacturingDate.plusYears(1);
    }
    @Override
    public String toString() {
        return "CrispyFlour{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
    @Override
    public double getCost(){
        return quantity * super.getUnitCost();
    }
    @Override
    public double getRealCost(){
        LocalDate d = java.time.LocalDate.now();
        if (getExpiryDate().isBefore(d.plusMonths(2)))
            return super.cost * 60 / 100;
        else if (getExpiryDate().isBefore(d.plusMonths(4)))
            return super.cost * 80 / 100;
        else
            return super.cost * 95 / 100;
    }
}
