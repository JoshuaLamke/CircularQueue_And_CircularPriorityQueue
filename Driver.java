import java.util.Scanner;

/**
 * Driver for project 3.
 */
public class Driver
{
	/**
	 * Main method for project 3.
	 * @param args The command line arguements.
	 */
	public static void main(String[] args)
	{
		if(args.length < 1) {
			System.out.println("Please provide the file name");
			System.exit(0);
		}
		CovidHealthBuilder build = new CovidHealthBuilder(args[0]);
		String response;
		do
		{
			build.decide();
			System.out.print("Try again? ");
			response = getUserResponse();
		} while (response.toLowerCase().equals("yes"));
		System.out.println("Have a nice day!");
	}  // end main

	/**
	 * Gets user response.
	 * @return user response.
	 */
	public static String getUserResponse()
	{
		Scanner keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();
		return response;
	} // endgetUserResponse

	/**
	 * Checks to see if user's answer is yes.
	 * @return Boolean stating whether user said yes or not.
	 */
	public static boolean isUserResponseYes()
	{
		String answer = getUserResponse();
		if (answer.toLowerCase().equals("yes"))
			return true;
		else
			return false;
	} // end isUserResponseYes
} // end Driver

