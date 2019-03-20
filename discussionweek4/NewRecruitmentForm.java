package discussionweek4;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class NewRecruitmentForm extends JPanel {
	//GridLayout layout = new GridLayout(4, 3); FlowLayout is default for JFrame
	private JLabel formatter,formatter2,questionUnoLabel, questionOneLabel,questionTwoLabel,questionThreeLabel;
	private JRadioButton questionUnoYes,questionUnoNo; 
	private JCheckBox questionOneFemale,questionOneMale,questionOneInter,questionOneDec;
	private ButtonGroup bgroup = new ButtonGroup();
	//Munoz: You can build a JComboBox by using a constructor with no arguments and then adding items (for example, Strings) to the list with the addItem() method. The following statements create a JComboBox named majorChoice that contains three options from which a user can choose:
	private static JComboBox<String> genderChoiceBox;
	private ArrayList<String> genders;//will feed these into the combobox list

	public NewRecruitmentForm() {
		genderChoiceBox = new JComboBox<String>();
		genders = new ArrayList<String>();
		genders.add("TransFemale/TransWoman");
		genders.add("TransMale/TransMan");
		genders.add("Genderqueer/Gender nonconforming");
		genders.add("Something else");
		genders.add("Female/Woman");
		genders.add("Male/Man");
		genders.add("Decline to Answer");
		// Jframe can be set here or in main
		formatter= new JLabel("            ");
		formatter2= new JLabel("                                                              ");
		questionUnoLabel = new JLabel("Are you really willing to read this survey?");
		// Use radio buttons for logical or options
		questionUnoYes = new JRadioButton("Yes");
		questionUnoNo = new JRadioButton("No");
		// Use checkboxes when can select more than one
		questionOneLabel = new JLabel("What gender was assigned to you at birth? ");
		questionOneMale = new JCheckBox("Male");
		questionOneFemale = new JCheckBox("Female");
		questionOneInter = new JCheckBox("Intersex");
		questionOneDec = new JCheckBox("Decline to Answer");
		// https://uxdesign.cc/designing-forms-for-gender-diversity-and-inclusion-d8194cf1f51
		questionTwoLabel = new JLabel("What is your gender identity?");
		// pair the radiobuttons logically with a button group
		bgroup = new ButtonGroup();
		bgroup.add(questionUnoYes);
		bgroup.add(questionUnoNo);
		// adding these directly to the frame, no panel needed
		add(questionUnoLabel);
		add(formatter);
		add(questionUnoYes);
		add(questionUnoNo);
		add(questionOneLabel);
		add(questionOneFemale);
		add(questionOneInter);
		add(questionOneMale);
		add(questionOneDec);
		add(formatter2);
		add(questionTwoLabel);
		//adding a dropdown box to the frame
		setBox(genders);
		add(genderChoiceBox);
	}
	public static void setBox(ArrayList<String> genders) {
		for (int i = 0; i < genders.size(); i++) {
			genderChoiceBox.addItem(genders.get(i));
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("New Era Recruitment Form");
		frame.setSize(310, 350);
		frame.setLocation(400, 400);
		NewRecruitmentForm nrf = new NewRecruitmentForm();
		//nrf.setColor(color.PINK); can't add a color to a frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(nrf);
		//frame.pack();
		frame.setVisible(true);
	}
}