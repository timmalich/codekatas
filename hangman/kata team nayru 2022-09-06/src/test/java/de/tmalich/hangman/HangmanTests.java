package de.tmalich.hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanTests {

	@Test
	void constructor_with_null_throws() {
		assertThrows(NullPointerException.class, () -> new Hangman(null));
	}

	@Test
	void constructor_with_word_works() {
		assertDoesNotThrow(() -> new Hangman("wordToGuess"));
	}

	@Test
	void constructor_with_empty_string_throws() {
		assertThrows(IllegalArgumentException.class, () -> new Hangman(""));
	}

	@Test
	void getInput_works() {
		String input = "wordToGuess";
		Hangman hangman = new Hangman(input);
		assertEquals(input, hangman.getInput());
	}

	@Test
	void guess_wrong_char_works() {
		String input = "Developer";
		Hangman hangman = new Hangman(input);
		String obfuscated = hangman.guess('u');

		assertEquals("---------", obfuscated);
	}

	@Test
	void guess_correct_char_works() {
		String input = "Developer";
		Hangman hangman = new Hangman(input);
		String obfuscated = hangman.guess('e');

		assertEquals("-e-e---e-", obfuscated);
	}

	@Test
	void second_guess_correct_char_works() {
		String input = "Developer";
		Hangman hangman = new Hangman(input);
		String obfuscated = hangman.guess('e');
		assertEquals("-e-e---e-", obfuscated);
		obfuscated = hangman.guess('p');
		assertEquals("-e-e--pe-", obfuscated);
	}


	@Test
	void complete_guess_correct_char_works() {
		String input = "Developer";
		Hangman hangman = new Hangman(input);
		String obfuscated = hangman.guess('e');
		assertEquals("-e-e---e-", obfuscated);
		obfuscated = hangman.guess('p');
		assertEquals("-e-e--pe-", obfuscated);
		assertEquals("De-e--pe-", hangman.guess('D'));
		assertEquals("Deve--pe-", hangman.guess('v'));
		assertEquals("Devel-pe-", hangman.guess('l'));
		assertEquals("Develope-", hangman.guess('o'));
		assertEquals("Develope-", hangman.guess('Z'));

		assertFalse(hangman.isCompleted());
		assertEquals("Developer", hangman.guess('r'));

		assertTrue(hangman.isCompleted());
	}

	@Test
	void complete_guess_full_word_works() {
		String input = "Developer";
		Hangman hangman = new Hangman(input);

		assertFalse(hangman.guessWord("Developar"));
		assertTrue(hangman.guessWord("Developer"));
		assertTrue(hangman.guessWord("dEvelOper"));
	}

	@Test
	void guess_correct_case_insensivive_char_works() {
		String input = "Developer";
		Hangman hangman = new Hangman(input);
		String obfuscated = hangman.guess('d');

		assertEquals("D--------", obfuscated);

		obfuscated = hangman.guess('V');

		assertEquals("D-v------", obfuscated);
	}

}
