package project1;

public class Executive extends Employee {
    private double stockPrice;
    private static final int BONUS = 30_000;

    //constructor
    public Executive(String first, String last, double monthlySalary, double stockPrice) {
        super(first, last, monthlySalary);
        this.stockPrice = stockPrice;
    }

    @Override
    public double getAnnualSalary() {
        //if price-per-stock is > $50, apply yearly bonus
        return (stockPrice > 50) ? getMonthlySalary() * 12 + BONUS : getMonthlySalary() * 12;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\tStock Price: $%.2f",stockPrice);
    }
}// End Class