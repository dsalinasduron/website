/**
 * Determines if a string is a palindrome by using two stacks.
 * The general algortihm is to add the characters in the string
 * from left to right to the first stack, and then add the 
 * characters from right to left using the second stack.
 * Next, pop from each stack and compare characters. If there
 * are two mismatching characters, the string is not a palindrome.
 * If you are able to empty both stacks and matching each character,
 * the string is a palindrome.
 */

import java.util.Scanner;

public class PalindromeCheckerV1
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;

		Stack<Character> leftRightStack;
		Stack<Character> rightLeftStack;

		do {
			leftRightStack = new ListStack<Character>();
			rightLeftStack = new ListStack<Character>();
			System.out.println("Enter a string:");

			message = scan.nextLine();

			// fill the stack with characters left to right
			for (int i = 0; i < message.length(); i++)
				leftRightStack.push(message.charAt(i));

			// fill the stack with characters from right to left
			for (int i = message.length()-1; i >= 0; i--)
				rightLeftStack.push(message.charAt(i));

			// now pop the two stacks and make sure the characters match
			boolean match = true;

			while (!rightLeftStack.isEmpty() && match) {
				Character left = leftRightStack.pop();
				Character right = rightLeftStack.pop();

				if (!left.equals(right))
					match = false;
			}
			if (match)
				System.out.println("The string " + message + " is a palindrome.");
			else
				System.out.println("The string " + message + " is not a palindrome.");
		}
		while (message.length() != 0);
		
		scan.close();
	}
}