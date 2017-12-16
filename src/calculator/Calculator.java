package calculator;

import calculator.operations.Add;
import calculator.operations.Mul;
import calculator.operations.Sub;
import lexer.Lexer;
import readers.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Calculator {

    private Lexer lexer = new Lexer();
    private OPN opn = new OPN();
    private Add add_oper = new Add();
    private Mul mul_oper = new Mul();
    private Sub sub_oper = new Sub();

    public Calculator(){

        lexer.register(new ComplexNumberReader());
        lexer.register(new VectorReader());
        lexer.register(new OperationReader());
        lexer.register(new WhitespaceReader());
        lexer.register(new DoubleReader());
        lexer.register(new IntReader());
        lexer.register(new BracketReader());


    }


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