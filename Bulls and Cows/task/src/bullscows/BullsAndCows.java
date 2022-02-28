package bullscows;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * $ Project: Bulls and Cows
 * User: rodrigotroy
 * Date: 26-02-22
 * Time: 16:30
 */
public class BullsAndCows {
    private final SecretCode secretCode;
    private boolean isGameOver = false;

    public BullsAndCows(int size,
                        int possibleSymbol) throws
                                            NumberSizeException {
        this.secretCode = new SecretCode(size,
                                         possibleSymbol);
    }

    public BullsAndCows(SecretCode secretCode) {
        this.secretCode = secretCode;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void play(String code) {
        char[] codeArray = code.toCharArray();

        int cowsCount = 0;
        int bullsCount = 0;
        char[] secretCodeArray = secretCode.getSymbols();

        for (int i = 0; i < codeArray.length; i++) {
            char currentChar = codeArray[i];

            if (currentChar == secretCodeArray[i]) {
                bullsCount++;
            } else {
                Stream<Character> secretCodeStream = new String(secretCodeArray).chars().mapToObj(value -> (char) value);

                if (secretCodeStream.anyMatch(value -> value == currentChar)) {
                    cowsCount++;
                }
            }
        }

        printResult(bullsCount,
                    cowsCount);

        if (bullsCount == secretCode.getSymbols().length) {
            this.isGameOver = true;
            System.out.println("Congratulations! You guessed the secret code.");
        }
    }

    public void printResult(int bulls,
                            int cows) {
        System.out.print("Grade: ");

        if (bulls == 0 && cows == 0) {
            System.out.print("None");
        }

        if (bulls == 1) {
            System.out.printf("%d bull",
                              bulls);
        } else if (bulls > 1) {
            System.out.printf("%d bulls",
                              bulls);
        }

        if (bulls > 0 && cows > 0) {
            System.out.print(" and ");
        }

        if (cows == 1) {
            System.out.printf("%d cow",
                              cows);
        } else if (cows > 1) {
            System.out.printf("%d cows",
                              cows);
        }

        System.out.println(".");
    }
}
