package de.tmalich.hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanTests {

    @Test
    void newHangmanWithWordToGuess_remembersWordToGuess() throws Exception {
        String input = "word";
        Hangman hangman = new Hangman(input);
        assertEquals(input, hangman.getWordToGuess());
    }

    @Test
    void guessingCorrectCharacter_returnsCorrectResult() throws Exception {
        String input = "w";
        Hangman hangman = new Hangman(input);
        assertEquals("w", hangman.guess("w"));
    }

    @Test
    void guessingCorrectCharacter_returnsCorrectResultWithStars() throws Exception {
        String input = "wo";
        Hangman hangman = new Hangman(input);
        assertEquals("w*", hangman.guess("w"));
    }

    @Test
    void guessingCorrectCharacterMultipleTimes_returnsCorrectResultWithStars() throws Exception {
        String input = "wow";
        Hangman hangman = new Hangman(input);
        assertEquals("w*w", hangman.guess("w"));
    }

    @Test
    void guessingTwiceCorrectCharacter_returnsCorrectResultWithStars() throws Exception {
        String input = "wo";
        Hangman hangman = new Hangman(input);
        assertEquals("w*", hangman.guess("w"));
        assertEquals("wo", hangman.guess("o"));
    }

    @Test
    void guessingWithEmptyString_doesNotCrash() throws Exception {
        String input = "wo";
        Hangman hangman = new Hangman(input);
        assertEquals("**", hangman.guess(""));
    }

    @Test
    void guessingCorrectWord_ReturnsWord() throws Exception {
        String input = "word";
        Hangman hangman = new Hangman(input);
        assertEquals("word", hangman.guess("word"));
    }

    @Test
    void guessingCorrectUpperCaseCharacter_returnsCorrectResultWithStars() throws Exception {
        String input = "wo";
        Hangman hangman = new Hangman(input);
        assertEquals("w*", hangman.guess("W"));
    }

    @Test
    void guessingWrongCharacter_returnsCorrectResultWithStars() throws Exception {
        String input = "wo";
        Hangman hangman = new Hangman(input);
        assertEquals("**", hangman.guess("x"));
    }

    @Test
    void guessingCorrectLowerCaseCharacter_returnsCorrectResultWithStars() throws Exception {
        String input = "Wo";
        Hangman hangman = new Hangman(input);
        assertEquals("w*", hangman.guess("w"));
    }

    @Test
    void guessingCorrectWordUppercase_ReturnsWord() throws Exception {
        String input = "WorD";
        Hangman hangman = new Hangman(input);
        assertEquals("word", hangman.guess("wOrD"));
    }

    @Test
    void guessingTooOften_ReturnsErrorString() throws Exception {
        String input = "WorD";
        Hangman hangman = new Hangman(input, 1);
        assertEquals("w***", hangman.guess("w"));
        assertEquals("failed", hangman.guess("wo"));
    }

    @Test
    void oneCorrectGuess_isSolvedReturnsTrue() throws Exception {
        String input = "w";
        Hangman hangman = new Hangman(input);
        hangman.guess("w");
        assertTrue(hangman.isSolved());
    }
}
