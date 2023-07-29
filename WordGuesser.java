package com.aurionpro.test;

import java.util.Scanner;
import java.util.Random;

public class WordGuesser {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordLength = 5;
        int life = 10;
        String randomWord = generateRandomWord(wordLength).toLowerCase();
        String blankCopyRandomWord = generateBlankCopyOfRandomWord(wordLength);
        System.out.println("Random word : "+randomWord);
        System.out.println("You have " + life + " life.");

        while (life > 0) {
        	System.out.println("Word guessed till now : " + blankCopyRandomWord);
            System.out.print("Guess a letter : ");
            char guessLetter = sc.next().toLowerCase().charAt(0);

            if (!Character.isLetter(guessLetter)) {
                System.out.println("Invalid input! Please enter a single letter.");
                continue;
            }

            String guess = String.valueOf(guessLetter);

            if (randomWord.contains(guess)) {
                for (int i = 0; i < randomWord.length(); i++) {
                    if (randomWord.charAt(i) == guessLetter) {
                        blankCopyRandomWord = blankCopyRandomWord.substring(0, i) + guess + blankCopyRandomWord.substring(i + 1);
                    }
                }
                System.out.println("Correct letter guess!");
            } else {
                life--;
                System.out.println("Incorrect guess. No. of life left: " + life);
            }

            if (blankCopyRandomWord.equals(randomWord)) {
                System.out.println("You guessed the word correctly in " + (10 - life) + " attempts!");
                break;
            }
        }

        if (life == 0) {
            System.out.println("No. of life exhausted! The word was: " + randomWord);
            System.out.println("Game Over!");
        }
        sc.close();
    }

	public static String generateRandomWord(int length) {
		String pool = "abcdefghijklmnopqrstuvwxyz"; // Characters pool
		StringBuilder word = new StringBuilder();

		Random rn = new Random();
		for (int i = 0; i < length; i++) {
			int randomIndex = rn.nextInt(pool.length());
			char randomChar = pool.charAt(randomIndex);
			word.append(randomChar);
		}
		return word.toString();
	}
	public static String generateBlankCopyOfRandomWord(int length) {
		StringBuilder word = new StringBuilder();
		for(int i=0;i<length;i++) {
			word.append("-");
		}
		return word.toString();
	}

}