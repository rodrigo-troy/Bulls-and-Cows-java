package bullscows;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * $ Project: Bulls and Cows
 * User: rodrigotroy
 * Date: 26-02-22
 * Time: 16:19
 */
public class SecretNumber {
    private final int[] digits;

    public SecretNumber(int size) throws
                                  NumberSizeException {
        this.digits = new int[size];
        this.createNumber();
    }

    private void createNumber() throws
                                NumberSizeException {
        if (digits.length > 10) {
            throw new NumberSizeException("Error: can't generate a secret number with a length of " + digits.length + " because there aren't enough unique digits.");
        }

        int numberIndex = 0;
        while (numberIndex != digits.length) {
            int random = (int) (Math.random() * 10);

            if (numberIndex == 0 && random == 0) {
                continue;
            }

            if (Arrays.stream(digits).noneMatch(value -> value == random)) {
                digits[numberIndex] = random;
                numberIndex++;
            }
        }
    }

    public final String getNumber() {
        StringBuilder number = new StringBuilder();

        for (int digit : digits) {
            number.append(digit);
        }

        return number.toString();
    }

    public int[] getDigits() {
        return digits;
    }

    @Override
    public String toString() {
        return this.getNumber();
    }
}
