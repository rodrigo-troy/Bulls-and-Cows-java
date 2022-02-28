package bullscows;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * $ Project: Bulls and Cows
 * User: rodrigotroy
 * Date: 26-02-22
 * Time: 16:30
 */
public class BullsAndCows {
    private final SecretNumber secretNumber;
    private boolean isGameOver = false;

    public BullsAndCows(int size) throws
                                  NumberSizeException {
        this.secretNumber = new SecretNumber(size);
    }

    public BullsAndCows(SecretNumber secretNumber) {
        this.secretNumber = secretNumber;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void play(int number) {
        String stringNumber = String.valueOf(number);

        String[] arrayNumber = stringNumber.split("");

        int cowsCount = 0;
        int bullsCount = 0;
        int[] secretDigits = secretNumber.getDigits();

        for (int i = 0; i < arrayNumber.length; i++) {
            int currentDigit = Integer.parseInt(arrayNumber[i]);

            if (currentDigit == secretDigits[i]) {
                bullsCount++;
            } else if (Arrays.stream(secretDigits).anyMatch(value -> value == currentDigit)) {
                cowsCount++;
            }
        }


        printResult(bullsCount,
                    cowsCount);

        if (bullsCount == secretNumber.getDigits().length) {
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
