package discussionweek4;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
public class AboutYou extends JPanel {
private JLabel label, label2,label3 ;
private JRadioButton rButton, rButton2;
private JCheckBox cBox,cBox2, cBox3, cBox4;
private ButtonGroup group;
public AboutYou() {
label = new JLabel("Gender");
label2 = new JLabel("Hobbies");
label3 = new JLabel("                        ");
rButton = new JRadioButton("Male");
rButton2 = new JRadioButton("Female");
cBox = new JCheckBox("Art");
cBox2 = new JCheckBox("Sports");
cBox3 = new JCheckBox("Writing");
cBox4 = new JCheckBox("Chess");
group = new ButtonGroup();
group.add(rButton);
group.add(rButton2);
add(label);
add(rButton);
add(rButton2);
add(label3);
add(label2);
add(cBox);
add(cBox2);
add(cBox3);
add(cBox4);
setBackground(Color.LIGHT_GRAY);
setPreferredSize(new Dimension(300,300));
}
public static void main(String[] args) {
JFrame frame = new JFrame("About You");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
AboutYou panel = new AboutYou();
frame.getContentPane().add(panel);
frame.pack();
frame.setVisible(true);
}
}