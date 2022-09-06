package de.tmalich.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hangman {
    private final char[] wordToGuess;

    private final char[] output;
    private final int numMaxTries;
    private int numTries = 0;

    public static void main(String args[]) throws IOException {
        final Hangman hangman;
        if (args != null && args.length > 0) {
            hangman = new Hangman(args[0], 10);
        } else {
            hangman = new Hangman("developer");
        }
        while (!hangman.isSolved()) {
            System.out.println("Guess: ");
            System.out.println(hangman.guess(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        }
    }

    public Hangman(String newWordToGuess, int numMaxTries) {
        this.numMaxTries = numMaxTries;

        wordToGuess = newWordToGuess.toLowerCase().toCharArray();
        output = new char[wordToGuess.length];
        for (int i = 0; i < wordToGuess.length; i++) {
            output[i] = '*';
        }
    }


    public Hangman(String newWordToGuess) {
        this(newWordToGuess, 0);
    }

    public String guess(String s) {
        numTries++;
        if (numMaxTries != 0 && numTries > numMaxTries) {
            return "failed";
        }
        if (s != null && !s.isEmpty()) {
            if (s.length() > 1) {
                return guessWord(s.toLowerCase());
            }

            transferCorrectGuess(s);
        }
        return String.valueOf(output);
    }

    private void transferCorrectGuess(String guess) {
        char c = guess.toLowerCase().charAt(0);
        for (int i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i] == c) {
                output[i] = c;
            }
        }
    }

    private String guessWord(String guess) {
        if (guess.equals(String.valueOf(wordToGuess))) {
            return String.valueOf(wordToGuess);
        } else {
            return String.valueOf(output);
        }
    }

    public String getWordToGuess() {
        return String.valueOf(wordToGuess);
    }

    public boolean isSolved() {
        return String.valueOf(wordToGuess).equalsIgnoreCase(String.valueOf(output));
    }
}
