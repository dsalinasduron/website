/**
 * Solution to hangman
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	List<String> wordList = new ArrayList<String>();

	/**
	 * Read in the dictionary.
	 * 
	 * @param fileName
	 * @throws FileNotFoundException
	 */
	public void readWords(String fileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fileName));

		while (s.hasNext())
			wordList.add(s.next());

		s.close();
	}

	/**
	 * Return a word at random from the dictionary.
	 * 
	 * @return
	 */
	public String getWord() {
		// returns a random word from wordList

		Random r = new Random();

		return wordList.get(r.nextInt(wordList.size()));
	}
	
	/**
	 * Checks the String word for character ch. If it finds ch, places the
	 * character in the appropriate position in modString.
	 * 
	 * @param word
	 * @param ch
	 * @param modString
	 * @return
	 */
	public boolean checkWord(String word, char ch, StringBuilder modString) {
		boolean rv = false;
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ch) {
				modString.setCharAt(i, ch);
				rv = true;
			}
		}
		return rv;
	}
	
	/**
	 * Determines if there is a winning position in the game.
	 * 
	 * @param modString
	 * @return
	 */
	public boolean isWinningPosition(StringBuilder modString) {
		boolean rv = true;
		
		for (int i = 0; i < modString.length(); i++) {
			if (modString.charAt(i) == '_') {
					rv = false;
					break;
			}
		}
		
		return rv;
	}

	/**
	 * Plays hangman!
	 * 
	 * @param word
	 */
	public void playGame(String word) {
		int guesses = 0;
		char nextChoice;
		boolean notSolved = true;
		List<Character> lettersUsed = new ArrayList<Character>();
		
		// construct the empty StringBuilder object
		StringBuilder modString = new StringBuilder();
		for (int i = 0; i < word.length(); i++)
			modString.append('_');
		
		Scanner reader = new Scanner(System.in);

		while (guesses < 6 && notSolved) {
			System.out.println();
			for (int i = 0; i < word.length(); i++)
				System.out.print(modString.charAt(i) + " ");

			System.out.println();
			System.out.println("Incorrect guesses " + guesses);
			
			System.out.print("Your choice: ");
			nextChoice = reader.next().charAt(0);
			
			if (lettersUsed.contains(nextChoice))
				continue;
			
			lettersUsed.add(nextChoice);
			
			if (!checkWord(word, nextChoice, modString)) {
				System.out.println(nextChoice + " is not present.");
				++guesses;
				
				if (guesses == 6)
					notSolved = true;
			}
			else if (isWinningPosition(modString))
				break;

		}
		
		if (notSolved) {
			System.out.println("Sorry you lost. The word was " + word);
		}
		else
			System.out.println("Congratulations!");
		
		reader.close();

	}

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
