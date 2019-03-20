package project1;

public class Salesman extends Employee {
    private static final double COMMISSION_RATE = 0.02;
    private double annualSales;

    public Salesman(String first, String last, double monthlySalary, double annualSales) {
        super(first ,last ,monthlySalary);
        this.annualSales = annualSales;
    }

    @Override
    public double getAnnualSalary() {
    //20,000 is maximum commission, if above $20,000 apply cap
        return (annualSales * COMMISSION_RATE < 20_000) ?
                annualSales * COMMISSION_RATE + super.getAnnualSalary() : 20_000 + super.getAnnualSalary();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\tAnnual Sales:  $%,.2f", annualSales);
    }
}