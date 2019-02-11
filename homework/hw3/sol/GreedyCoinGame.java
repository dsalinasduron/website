/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * [ YOUR NAME GOES HERE]
 */
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;



public class GreedyCoinGame {
	// linked list for storing each coin
	private List<Integer> list = new LinkedList<Integer>();

	// scores for each player
	int computerScore = 0;
	int humanScore = 0;

	// reads in the input file and stores coins in a linked list
	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			list.add(inFile.nextInt());
		}

		inFile.close();
	}

	// prints the coins and their position
	public void printCoins() {
		System.out.println("+++++++++++");
		System.out.print("Coins:\t\t");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t ");
		}

		System.out.println();

		System.out.print("Position:\t");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + "\t ");
		}

		System.out.println("\n\nHuman: " + humanScore + " Computer: " + computerScore);
		System.out.println("+++++++++++");
	}

	public void playGame() {
		int redScore = 0;
		int blueScore = 0;

		int humanChoice = 0;
		int computerChoice = 0;

		System.out.println("Let's play the coin game!");
		printCoins();

		// get the keyboard for the silly human
		Scanner keyboard = new Scanner(System.in);

		// determine non-losing strategy
		for (int i = 0; i < list.size(); i += 2)
			redScore += list.get(i);

		for (int i = 1; i < list.size(); i += 2)
			blueScore += list.get(i);

		System.out.println("*** red score = " + redScore);
		System.out.println("*** blue score = " + blueScore);

		// now determine your strategy

		if (redScore > blueScore) {
			// play red strategy

			// first move is left-most value
			computerChoice = 0;
		}
		else {
			// play blue strategy

			// first move is right-most value
			computerChoice = list.size() - 1;
		}

		while (!list.isEmpty()) {

			System.out.println("I choose position " + computerChoice);
			computerScore += list.remove(computerChoice);

			printCoins();

			System.out.println("Indicate the position of the coin you choose: ");
			humanChoice = keyboard.nextInt();
			humanScore += list.remove(humanChoice);

			// the human choice determines what we choose next
			if (humanChoice == 0) {
				// we must choose 0 as that is the only red coin
				computerChoice = 0;
			}
			else {
				// we must choose the last element as that is the only red coin
				computerChoice = list.size() - 1;
			}

			System.out.println("Nice move!");
			printCoins();
		}

		System.out.println("Game Over! Final Score You: " + humanScore + " Me: " + computerScore);

		keyboard.close();

	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Pass a file on the command line");
			System.exit(0);
		}

		GreedyCoinGame game = new GreedyCoinGame(args[0]);

		game.playGame();
	}

}
