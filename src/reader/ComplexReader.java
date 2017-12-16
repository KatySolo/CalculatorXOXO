package reader;

import complex.ComplexNumber;
import token.Token;

public class ComplexReader implements IReader {
    private final String i;
    private final String numb_regex = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";

    public ComplexReader(String im){
        i = im;
    }

    public ComplexReader(){
        this("i");
    }

    public Token tryReadToken(String input) {
        String newInput;
        if (input.charAt(0) == '-')
            newInput = input.substring(1);
        else
            newInput = input;

        int i_index = newInput.indexOf(i);
        if (i_index == -1)
            return null;
        String complex = newInput.substring(0, i_index);
        complex = (complex.isEmpty()) ? "1" : complex;
        if (complex.charAt(complex.length() - 1) == '+' || complex.charAt(complex.length() - 1) == '-')
            complex += 1;
        String[] values = complex.replace(" ", "").split("[+-]");
        if (values.length > 2)
            return null;
        for (String value : values)
            if (!isNumber(value))
                return null;
        if (complex.indexOf('-') != -1)
            values[1] = "-" + values[1];

        if (input.charAt(0) == '-') {
            values[0] = "-" + values[0];
            complex = "-" + complex;
        }

        if (values.length == 1)
            return new Token("complex", input.substring(0, input.indexOf(i)) + i,
                    new ComplexNumber(0, Double.parseDouble(values[0])));

        return new Token("complex", input.substring(0, input.indexOf(i)) + i,
                new ComplexNumber(Double.parseDouble(values[0]), Double.parseDouble(values[1])));
    }

    private boolean isNumber(String input){
        return input.matches(numb_regex);
    }
}
