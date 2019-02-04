/**
 * Hangman
 * Nevin Zavell
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	List<String> wordList = new ArrayList<String>();

	/**
	 * Read in the list of words
	 */
	public void readWords(String fileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fileName));

		while (s.hasNext())
			wordList.add(s.next());

		s.close();
	}

	/**
	 * Selects a random word from the list
	 * and returns it.
	 */
	public String getWord() {
		// returns a random word from wordList

		Random r = new Random();

		return wordList.get(r.nextInt(wordList.size()));
	}
	
	/**
	 *  checks if character is a-z
	 * @param Char
	 * @return true/ false
	 */
	public boolean validChecker(char C){
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i<alphabet.length; i++){
			if (alphabet[i] == C)
				return true;
			
		}
		return false;
	}
	/**
	 * Plays the game. 
	 */
	public void playGame(String word) {
		char nextChoice;
        int tries = 0;
		ArrayList<Character> triedChars = new ArrayList<>();
		
		
		
		Scanner reader = new Scanner(System.in);

		//keeps win condition stable
		while (tries <= 6)
        {
			boolean win = true;

            for (int i = 0; i < word.length(); i++)
			{
				char c = (triedChars.contains(word.charAt(i))) ? word.charAt(i) : '_';
				if (c == '_') win = false;

				System.out.printf(" %c ", c);
			}

			System.out.println();

			//prints win statement
			if (win)
			{
				System.out.println("Congratulations, you won!");
				break;
			}
			//prints previously tried characters
			System.out.print("Tried chars: ");

			for (int i = 0; i < triedChars.size(); i++)
				System.out.print(triedChars.get(i));
			System.out.println();

			//inputs player choice, forces lowercase and then outputs it
			System.out.print("Your choice: ");
			nextChoice = reader.next().charAt(0);
			nextChoice = Character.toLowerCase(nextChoice);
			
			
			System.out.println("you entered " + nextChoice);
		
            //ignores previously chosen chars
			if (triedChars.contains(nextChoice)|| validChecker(nextChoice) == false)
				continue; // You tried that one, silly

			else
			//checks if statement is correct and a valid guess before incrementing the try counter
			{
				triedChars.add(nextChoice);
				if (word.indexOf(nextChoice) < 0 && validChecker(nextChoice) == true ) tries++;
			}
        }
// loss condition is met prints loss statement
		if (tries > 6)
		{
			System.out.printf("You lost :<\n The word was: %s", word);
		}
	}
//main method 
	public static void main(String[] args) {
		Hangman game = new Hangman();

		try {
			game.readWords("words.txt");
		} catch (FileNotFoundException fnf) {
			System.err.println("File Not Found");
		}

		game.playGame(game.getWord());
	}

}
