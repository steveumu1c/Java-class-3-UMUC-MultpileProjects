package project4;

import java.text.DecimalFormat;

public class Studentva {
   // name and major variable created for each Student
   private String name;
   private String major;
  
   // doubles to calculate gpa
   private double credits;
   private double points;
  
   // default constructor
   public Studentva() {
       name = "Name";
       major = "Major";
       credits = 0;
       points = 0;
   } // end default constructor
  
   // constructor which takes in a name and major, sets credits and points to 0
   public Studentva(String name, String major) {
       this.name = name;
       this.major = major;
       credits = 0;
       points = 0;
   } // end name and major constructor
  
   // called with update action in StudentGUI, updates gpa
   public void courseCompleted(String grade, int hours) {
       credits += hours;
      
       switch(grade.toLowerCase().charAt(0)) {
           case 'a':
               points += 4 * hours;
               break;
           case 'b':
               points += 3 * hours;
               break;
           case 'c':
               points += 2 * hours;
               break;
           case 'd':
               points += hours;
               break;
           default:
               break;
       } // end switch
   } // end courseCompleted method
  
   // returns Student's information
   @Override  
   public String toString() {
       // format gpa to two decimal places in calculation
       DecimalFormat formatter = new DecimalFormat("#0.00");
       // default gpa if student's class information hasn't been updated yet
       String gpa = "4.0";
      
       // calculate gpa if more than 0 credits, format
       if(credits > 0) {
           gpa = formatter.format(points / credits);
       }
      
       // string to return
       String studentInfo = "Name: " + name +
               "\nMajor: " + major + "\nGPA: " + gpa;
       // returns student's information as a String
       return studentInfo;
   } // end toString method
} // end class