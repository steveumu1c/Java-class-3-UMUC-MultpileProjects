package discussionweek4;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class DriveThrough {

     public static void main(String[] args) {

          JFrame f = new JFrame("Lister v1.0");

          f.setSize(300, 150);

          f.setLocation(200, 200);

          f.addWindowListener(new WindowAdapter( ) {

          public void windowClosing(WindowEvent we) { System.exit(0); }

          });

          JPanel entreePanel = new JPanel( );

          final ButtonGroup entreeGroup = new ButtonGroup( );

          JRadioButton radioButton;

          entreePanel.add(radioButton = new JRadioButton("Beef"));

          radioButton.setActionCommand("Beef");

          entreeGroup.add(radioButton);

          entreePanel.add(radioButton = new JRadioButton("Chicken"));

          radioButton.setActionCommand("Chicken");

          entreeGroup.add(radioButton);

          entreePanel.add(radioButton = new JRadioButton("Veggie", true));

          radioButton.setActionCommand("Veggie");

          entreeGroup.add(radioButton);

          final JPanel condimentsPanel = new JPanel( );

          condimentsPanel.add(new JCheckBox("Ketchup"));

          condimentsPanel.add(new JCheckBox("Mustard"));

          condimentsPanel.add(new JCheckBox("Pickles"));

           

          JPanel orderPanel = new JPanel( );

          JButton orderButton = new JButton("Place Order");

          orderPanel.add(orderButton);

           

          Container content = f.getContentPane( );

          content.setLayout(new GridLayout(3, 1));

          content.add(entreePanel);

          content.add(condimentsPanel);

          content.add(orderPanel);

           

          orderButton.addActionListener(new ActionListener( ) {

          public void actionPerformed(ActionEvent ae) {

          String entree =

          entreeGroup.getSelection().getActionCommand( );

          System.out.println(entree + " sandwich");

          Component[] components = condimentsPanel.getComponents( );

          for (int i = 0; i < components.length; i++) {

          JCheckBox cb = (JCheckBox)components[i];

          if (cb.isSelected( ))

          System.out.println("With " + cb.getText( ));

          }

          }

          });

           

          f.setVisible(true);

          }

          }