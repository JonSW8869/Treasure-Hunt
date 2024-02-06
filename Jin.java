/*Jin class
 *
 *Turner
 *
 *This class is to be used for Keyboard Input at the Console only.
 *
 *It is a static class, designed so that an object does not need to be left
 *hanging in memory just to use the keyboard.
 *
 *
 *Give class file and documentation only.
*/

/**
 *Read information from the user through keyboard input.
 *
 *This is a simple class utilizing static methods to record input from the user
 *utilizing the command screen.
 *<p> 
 *There are <code>Jin</code> methods capable of reading <code>ints</code>, 
 *<code>doubles</code>, and <code>chars</code>, as well as <code>Strings</code>.
 *
 *<p>
 *The code
 *
 *<pre>
 *int x;
 *x = Jin.readInt("Please enter a whole number:  ");
 *</pre>
 *
 *will display the message "Please enter a whole number:  " and then wait
 *for the user to enter in a value.  If the user enters a proper integer
 *value, that information will be stored in the variable x.  If the value is
 *not a valid integer, the readInt method will loop, repeating the prompt
 *until a valid integer is entered.
 *
 *@version 	1.29, 03/01/23
 *@author	Ivan Turner
 *@since	JDK1.4
 */
import java.io.*;
public class Jin
{
	/**
     *Don't let anyone instantiate this class.
     */
    private Jin() {}

	/**
	 *Creates an input stream for data. 
	 */
	private static InputStreamReader isrdr = new InputStreamReader(System.in);
	/**
	 *Creates an input stream for data. 
	 */
	private static BufferedReader buffrdr = new BufferedReader(isrdr);

	//readInt
	//Used to read integers in from the user.
    /**
     *Prompt the user and wait for an integer to be entered.
     *
     *@param  prompt   Tells the user what kind of information to enter.
     *
     *@return A valid integer value entered by the user.
     *
     */
	public static int readInt(String prompt)
	{
		//Built-in while loop.
		//Display prompt
		do
		{
			System.out.print(prompt);
			try
			{
				//First the line is read as a string so an integer value can
				//be assessed.  Any non-integer characters will cause an Exception.
				String line = buffrdr.readLine().trim();
				int i = Integer.parseInt(line);
				return i;
			}
			catch(Exception e)
			{
				System.out.println("Not a valid integer value.");
			}
		} while(true);
		
	}
	
    /**
     *Prompt the user and wait for an integer to be entered.
     *
     *@return A valid integer value returned by readInt(String ).
     *
     */
	public static int readInt()
	{
		return readInt("");
	}
	
	//readDouble
	//Used to read doubles from the user.
	//This method is almost identical to jInt.
    /**
     *Prompt the user and wait for an double to be entered.
     *
     *@param  prompt   Tells the user what kind of information to enter.
     *
     *@return A valid double value entered by the user.
     *
     */
	public static double readDouble(String prompt)
	{
		do
		{
			//Display prompt
			System.out.print(prompt);
			try
			{
				//First the line is read as a string so a double value can
				//be assessed.  Any non-integer characters (except one dot)
				//will cause an Exception.
				String line = buffrdr.readLine().trim();
				double i = Double.parseDouble(line);
				return i;
			}
			catch(Exception e)
			{
				System.out.println("Not a valid number value.");
			}
		} while(true);
	}
	
    /**
     *Prompt the user and wait for an double to be entered.
     *
     *@return A valid double value returned by readDouble(String ).
     *
     */
	public static double readDouble()
	{
		return readDouble("");
	}
	
	//jChar
	//Used to read individual characters from the user.
    /**
     *Prompt the user and wait for an character to be entered.
     *
     *@param  prompt   Tells the user what kind of information to enter.
     *
     *@return A valid character value entered by the user.
     *
     */
	public static char readChar(String prompt)
	{
		do
		{
			//Display prompt
			System.out.print(prompt);
			try
			{
				String line = buffrdr.readLine();
				char ch[] = line.toCharArray();
				return ch[0];
			}
			catch(Exception e)
			{
				System.out.println("Not a valid character.");
			}
		} while(true);
	}
	
    /**
     *Prompt the user and wait for an character to be entered.
     *
     *@return A valid character value returned by readChar(String ).
     *
     */
	public static char readChar()
	{
		return readChar("");
	}
	
    /**
     *Prompt the user and wait for an String to be entered.
     *
     *@param  prompt   Tells the user what kind of information to enter.
     *
     *@return A valid String value entered by the user.
     *
     */
	public static String readLine(String prompt)
	{
		do
		{
			//Display prompt
			System.out.print(prompt);
			try
			{
				//Reads an entire line of text and returns it as is.
				String s = buffrdr.readLine();
				return s;
			}
			catch (Exception e)
			{
				System.out.println("Not a valid string.");
			}
		} while(true);
	}
	
    /**
     *Prompt the user and wait for an String to be entered.
     *
     *@return A valid String value entered by readLine(String ).
     *
     */
	public static String readLine()
	{
		return readLine("");
	}
	
    /**
     *Prompt the user and wait for the user to hit "Enter".
     *
     *@param  prompt   Sends the user a message in relation to the pause..
     *
     */
	public static void pause(String prompt)
	{
		//Display prompt
		System.out.print(prompt);
		try
		{
			buffrdr.read();
			buffrdr.skip(1);
		}
		catch(Exception e)
		{
		}
	}
	
    /**
     *Prompt the user and wait for Enter to be pressed.
     *
     */
	public static void pause()
	{
		pause("Press Enter to continue...");
	}

	/**
	 *Determines whether or not the response entered matches one of the expected
	 *responses.
     *
     *@param  choice	A character that was used as a response.
     *@param  responses   An array of characters detailing proper responses.
     *@return True if the choice is in the response array.
     *
     */
     public static boolean validCharacterResponse(char choice, char [] responses)
     {
     	int i;
     	for (i = 0; i < responses.length; i++)
     		if (choice == responses[i])
     			return true;
     			
     	return false;
     }

	
/*	
	public static void main(String args[])
	{
		char ch;
		ch = Jin.readChar("Enter char:  ");
		ch = Jin.readChar("Enter another char:  ");
		
	}*/
}