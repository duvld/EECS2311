import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class CalcView extends JFrame
{
	private static final long serialVersionUID = -8730447125113729547L;
	
	private JTextField userValueText;
	private JTextField calcText;
	private JButton sumButton;
	private JButton subtractButton;
	private JButton multiplyButton;
	private JButton divideButton;	
	private JButton clearButton;
	
	public CalcView(CalcController theController)
	{
		super("Simple Calculator");
		CalcController controller = theController;
		
		userValueText = new JTextField(5);
		
		calcText = new JTextField(20);
		calcText.setEditable(false);
		
		sumButton = new JButton("Add");
		setCommand(sumButton, CalcController.SUM, controller);
		
		subtractButton = new JButton("Subtract");
		setCommand(subtractButton, CalcController.SUBTRACT, controller);
		
		multiplyButton = new JButton("Multiply");
		setCommand(multiplyButton, CalcController.MULTIPLY, controller);
		
		divideButton = new JButton("Divide");
		setCommand(divideButton, CalcController.DIVIDE, controller);
		
		clearButton = new JButton("Clear");
		setCommand(clearButton, CalcController.CLEAR, controller);
		
		
		setLayout(new FlowLayout());
		add(new JLabel("Calculated Value"));
		add(calcText);
		add(new JLabel("Input"));
		add(userValueText);
		add(sumButton);
		add(subtractButton);
		add(multiplyButton);
		add(divideButton);
		add(clearButton);
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Get the string value of the user input text field.
	 * 
	 * @return The string in the user input text field.
	 */
	public String getUserValue()
	{
		return userValueText.getText();
	}
	
	/**
	 * Set the string for the user input text field.
	 * 
	 * @param value The new value for the user input text field.
	 * @pre. value is not null
	 */
	public void setUserValue(String value)
	{
		userValueText.setText(value);
	}
	
	/**
	 * Set the string for the calculated value text field.
	 * 
	 * @param value The new value for the calculated value text field.
	 * @pre. value is not null
	 */
	public void setCalcValue(String value)
	{
		calcText.setText(value);
	}
	
	/**
	 * Sets the action listener and command for a button or menu item.
	 * 
	 * @param button
	 *            A button or menu item.
	 * @param commandName
	 *            The name of the command that the button invokes.
	 * @param actionListener
	 *            The receiver of the action event.
	 */
	private void setCommand(AbstractButton button, String commandName,
			ActionListener actionListener)
	{
		button.addActionListener(actionListener);
		button.setActionCommand(commandName);
	}
}
