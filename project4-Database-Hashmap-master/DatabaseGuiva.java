package project4;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class DatabaseGuiva extends JFrame {
	//A combo box should allow the user to select one of the four database actions shown
   // The operation should be performed when the user clicks the ProcessRequest button. 
	
   private String processGo;
  
   // combo box has these three inputfields
   private JTextField idTF = new JTextField();
   private JTextField nameTF = new JTextField();
   private JTextField majorTF = new JTextField();
  
   // The database should be implemented as a HashMap, with the ID field as the key and a student record consisting of a name and major as the value.
   private HashMap<Integer, Studentva> data = new HashMap<Integer, Studentva>();//first key could be a string no conversion needed
  
   // need a default constructor to call from main. In this case I decided to put it in a separate class for manageability
   public DatabaseGuiva() {
       // 1. set up a frame 2. bring in inherited info from Student database? using super("Project 4");
	   setTitle("DatabaseGUI by Steve Ellwood");
       setSize(450, 300);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       // using a method to create the JPanel features of the gui
       panelforMainScreen();
       setVisible(true);
   }   
   // panel goes on a frame. first add the required features to a jpanel
   private void panelforMainScreen() {
       // control panel elements with a gridbag
       JPanel panel = new JPanel(new GridBagLayout());
      // panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //doesn't work
      // panel.setBorder(new EmptyBorder(10, 10, 10, 10));

      //using this resource: https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
       // labels for input and combo box
       JLabel idlbl = new JLabel("ID:");
       JLabel namelbl = new JLabel("Name:");
       JLabel majorlbl = new JLabel("Major:");
       JLabel chooselbl = new JLabel("Choose Selection:");
      
       // components need to be positioned in a gridbag
       GridBagConstraints gb = new GridBagConstraints();
      
       // define and panel.add gb components
       gb.insets = new Insets(20, 25, 20, 25); //??doesnt'work
       //set up the id panel on the traditional top left
       gb.anchor = GridBagConstraints.FIRST_LINE_START;
       gb.gridx = 0;
       gb.gridy = 0;
       panel.add(idlbl, gb);
       //adding name lbl and 
       gb.gridy = 1;
       panel.add(namelbl, gb);
       //adding major lbl 
       gb.gridy = 2;
       panel.add(majorlbl, gb);
       //adding choose selection
       gb.gridy = 3;
       panel.add(chooselbl, gb);
       //add Process Request6
       gb.gridy = 4;
       panel.add(createProcessButn(), gb);
      
       gb.anchor = GridBagConstraints.LAST_LINE_END;
       gb.fill = GridBagConstraints.HORIZONTAL;
       gb.gridx = 1;
       gb.ipadx = 100;
       gb.gridy = 0;
       //add 3 text fields to appropriate grid
       panel.add(idTF, gb);
       gb.gridy = 1;
       panel.add(nameTF, gb);
       gb.gridy = 2;
       panel.add(majorTF, gb);
       //adding a combobox for selection
       gb.gridy = 3;
       //combo box needs a separate declaration, but we will do that in a method to make this clean
       panel.add(createComboBox(), gb);
       // add the panel to the frame
    
       add(panel, BorderLayout.CENTER);
   } 
  
   // create and return the process button
   private JButton createProcessButn() {
       // process button??final 
       JButton procesJB = new JButton("Process Request");
      
       // set up actionlistener on the process button
       procesJB.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               // perform the action selected, or default to insert action
               if(processGo != null) {
                   buttonAction(processGo);
               } else {
            	   buttonAction("Insert");
            	 //  JOptionPane.showMessageDialog(null,  "Please enter a valid option");
                   /*buttonAction("Insert"); use this as a default?*/
               } 
           } 
       });
       return procesJB;
   } // end addButton method
  
   //creates and returns combo box with action options
   private JComboBox createComboBox() {
       // actions
       String[] choices = { "Insert", "Delete", "Find", "Update" };
      
       // create selectioncombo box and add listener
       final JComboBox choiceBox = new JComboBox(choices); //???final means will never reassign its placae in memory
       //use final if will never referencesomet hing else or its values will never change
       choiceBox.addItemListener(new ItemListener() {
           @Override //??can I remove this
           //itemStateChanged is a premade method for comboboxes
           public void itemStateChanged(ItemEvent e) {
               // remember we need to get a string out of the transaction: convert selected option into a choice
               processGo = (String) choiceBox.getSelectedItem();
           } 
       }); 
        return choiceBox;
   }  
   // process the string selected when button is pressed, setting off a method to define elsewhere
   private void buttonAction(String processG2) {
       switch(processG2.toLowerCase()) {
           case "insert":
               insert();
               break;
           case "delete":
               delete();
               break;
           case "find":
               find();
               break;
           case "update":
               update();
               break;
           default:
               break;
       } 
   }
  
   // insert an id-Student key pair into the hashmap db
   private void insert() {
       // gather Student information from input textfields
	   //the getters are defined in further down
       Integer id = getId();
       String stname = getNameofStudent();
       String major = getMajor();
      
       // ID must be greater than 0 and an integer. If not, we 
       if(id > 0) {  //??!= -1   ??
           // add mapping only if the id doesn't exist already as a key
           if(!data.containsKey(id)) {
               // add in student with corresponding id to database
               data.put(id, new Studentva(stname, major));
              
               // show if succeeds
               JOptionPane.showMessageDialog(null,
                       "Added student: Id#" + id + "\n" +
                       data.get(id).toString(), "Id#" + id + " Added",
                       JOptionPane.INFORMATION_MESSAGE);
           } else {
               // open a message if id number (key) is already in the database
               JOptionPane.showMessageDialog(null, //need component, ojbect, string, int
                       "ID#" + id + " already exists in database.",
                       "Did not add Id:" + id,
                       JOptionPane.ERROR_MESSAGE);
           } 
       }
   } 
  
   // remove Student from the database when given corresponding id
   private void delete() {
       // gets id from input
       Integer id = getId();
        // only perform if id input can be made into a positive integer
       if(id >0) { 
           // if the id is found, then remove the student-id mapping
           if(data.containsKey(id)) {
               data.remove(id);// the student info deletes automatically???
               // successful deletion message
               JOptionPane.showMessageDialog(null,
                       "Id#" + id + " deleted from the database.",
                       "What put here2",
                       JOptionPane.INFORMATION_MESSAGE);
           } else {
               // error message: id couldn't be found
               JOptionPane.showMessageDialog(null,
                       "ID#" + id + " is not in the database.",
                       "Couldn't Delete ID#" + id,
                       JOptionPane.ERROR_MESSAGE);
           } 
       } 
   } 
  
   // shows a Student's information or error message
   private void find() {
       // get id information from input
       Integer id = getId();
      
       // only run if input can be made into a positive integer
       if(id >0) {
           // show student's information if one is associated with the id
           if(data.get(id) != null) {
               // create student to show information with toString
               Studentva student = data.get(id);
              
               // shows student's information
               JOptionPane.showMessageDialog(null,
                       "ID = " + id + "\n" + student.toString(),
                       "ID#" + id + " Found",
                       JOptionPane.INFORMATION_MESSAGE);
           } else {
               // error message if student isn't found
               JOptionPane.showMessageDialog(null,
                       "ID#" + id + " isn't in the database.",
                       "Couldn't Find ID#" + id, JOptionPane.ERROR_MESSAGE);
           } 
       } 
   } 
     // updates a student's grades
   private void update() {
       // get id from input
       Integer id = getId();
       // only act if input can be made into a positive integer
       if(id>0 ) {
           // if a student is found with the id supplied update grades
           if(data.get(id) != null) {
        	   //subcontract out the updating method after verify input ok
               updateStudent(id);
           } else {
               // error message if student can't be found to update
               JOptionPane.showMessageDialog(null,
                       "ID #" + id + " not in database.",
                       "Couldn't Update ID#" + id, JOptionPane.ERROR_MESSAGE);
           }     }    } 
  
   // action to perform a successful update
   private void updateStudent(Integer id) {
       // possible grades and credits for combo boxes
       final String[] grades = { "A", "B", "C", "D", "F" };
       final Integer[] credits = { 3, 6 };
      
       // get the Student from id supplied
       Studentva student = data.get(id);
      
       // open window to update grade, then save the grade as a string
       String updatedGrade = (String) JOptionPane.showInputDialog(
               null, "Choose grade:", "Update Grade",
               JOptionPane.QUESTION_MESSAGE, null, grades, grades[0]);
///       Prompts the user for input in a blocking dialog where theinitial selection, possible selections, 
       //and all other options canbe specified. The user will able to choose from selectionValues, where null implies theuser can 
      // inputwhatever they wish, usually by means of a JTextField. initialSelectionValue is the initial value to promptthe user with. It is up to the UI to decide how best to representthe selectionValues, but usually a JComboBox, JList, or JTextField will be used.  
       // open window to update credits, then save number of credits as int
       //Parameters:parentComponent the parent Component for thedialogmessage the Object to displaytitle the String to display in thedialog title barmessageType the
       // type of message to be displayed: ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE,or PLAIN_MESSAGEicon the Icon image to displayselectionValues an array of Objects thatgives the possible
       //selectionsinitialSelectionValue the value used to initialize the inputfieldReturns:user's input, or null meaning the usercanceled the input
       int updatedCredits = (Integer) JOptionPane.showInputDialog(
               null, "Choose Credits:", "Update Credits",
               JOptionPane.QUESTION_MESSAGE, null, credits, 
               //value used to initialize the inputfieldReturns
               credits[0]);
      
       // update the Student object with new grade and credits
       student.courseCompleted(updatedGrade, updatedCredits);
      
       // shows student's updated information
       JOptionPane.showMessageDialog(null,
               "ID = " + id + "\n" + student.toString(),
               "ID#" + id + " Updated",
               JOptionPane.INFORMATION_MESSAGE);
   } // end updateStudent method
  
   // converts id input to a positive integer,
   // or opens an error window and returns -1
   private Integer getId() {
       try {
           // tries to convert id input into an Integer ??should get the absolute value? Is there a method to convert a double to an interger??
           return Integer.parseInt(idTF.getText());
       } catch(NumberFormatException e) {
           // error message
           JOptionPane.showMessageDialog(null,
                   "Please enter a positive integer for an ID."                   );
           // return -1 to alert that an error message was displayed
           // trying to convert the id input into a positive integer
           return -1;
       } 
   } 
   // gets name input
   private String getNameofStudent() {
       return nameTF.getText();
   } 
   // gets major input
   private String getMajor() {
       return majorTF.getText();
   } 
   public static void main(String[] args) {
       new DatabaseGuiva();
   }
} 