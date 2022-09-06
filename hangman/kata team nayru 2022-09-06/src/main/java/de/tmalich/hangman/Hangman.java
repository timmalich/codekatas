package de.tmalich.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hangman {
    public static void main(String args[]) {
        System.out.println("FOOOOOOO" + args);
    }

    private String wordToGuess;
    private List<Character> guessedChars = new ArrayList<Character>();

    public Hangman(String wordToGuess) {
        if(wordToGuess == null) {
            throw new NullPointerException("wordToGuess must not be null");
        }

        if(wordToGuess.isEmpty()) {
            throw new IllegalArgumentException("wordToGuess must not be empty");
        }
        this.wordToGuess = wordToGuess;

    }

    public String guess(char ch) {
        guessedChars.add(Character.toLowerCase(ch));
        Stream<Character> characterStream = wordToGuess.chars().mapToObj(c -> (char) c);

        return characterStream.map(this::guessChar).collect(Collectors.joining());
    }

    public boolean guessWord(String guess) {
        return wordToGuess.equalsIgnoreCase(guess);
    }

    private String guessChar(char wordChar) {
        return guessedChars.contains(Character.toLowerCase(wordChar)) ? String.valueOf(wordChar): "-";
    }

    public boolean isCompleted() {
        Stream<Character> characterStream = wordToGuess.chars().mapToObj(c -> (char) Character.toLowerCase(c));

        return guessedChars.containsAll(characterStream.collect(Collectors.toSet()));
    }

    protected String getInput() {
        return this.wordToGuess;
    }
}
