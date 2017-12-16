package calculator;

import lexer.Lexer;
import reader.*;
import token.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Calculator {
    private Lexer lexer;

    public Calculator(){
        lexer = new Lexer();
        lexer.register(
                new BinaryArithmeticOperatorReader(),
                new ComplexReader(),
                new VectorReader(),
                new IntReader(),
                new DoubleReader(),
                new BracketsReader()
        );
    }
    public Calculator(Lexer lexer) {
        this.lexer = lexer;
    }
}
