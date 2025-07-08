import java.util.*;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(".----------------------Game Info-----------------------------------");
        System.out.println("1 - Guess Any Number You Want In Between 1 - 100");
        System.out.println("2 - You have 3 chances to Guess ");
        System.out.println("3 - To win this Game, You have to guess the correct number in 3 tries");
        System.out.println(".------------------------------------------------------------------");

        boolean playAgain = true;

        while (playAgain) {
            Random rand = new Random();
            int Rand = rand.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;

            while (attempts < 3) {
                System.out.print("Enter your guess: ");
                int g = sc.nextInt();
                attempts++;

                if (g == Rand) {
                    System.out.println("🎉 Congratulations! You won!");
                    System.out.println("✅ You successfully found the number in " + attempts + " trial(s)!");
                    won = true;
                    break;
                } else if (g > Rand) {
                    System.out.println("📉 Too High!");
                } else {
                    System.out.println("📈 Too Low!");
                }
            }

            if (!won) {
                System.out.println("❌ Out of attempts!");
                System.out.println("💔 You lost! The correct number was: " + Rand);
                System.out.println("💡 Don't lose faith. Try again!");
            }

            System.out.print("🔁 Do you want to play again? (yes-1 / no-0): ");
            int y = sc.nextInt();
            if (y != 1) {
                playAgain = false;
                System.out.println("👋 Thanks for playing!");
            }
        }

        sc.close();
    }
}
