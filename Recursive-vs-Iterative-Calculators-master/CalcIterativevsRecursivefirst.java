package try1;

import java.awt.Container;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

//@SuppressWarnings("serial") // good idea?
public class CalcIterativevsRecursivefirst extends JFrame

{
	int calculatedEfficiency=0;
	int efficiencyTotalIterative = 0;
	int efficiencyTotalRecursive = 0;
	private JTextField fieldEnterN = new JTextField(15);

	private JTextField fieldOutput = new JTextField(15);

	private JTextField fieldEfficiency = new JTextField(15);

	private JButton buttonforCompute = new JButton("Compute");

	private JRadioButton radiobutIterative = new JRadioButton("Iterative",

			true), radiobutRecursive = new JRadioButton("Recursive", false);

	
	public CalcIterativevsRecursivefirst() {

		super("Ellwood's Recursion program");
		addWindowListener(new CloseApp());
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 280);
		//Container panelofContents = getContentPane();
		JPanel panelofContents = new JPanel();
		panelofContents.setLayout(new GridLayout(6, 2));
//Radiobutton build
		add(new JLabel(""));

		add(radiobutIterative);

		add(new JLabel(""));

		add(radiobutRecursive);//shelley hintz studentsuccess@umuc.edu

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
	//Iterative Calculation
		private int performIterativeMethod(int n)
		{
			int theNthTerm = 0;
			if (n == 0) {
				return 0;
			} else if (n == 1) {
				return 1;
			} else {
				int twicePriorTerm = 0;

				int otherPriorTerm = 1;

				for (int i = 2; i <= n; i++)
				{
					efficiencyTotalIterative++;
					theNthTerm = 2 * otherPriorTerm
							+ twicePriorTerm;
					twicePriorTerm = otherPriorTerm;
					otherPriorTerm = theNthTerm;
				}
			}
			return theNthTerm;
		}
//recursion method		

		private int performRecursionMethod(int n)
		{
			int theNthTerm;

			efficiencyTotalRecursive++;
			if (n == 0) {

				theNthTerm = 0;
			} else if (n == 1) {

				theNthTerm = 1;

			} else {

				theNthTerm = 2 * performRecursionMethod(n - 1)

						+ performRecursionMethod(n - 2);
			}
			return theNthTerm;
		}
//class for actionlistener
		private class thehandler implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				int theNthTerm;

				efficiencyTotalRecursive = 0;

				efficiencyTotalIterative = 1;

				if (radiobutIterative.isSelected()) {

					theNthTerm = performIterativeMethod(Integer

							.parseInt(fieldEnterN.getText()));

					fieldEfficiency.setText(Integer

							.toString(efficiencyTotalIterative));//Sequence.getEfficiencyTotalIterative():

				} else {

					theNthTerm = performRecursionMethod(Integer

							.parseInt(fieldEnterN.getText()));

					fieldEfficiency.setText(Integer

							.toString(efficiencyTotalRecursive));

				}

				fieldOutput.setText(Integer.toString(theNthTerm));
			}}
		/**
		*Inner class that handles the WindowClose Event*/
	
	public class CloseApp extends WindowAdapter{
		@Override
  		public void windowClosed(WindowEvent e){
			StringBuilder sb = new StringBuilder();
			
			
		System.exit(0);
		}
		}
		


		public static void main(String[] args) {

			CalcIterativevsRecursivefirst frame = new CalcIterativevsRecursivefirst();

			frame.setVisible(true);
		}
	}

