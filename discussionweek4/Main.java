package discussionweek4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
    GridLayout layout = new GridLayout(4, 3);
    private JLabel interests = new JLabel("Interests");
    private JRadioButton maleGender = new JRadioButton("Male");
    private JRadioButton femaleGender = new JRadioButton("Female");
    private JCheckBox sportsCheckbox = new JCheckBox("Sports");
    private JCheckBox computersCheckbox = new JCheckBox("Computers");
    private JCheckBox sleepingCheckbox = new JCheckBox("Sleeping");
    private ButtonGroup group = new ButtonGroup();

    public Main() {
        super("Interests");
        setSize(400, 300);
        group.add(maleGender);
        group.add(femaleGender);
        add(interests);
        add(maleGender);
        add(femaleGender);
        add(sportsCheckbox);
        add(computersCheckbox);
        add(sleepingCheckbox);
        setLayout(layout);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }

    public static void main(String[] args) {
	    Main main = new Main();
	    main.setVisible(true);
    }
}
/*A combo box is a component that combines a button or an editable field and a drop-down list. The Swing class JComboBox 
creates a combo box. When a JComboBox appears on the screen, the default option is displayed in a field at the top of the box,
and the list is not displayed. When the user clicks the button on the JComboBox, a list drops down; if the user selects an item
from this list, it replaces the box’s displayed item. If the field at the top of the combo box is editable, the user also can type in it. 
The biggest advantage to using a JComboBox over displaying a series of choices with check boxes or buttons is that a combo box doesn’t take
up much room in a frame until its list is expanded. 
You can build a JComboBox by using a constructor with no arguments and then adding items (for example, Strings) to the list with the addItem() method. The following statements create a JComboBox named majorChoice that contains three options from which a user can choose:


JComboBox<String> majorChoice = new JComboBox<String>();

majorChoice.addItem("English");

majorChoice.addItem("Math");

majorChoice.addItem("Sociology");


o create a ButtonGroup in a JFrame and then add a JCheckBox, you must perform four steps:


• Create a ButtonGroup, such as ButtonGroup aGroup = new ButtonGroup();.

• Create a JCheckBox, such as JCheckBox aBox = new JCheckBox();.

• Add aBox to aGroup with aGroup.add(aBox);.

• Add aBox to the JFrame with add(aBox); or this.add(aBox);.
You can create a ButtonGroup and then create the individual JCheckBox objects, or you can create the JCheckBoxes and then create the ButtonGroup. If you create a ButtonGroup but forget to add any JCheckBox objects to it, then the JCheckBoxes act as individual, nonexclusive check boxes.
*/