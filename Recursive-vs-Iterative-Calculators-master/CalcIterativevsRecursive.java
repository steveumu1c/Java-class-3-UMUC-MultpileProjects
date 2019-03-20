package try1;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class CalcIterativevsRecursive extends JFrame {

    private JTextField fieldEnterN = new JTextField(10);

    private JTextField fieldOutput = new JTextField(10);

    private JTextField fieldEfficiency = new JTextField(10);

    private JButton buttonforCompute = new JButton("Compute");

    private JRadioButton radiobutIterative = new JRadioButton("Iterative",

            true), radiobutRecursive = new JRadioButton("Recursive", false);


    public CalcIterativevsRecursive() {

        super("Ellwood's Recursion Program");

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new CloseApp());
// ANONYMOUS INNER CLASS**********
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                //process effc output file
//                StringBuilder sb = new StringBuilder();
//                //header
//                sb.append("Value, Iterative Efficiency, Recursive Efficiency\n");
//
//                for (int i = 0; i < 11; i++) {
//                    sb.append(String.valueOf(Sequence.performIterativeMethod(i))).append(",");
//                    sb.append(String.valueOf(Sequence.getEfficiencyTotalIterative())).append(",");
//                    Sequence.performRecursive(i); // already got value via iterative
//                    sb.append(String.valueOf(Sequence.getEfficiencyTotalRecursive())).append("\n");
//                }
//
//                try(BufferedWriter br = new BufferedWriter(new FileWriter("Results.txt"))) {
//                    br.write(sb.toString());
//                } catch (IOException ex) {
//                    JOptionPane.showMessageDialog(null,"Error writing file");
//                    System.exit(1);
//                }
//            }
//        });
// ************************

        setSize(375, 275);
        //JPanel panelContents = new JPanel();
        Container containerContents = getContentPane();
        //panelContents.setLayout(new FlowLayout());
        containerContents.setLayout(new GridLayout(6, 2));
//Radiobutton build
      //  add(new JLabel(""));

        add(radiobutIterative);

        //add(new JLabel(""));

        add(radiobutRecursive);
       
        ButtonGroup buttongroup = new ButtonGroup();

        buttongroup.add(radiobutIterative);

        buttongroup.add(radiobutRecursive);
//Field build
        add(new JLabel("Enter n: "));
        add(fieldEnterN);
        add(new JLabel(""));
        add(buttonforCompute);
        add(new JLabel("Result: "));
        add(fieldOutput);
        add(new JLabel("Efficiency: "));
        add(fieldEfficiency);
//Pull in handling for presses from private class below
        thehandler handler = new thehandler();
        buttonforCompute.addActionListener(handler);
    }


    //class for actionlistener
    private class thehandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            int theNthTerm;

            if (radiobutIterative.isSelected()) {

                theNthTerm = Sequence.performIterativeMethod(Integer.parseInt(fieldEnterN.getText()));


                fieldEfficiency.setText(Integer.toString(Sequence.getEfficiencyTotalIterative()));

            } else {

                theNthTerm = Sequence.performRecursive(Integer.parseInt(fieldEnterN.getText()));

                fieldEfficiency.setText(Integer.toString(Sequence.getEfficiencyTotalRecursive()));
            }

            fieldOutput.setText(Integer.toString(theNthTerm));
        }
    }


    public static void main(String[] args) {

        CalcIterativevsRecursive frame = new CalcIterativevsRecursive();

        frame.setVisible(true);
    }

    public class CloseApp extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent event) {
            StringBuilder sb = new StringBuilder();
            //header
            sb.append("Value, Iterative Efficiency, Recursive Efficiency\n");

            for (int i = 0; i < 11; i++) {
            	sb.append(i).append(",");
                Sequence.performIterativeMethod(i);
                sb.append(String.valueOf(Sequence.getEfficiencyTotalIterative())).append(",");
               Sequence.performRecursive(i); // already got value via iterative
               sb.append(String.valueOf(Sequence.getEfficiencyTotalRecursive())).append("\n");
                //sb.append(i).append("\n");
            }

            try(BufferedWriter br = new BufferedWriter(new FileWriter("Results.txt"))) {
                br.write(sb.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Error writing file");
                System.out.println("Eror writing file");
                System.exit(1);
                e.printStackTrace();
            }
        }
    }

}
