package reader;

import calculator.Calculator;
import complex.ComplexNumber;
import lexer.Lexer;
import token.Token;

import java.util.HashMap;
import java.util.Map;
import vector.Vector;


public class VectorReader implements IReader {
    private String vectorBracket = "";
    private Map<String, String> brackets;
    private ComplexReader complexReader = new ComplexReader();
    private Calculator calculator = new Calculator(new Lexer(new ComplexReader(), new DoubleReader(), new IntReader(), new BinaryArithmeticOperatorReader()));

    public VectorReader(){
        brackets = new HashMap<>();
        brackets.put("(", ")");
        brackets.put("{", "}");
        brackets.put("[", "]");
        brackets.put("<", ">");
    }

    public Token tryReadToken(String input) {
        String bracket = String.valueOf(input.charAt(0));
        if (!"({[<".contains(bracket))
            return null;
        vectorBracket = (vectorBracket.isEmpty()) ? bracket : vectorBracket;
        if (!bracket.equals(vectorBracket))
            return null;

        int end_index = input.indexOf(brackets.get(vectorBracket));
        if (end_index == -1)
            return null;

        String strVector = input.substring(1, end_index);
        String[] values = strVector.replace(" ", "").split(",");

        if (values.length < 2)
            return null;

        ComplexNumber[] c_values = new ComplexNumber[values.length];

        for (int i = 0; i < values.length; i++){
            //values[i] = calculator.calculate(values[i]); // todo: use calculator to calculate
        }

        for (int i = 0; i < values.length; i++){
            try{
                c_values[i] = new ComplexNumber(Double.parseDouble(values[i]), 0);
            }
            catch (java.lang.NumberFormatException e){
                continue;
            }
        }

        for (int i = 0; i < values.length; i++){
            if (c_values[i] != null)
                continue;
            Token newComplex =  complexReader.tryReadToken(values[i]);
            if (newComplex == null)
                return null;
            c_values[i] = (ComplexNumber) newComplex.getValue();
        }
        Vector vector = new Vector(c_values);
        return new Token("vector" + c_values.length + "D", input.substring(0, end_index + 1), vector);
    }
}
