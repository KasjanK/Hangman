package hangmanv2;

import java.util.Scanner;

public class hangmanv2 {
	// random words that the player can guess
	private static String[] words = new String[] { "kopp", "mugg", "te", "kaffe", "pannkaka" };

	// generates a random number that corresponds to the index of the array
	private static String randomWord = words[(int) (Math.random() * words.length)];

	// amount of guesses
	private static int guesses = 7;

	public static void main(String[] args) {
		System.out.println("Starting game");

		Scanner scanner = new Scanner(System.in);

		System.out.println("The word has " + randomWord.length() + " letters.");

		// getting the amount of letters
		char[] letters = new char[randomWord.length()];

		// prints "_" instead of the letters of the word, that the player haven't
		// guessed
		for (int i = 0; i < letters.length; i++) {
			letters[i] = '_';
		}

		while (guesses > 0) {
			System.out.println("Guesses: " + guesses);

			boolean isGuessCorrect = false;
			
			System.out.println();
			System.out.print("Word: ");
			
			// shows the word to guess
			for (int i = 0; i < letters.length; i++) {
				System.out.print(letters[i] + " ");
			}

			// the menu
			System.out.println();
			System.out.println();
			System.out.println("Menu");
			System.out.println("Type '1' to guess a letter");
			System.out.println("Type '2' to guess the whole word");
			String guess = scanner.nextLine().toLowerCase();
			System.out.println();
			
			if ("1".equals(guess)) {
				System.out.println("Guess with 1 letter");
				guess = scanner.nextLine().toLowerCase();
				char letter = guess.charAt(0);
				for (int i = 0; i < randomWord.length(); i++) {
					char l = randomWord.charAt(i);
					if (l == letter) {
						letters[i] = l;
						isGuessCorrect = true;
					}
				}
				
				if (!isGuessCorrect) {
					guesses--;
					hangmanImage();
				}
			}
			
			if ("2".equals(guess)) {
				System.out.println("Guess the word:");
				guess = scanner.nextLine().toLowerCase();
				if (randomWord.equals(guess)) {
					System.out.println();
					System.out.println("Your guess was right! The word was: " + randomWord);
					break;
				}
				guesses = guesses - 1;
				
			}
		}
	}

	public static void hangmanImage() {
		if (guesses == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("/|");
		}
		if (guesses == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		}
		if (guesses == 4) {
			System.out.println("Wrong guess, try again");
			System.out.println(" -----------");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		}
		if (guesses == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println(" -----------");
			System.out.println(" |         |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		}
		if (guesses == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println(" -----------");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		}
		if (guesses == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println(" -----------");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |        /|");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("/|");
		}
		if (guesses == 0) {
			System.out.println("Game over!");
			System.out.println(" -----------");
			System.out.println(" |         |");
			System.out.println(" |         O");
			System.out.println(" |        /|");
			System.out.println(" |        /");
			System.out.println(" |");
			System.out.println("/|");
			System.out.println("GAME OVER! The word was " + randomWord);
		}
	}

}
