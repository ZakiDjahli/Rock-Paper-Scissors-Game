import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"Rock", "Paper", "Scissors"};

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("\nEnter your move (Rock, Paper, Scissors). To quit, type 'Exit': ");
            String playerMove = scanner.nextLine().trim();

            if (playerMove.equalsIgnoreCase("Exit")) {
                break;
            }

            // validate input
            if (!playerMove.equalsIgnoreCase("Rock") &&
                    !playerMove.equalsIgnoreCase("Paper") &&
                    !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            // computer generates a move (0, 1, or 2)
            int computerIndex = random.nextInt(3);
            String computerMove = options[computerIndex];

            System.out.println("Computer chose: " + computerMove);

            // determine the winner
            if (playerMove.equalsIgnoreCase(computerMove)) {
                System.out.println("It's a tie!");
            } else if (isPlayerWin(playerMove, computerMove)) {
                System.out.println("You win! 🏆");
            } else {
                System.out.println("You lose! 🤖");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // helper method to handle the logic
    private static boolean isPlayerWin(String player, String computer) {
        return (player.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                (player.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
                (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"));
    }
}