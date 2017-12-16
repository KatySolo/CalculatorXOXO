package reader;

import token.Token;

public class BinaryArithmeticOperatorReader implements IReader {
    private char[] binaryOperators = { '+', '-', '*', '/', '%', '^', '=' };

    public Token tryReadToken(String input) {
    	if (input.isEmpty())
    		return null;
        for (char operator : binaryOperators)
            if (input.charAt(0) == operator)
                return new Token("bao", String.valueOf(operator), operator);
        return null;
    }
}
