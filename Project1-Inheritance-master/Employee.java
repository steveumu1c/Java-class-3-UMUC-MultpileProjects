package project1;

public class Employee {

    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee( String first, String last, double moSalary) {
        firstName = first;
        lastName = last;
        monthlySalary = moSalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public String getLastName() {
        return this.lastName;
    }

    public double getAnnualSalary() {
        return monthlySalary * 12;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s \t$%,.2f",lastName,firstName,monthlySalary);
    }
} //End Class