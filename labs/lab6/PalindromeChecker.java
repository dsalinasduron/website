/**
 * Your name[s] go here.
 */

import java.util.Scanner;

public class PalindromeChecker
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;

		do {
			System.out.println("Enter a string:");

			message = scan.nextLine();
            System.out.println("*"+message);

			/**
			 * Now determine if message is a palindrome or not
			 */
		}
		while (message.length() != 0);
		
		scan.close();
	}
}
