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
<<<<<<< HEAD


    public String Calculate(String input) throws Exception
    {
        if (!opn.isCorrectBrackets(input))
        {
            throw new Exception("Wrong input format");
        }

        ArrayList<Token> tokens = lexer.tokenize(input);
        ArrayList<Token> output = new ArrayList<>();
        try {
            output = opn.GetExpression(tokens); //Преобразовываем выражение в постфиксную запись
            ArrayList<ICalculatable> output_wrapped = wrappingTokens(output);
            return Counting(output_wrapped).toString();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(output);
        return new Operand(new Token("double","0")).toString();

    }

    private ArrayList<ICalculatable> wrappingTokens(ArrayList<Token> input)
    {
        ArrayList<ICalculatable> result = new ArrayList<>();
        for (Token token : input)
        {
            if (Objects.equals(token.getType(), "operation")) {
                result.add(new Operator(token.getText()));
            } else
            {
                result.add(new Operand(token));
            }
        }
        return result;
    }
    private Operand Counting(ArrayList<ICalculatable> input) throws Exception //TODO think about performing operations
    {
//        Operand result = null; //Результат
//        Stack<Operand> temp = new Stack<>(); //Временный стек для решения
//
//        for (Token token : input)
//        {
//            String type = token.getType();
//            if (!type.equals("operation") && !type.endsWith("bracket")) {
//                temp.push(new Operand(token));
//            } else if (type.equals("operation")) //Если символ - оператор //TODO check the availability of operation
//            {
//                Operand a = temp.pop();
//                Operand b = temp.pop();
//
//                switch (token.getText()) //todo make methods
//                {
//                    case "+":
//                        result = add_oper.execute(a,b);
//                        break;
//                    case "-":
//                        result = sub_oper.execute(a,b);
//                        break;
//                    case "*":
//                        result = mul_oper.execute(a,b);
//                        break;
////                    case "^":
////                        result = a.Pow(b);
////                        break;
//
//                }
//                temp.push(result);//Результат вычисления записываем обратно в стек
////                }
////                else {
////                    throw new Exception("Can not perform the action");
////                }
//            }
//        }
//        return temp.peek(); //Забираем результат всех вычислений из стека и возвращаем его
        return null;
    }



}
=======
    public Calculator(Lexer lexer) {
        this.lexer = lexer;
    }
}
>>>>>>> master
