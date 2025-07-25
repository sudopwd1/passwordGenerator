import javax.swing.JOptionPane;
import java.util.Random;

public class passwordGen {
	    
    //the list of character that will be contained in the generated password
    public static final String ALL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/";
    
    public static final int MIN_PASSWORD_RANGE = 8;
    public static final int MAX_PASSWORD_RANGE = 12;
	
	public static void main(String[]args)
	{
		String menu = "____PASSWORD GENERATOR____\n\n"
				+ "1) Password Settings\n"
				+ "2) View the Password\n"
				+ "3) Exit\n\n";
		int option = 0;
		int range = 0;
		do
		{
			try
			{
				option = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
				if(option == 1)
				{
					range = settingPassword();
				}
				else if(option == 2)
				{
					printPassword(range,ALL_CHARS);
				}
				else if(option == 3)
				{
					JOptionPane.showMessageDialog(null, "You quit the program. Goodbye!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
				}
			}
			catch(NumberFormatException x)
			{
				JOptionPane.showMessageDialog(null, "Please Enter a valid data!");
			}
		} while(option != 3);
	}
	
	public static int settingPassword()
	{
		int rangeOfChar = 0;
		do
		{
			try
			{
				rangeOfChar = Integer.parseInt(JOptionPane.showInputDialog(null, "What range would you like your password to be?\n\n" + "Range from: " + MIN_PASSWORD_RANGE + " and " + MAX_PASSWORD_RANGE));
				if(rangeOfChar < MIN_PASSWORD_RANGE || rangeOfChar > MAX_PASSWORD_RANGE)
				{
					JOptionPane.showMessageDialog(null, "Error! Out of Range");
				}
			}
			catch(NumberFormatException x)
			{
				JOptionPane.showMessageDialog(null, "Please Enter a valid data type");
			}
		} while (rangeOfChar <= MIN_PASSWORD_RANGE && rangeOfChar >= MAX_PASSWORD_RANGE);
		return rangeOfChar;
	}
	
	public static void printPassword(int rangeOfPassword, String ALL_CHARS)
	{
		Random randomPassword = new Random();
		StringBuffer sb = new StringBuffer();
		for (int x = 0; x < rangeOfPassword; x++) 
		{
			sb.append(ALL_CHARS.charAt( randomPassword.nextInt (ALL_CHARS.length())));
		}
		JOptionPane.showMessageDialog(null,sb.toString());
	}
}
