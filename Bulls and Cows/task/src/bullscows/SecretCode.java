package bullscows;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * $ Project: Bulls and Cows
 * User: rodrigotroy
 * Date: 26-02-22
 * Time: 16:19
 */
public class SecretCode {
    private final char[] symbols;
    private final int possibleSymbol;

    public SecretCode(int size,
                      int possibleSymbol) throws
                                          NumberSizeException {
        this.possibleSymbol = possibleSymbol;
        this.symbols = new char[size];
        this.createNumber();
    }

    private void createNumber() throws
                                NumberSizeException {
        if (symbols.length > 36) {
            throw new NumberSizeException("Error: can't generate a secret code with a length of " + symbols.length + " because there aren't enough unique digits.");
        }

        char[] baseSymbol = new char[36];
        for (int i = 48; i < 58; i++) {
            baseSymbol[i - 48] = Character.toString(i).charAt(0);
        }

        for (int i = 97; i < 123; i++) {
            baseSymbol[i - 97 + 10] = Character.toString(i).charAt(0);
        }

        System.out.println(baseSymbol);

        int numberIndex = 0;
        while (numberIndex != symbols.length) {
            int randomIndex = (int) (Math.random() * possibleSymbol);

            Stream<Character> characterStream = new String(symbols).chars().mapToObj(value -> (char) value);

            if (characterStream.noneMatch(value -> value == baseSymbol[randomIndex])) {
                symbols[numberIndex] = baseSymbol[randomIndex];
                numberIndex++;
            }
        }

        System.out.print("The secret is prepared: ");
        for (int i = 0; i < symbols.length; i++) {
            System.out.print("*");
        }

        System.out.printf(" (0-%d",
                          Math.min(possibleSymbol,
                                   9));

        if (possibleSymbol < 11) {
            System.out.println(").");
        } else {
            System.out.printf(", a-%s).\n",
                              baseSymbol[possibleSymbol - 1]);
        }
    }

    public final String getCode() {
        StringBuilder code = new StringBuilder();

        for (char c : symbols) {
            code.append(c);
        }

        return code.toString();
    }

    public char[] getSymbols() {
        return symbols;
    }

    @Override
    public String toString() {
        return this.getCode();
    }
}
