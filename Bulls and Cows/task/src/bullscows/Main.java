package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");

        try {
            Scanner scanner = new Scanner(System.in);
            SecretNumber secretNumber = new SecretNumber(scanner.nextInt());
            System.out.println("Okay, let's start a game!");
            BullsAndCows game = new BullsAndCows(secretNumber);

            int turnCount = 1;
            while (true) {
                System.out.printf("Turn %d:\n",
                                  turnCount);
                game.play(scanner.nextInt());
                turnCount++;

                if (game.isGameOver()) {
                    return;
                }
            }
        } catch (NumberSizeException e) {
            System.out.println(e.getMessage());
        }

        //System.out.println(secretNumber.getNumber());

        /*
        System.out.println("The secret code is prepared: ****");
        System.out.println("The secret code is prepared: ****");

        BullsAndCows game = new BullsAndCows(secretNumber);
        game.play(scanner.nextInt());


        System.out.println("\nTurn 1. Answer:");
        System.out.println(1234);
        game.play(1234);
        System.out.println("\nTurn 2. Answer:");
        System.out.println(2418);
        game.play(2418);
        System.out.println("\nTurn 3. Answer:");
        System.out.println(secretNumber.getNumber());
        game.play(secretNumber.getNumber());
*/

    }
}
