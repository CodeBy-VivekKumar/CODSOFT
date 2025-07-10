import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int score = 0;
        int roundsPlayed = 0;
        final int MAX_ATTEMPTS = 7;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100.");

        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess (Attempts left: " + attemptsLeft + "): ");

                int guess;
                try {
                    guess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number!");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The number was: " + numberToGuess);
            }

            roundsPlayed++;

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = sc.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        // Game summary
        System.out.println("\n Game Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Total Rounds Won: " + score);
        

        sc.close();
    }
}
