package calculator;

import token.Token;
import calculator.operations.*;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotation {
    protected static ArrayList<IOperable> transformToRPN(ArrayList<Token> tokens){
        Stack<Token> stack = new Stack<>();
        ArrayList<Token> result = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++){
            Token token = tokens.get(i);
            boolean flag = false;
            if (!token.getType().equals("bao") && !token.getType().equals("bracket"))
                result.add(token);
            else if (token.getText().equals("("))
                stack.push(token);
            else if (token.getText().equals(")")){
                while (!stack.peek().getText().equals("(")){
                    result.add(stack.pop());
                }
                stack.pop();
            }
            else {
                if (stack.isEmpty())
                    stack.push(token);
                else {
                    if (getPriority(stack.peek()) >= getPriority(token)) {
                        result.add(stack.pop());
                        flag = true;
                    }
                    else
                        stack.push(token);
                }
            }
            if (flag)
                stack.push(token);
        }
        while (!stack.isEmpty())
            result.add(stack.pop());
        return transformToOperable(result);
    }
    private static ArrayList<IOperable> transformToOperable(ArrayList<Token> rpn){
        ArrayList<IOperable> result = new ArrayList<>();
        for (Token token : rpn){
            if (token.getType().equals("bao")){
                switch (token.getText()){
                    case "+":
                        result.add(new Add());
                        break;
                    case "-":
                        result.add(new Sub());
                        break;
                    case "*":
                        result.add(new Mul());
                        break;
                    case "^":
                        result.add(new Pow());
                        break;
                }
            }
            else {
                Operand operand = new Operand(token);
                result.add(operand);
            }
        }
        return result;
    }

    private static int getPriority(Token token){
        switch (token.getText()){
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            case ")":
            case "(":
                return 1;
            case "^":
                return 4;
            default:
                return 0;
        }
    }
}
