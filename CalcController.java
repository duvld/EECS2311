import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;


public class CalcController implements ActionListener
{
	/**
	 * String for sum command.
	 */
	public static final String SUM = "SUM";
	
	/**
	 * String for subtract command.
	 */
	public static final String SUBTRACT = "SUBTRACT";
	
	/**
	 * String for multiply command.
	 */
	public static final String MULTIPLY = "MULTIPLY";
	
	/**
	 * String for divide command.
	 */
	public static final String DIVIDE = "DIVIDE";
	
	/**
	 * String for clear command.
	 */
	public static final String CLEAR = "CLEAR";
	
	private CalcModel model;
	private CalcView view;

	/**
	 * Creates a controller for the given view and model.
	 * 
	 * @param view
	 *            The view.
	 * @pre. view != null
	 * @param theModel
	 *            The model the controllgeter uses
	 * @pre. model != null
	 */
	public CalcController()
	{
		model = new CalcModel();
		view = new CalcView(this);
        view.setVisible(true);
		model.clear();
	}

	  /**
	   * Invoked when an event occurs.
	   * 
	   * @param event
	   *            The event.
	   */
	  public void actionPerformed(ActionEvent event)
	  {
	    // Translates an event into something that the model can do.
	    String action = event.getActionCommand();

	    if(action.equals(CalcController.CLEAR))
	    {
	      model.clear();
	    }
	    else
	    {
	      BigInteger userValue = null;
	      try
	      {
	        userValue = new BigInteger(view.getUserValue());
	      }
	      catch(NumberFormatException ex)
	      {
	        return;
	      }

	      if(action.equals(CalcController.SUM))
	      {
	        model.sum(userValue);
	      }
	      else if(action.equals(CalcController.SUBTRACT))
	      {
	        model.subtract(userValue);
	      }
	      else if(action.equals(CalcController.MULTIPLY))
	      {
	        model.multiply(userValue);
	      }
	      else if(action.equals(CalcController.DIVIDE))
	      {
	        if(!userValue.equals(BigInteger.ZERO))
	        {
	          model.divide(userValue);
	        }
	      }
	    }
	    BigInteger calcValue = model.getCalcValue();
	    view.setCalcValue(calcValue.toString());
	  }
	  
}
