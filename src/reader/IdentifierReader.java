package reader;

import token.Token;

public class IdentifierReader implements IReader {
    public Token tryReadToken(String input){
        String regex = "[_a-zA-Z][_a-zA-Z0-9]*";
        if (input.matches(regex)){
            return new Token("id", input);
        }
        return null;
    }
}
