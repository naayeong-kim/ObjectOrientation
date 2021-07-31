package hangman;

import java.util.Scanner;

/**
 * @author Nayeong Kim (s1006313)
 */
public class Gallows {

    private StringBuilder guess;
    private String solution;

    public Gallows() {
        this.guess = new StringBuilder();
        WordReader r = new WordReader("words.txt");
        this.solution = r.getWord();
    }
    
    public Gallows(String solution) {
        this.guess = new StringBuilder();
        this.solution = solution;
    }

    public void setSolution(String word) {
        this.solution = word;
    }

    public void playHangMan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Take a guess! ");
        setDots();
        int nrOfMistakes = 0;
        int maxMistakes = 10;
        while (nrOfMistakes < maxMistakes) {
            String inputStr = scanner.next();
            char input = inputStr.charAt(0);
            if (inputInSolution(input)) {
                updateString(guess, input);
                if (noDotsLeft(guess)) {
                    System.out.println("You found the right word!");
                    return;
                }
            } else {
                nrOfMistakes++;
                System.out.println(guess);
                System.out.printf("You can make %d more mistakes \n", 10 - nrOfMistakes);
            }

        }
        System.out.println("You failed, the right answer was: ");
        System.out.print(solution + "\n");

    }

    private void updateString(StringBuilder guess, char input) {
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == input) {
                guess.replace(i, i + 1, input + "");
            }

        }
        System.out.println(guess);
    }

    private boolean inputInSolution(char input) {
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i) == input) {
                return true;
            }
        }
        return false;
    }

    private void setDots() {
        for (int i = 0; i < solution.length(); i++) {
            guess.append(".");
        }
    }

    private boolean noDotsLeft(StringBuilder guess) {
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == '.') {
                return false;
            }
        }
        return true;
    }
}