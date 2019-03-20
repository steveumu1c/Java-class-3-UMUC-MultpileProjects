package project1;

import java.util.Comparator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
public class SalaryDriver {
    private static final String fileName = "Salaries.txt";
//    private List<Employee> employeeList2014 = new ArrayList<>();
//    private List<Employee> employeeList2015 = new ArrayList<>();
    private List<Pairalt<Integer,Employee>> employeeMap = new ArrayList<>();

    public static void main(String[] args) {
        SalaryDriver implementMain = new SalaryDriver();
        implementMain.processInput();
//        implementMain.printReport(2014, implementMain.employeeList2014);
//        implementMain.printReport(2015, implementMain.employeeList2015);

        System.out.println("Test Alternative");
        implementMain.printReportYear(2014);
        implementMain.printReportYear(2015);
        implementMain.printReportYear(2013);
    }

    private void processInput() {//read in file

        try (Scanner scanner = new Scanner(new File(fileName))) { //try w/ resources closes automatically
            // OR could use //BufferedReader br = new BufferedReader(new FileReader(fileName)
            while (scanner.hasNext()) {
                Employee tempEmployee = null;

                int year = scanner.nextInt();
                String type = scanner.next();
                String lName = scanner.next();
                String fName = scanner.next();
                double pay = scanner.nextDouble();
                double extraInfo = (type.equals("Employee")) ? 0 : scanner.nextDouble();

                if ("Employee".equals(type)) {
                    tempEmployee = new Employee(fName, lName, pay);
                }
                else if ("Executive".equals(type)) {
                    tempEmployee = new Executive(fName, lName, pay, extraInfo);
                }
                else if ("Salesman".equals(type)) {
                    tempEmployee = new Salesman(fName, lName, pay, extraInfo);
                }
//
//                if (year == 2014) {
//                    employeeList2014.add(tempEmployee);
//                }
//                else if (year == 2015){
//                    employeeList2015.add(tempEmployee);
//                }

                //Alternate to employeeListYEAR . just throw them in a list and sort it out later
                employeeMap.add(new Pairalt<>(year,tempEmployee));
            }// End While loop
        }
        catch(FileNotFoundException | InputMismatchException e){
            System.out.println("File error found: " + e);
            System.exit(1);
        }
    }

    private void printReportYear(int year) {
        List<Employee> list2 = employeeMap
                .stream()
                .filter( e -> e.getKey() == year)
                .map(Pairalt::getValue)
                .collect(Collectors.toList());
        printReport(year,list2);
    }

    private void printReport(int year, List<Employee> list) {
        double payroll = list.stream().mapToDouble(Employee::getAnnualSalary).sum();

        //Print list of employees
        System.out.printf("\n******%s Payroll Report******\n",year);

//the same but bottom is the lambda top is a method reference. 
       list.stream().sorted(Comparator.comparing(Employee::getLastName)).forEachOrdered(System.out::println);
        //list.stream().sorted(Comparator.comparing(employee -> employee.getLastName())).forEachOrdered(x -> System.out.println(x));

        //Display annual payroll stats
        System.out.println(String.format("Summary for %s:",year));
        System.out.printf("\tTotal annual payroll: $%,.0f%n",payroll);
        System.out.printf("\tAverage annual payroll: $%,.0f%n",payroll/list.size());
    }
}
