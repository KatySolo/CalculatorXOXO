package main;

import calculator.IOperable;
import calculator.ReversePolishNotation;
import lexer.Lexer;
import reader.BinaryArithmeticOperatorReader;
import reader.ComplexReader;
import reader.DoubleReader;
import reader.IntReader;
import token.Token;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer(new ComplexReader(),
                new DoubleReader(),
                new IntReader(),
                new BinaryArithmeticOperatorReader());
        Token[] tokens = lexer.tokenize("1+2*3-4");
        ArrayList<IOperable> rpn = ReversePolishNotation.transformToRPN(tokens);

        for (IOperable operable : rpn)
            System.out.println(operable);
    }
}


