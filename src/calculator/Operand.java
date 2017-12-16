package calculator;

import complex.ComplexNumber;
import token.Token;

import java.util.HashMap;

public class Operand implements IOperable {
    private HashMap<String, Object> operand = new HashMap<>();

    public Operand(Token token) {
        if (token != null)
            this.put(token);
    }

    private void put(Token token){
        if (token.getType().startsWith("vector"))
            operand.put(token.getType(), token.getValue());
        else if (token.getType().equals("complex")){
            ComplexNumber complex = (ComplexNumber) token.getValue();
            if (complex.real() != 0.0) operand.put("real", complex.real());
            if (complex.imaginary() != 0.0) operand.put("imaginary", complex.imaginary());
        }
    }
}



