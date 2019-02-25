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

public class PalindromeCheckerV2
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;

		Stack<Character> stack;
		Queue<Character> queue;

		do {
			stack = new ListStack<Character>();
			queue = new ListQueue<Character>();

			System.out.println("Enter a string:");

			message = scan.nextLine();

			// fill the stack and queue with characters left to right
			for (int i = 0; i < message.length(); i++) {
				stack.push(message.charAt(i));
				queue.add(message.charAt(i));
			}

			// now pop the  stack and remove from the queue and make sure the characters match
			boolean match = true;

			while (!stack.isEmpty() && match) {
				Character left = stack.pop();
				Character right = queue.remove();

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