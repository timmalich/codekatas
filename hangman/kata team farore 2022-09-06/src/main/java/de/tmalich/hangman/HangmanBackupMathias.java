package de.tmalich.hangman;

public class HangmanBackupMathias {
    // private final List<Character> wordToGuess = new ArrayList<>();
    private final String wordToGuess;

    public static void main(String args[]) {
        System.out.println("FOOOOOOO" + args);
    }

    public HangmanBackupMathias(String newWordToGuess) {
        this.wordToGuess = newWordToGuess;
        /*
        for (char c : newWordToGuess.toCharArray()) {
            wordToGuess.add(new Character(c));
        }
        */
    }


    public String guess(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : wordToGuess.toCharArray()) {
            if (c == s.toCharArray()[0]) {
                sb.append(c);
            } else {
                sb.append('*');
            }
        }

        return sb.toString();
        
        /*
        for(Character c: wordToGuess){
            c.guess(s.toCharArray()[0]);
        }

        return getWordToGuess();
        */
    }

    public String getWordToGuess() {
        return wordToGuess;
        /*
        StringBuilder sb = new StringBuilder();
        for(Character c: wordToGuess){
            sb.append(c.getCurrent());
        }

        return sb.toString();
        */

    }


    private static class Character {
        private char me;
        private boolean revealed;

        public Character(char c) {
            me = c;
        }

        public void guess(char guess) {
            if (guess == me) {
                revealed = true;
            }
        }

        public char getCurrent() {
            return revealed ? me : '*';
        }
    }
    
}
