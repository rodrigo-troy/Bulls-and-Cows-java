package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input the length of the secret code:");
            String codeLength = scanner.next();

            if (!isNumeric(codeLength)) {
                System.out.printf("Error: \"%s\" isn't a valid number.",
                                  codeLength);
                return;
            }

            System.out.println("Input the number of possible symbols in the code:");
            String possibleSymbols = scanner.next();

            if (!isNumeric(possibleSymbols)) {
                System.out.printf("Error: \"%s\" isn't a valid number.\n",
                                  possibleSymbols);
                return;
            }

            if (Integer.parseInt(codeLength) > Integer.parseInt(possibleSymbols)) {
                System.out.printf("Error: it's not possible to generate a code with a length of %s with %s unique symbols.\n",
                                  codeLength,
                                  possibleSymbols);
                return;
            }

            if (Integer.parseInt(codeLength) < 1) {
                System.out.printf("Error: it's not possible to generate a code with a length of %s.\n",
                                  codeLength);
                return;
            }

            if (Integer.parseInt(possibleSymbols) > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return;
            }

            SecretCode secretNumber = new SecretCode(Integer.parseInt(codeLength),
                                                     Integer.parseInt(possibleSymbols));

            System.out.println(secretNumber.getCode());

            System.out.println("Okay, let's start a game!");
            BullsAndCows game = new BullsAndCows(secretNumber);

            int turnCount = 1;
            while (true) {
                System.out.printf("Turn %d:\n",
                                  turnCount);
                game.play(scanner.next());
                turnCount++;

                if (game.isGameOver()) {
                    return;
                }
            }
        } catch (NumberSizeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isNumeric(String codeLength) {
        return codeLength.chars().allMatch(Character::isDigit);
    }
}
