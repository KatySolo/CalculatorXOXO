package calculator.operations;

import calculator.Operand;

public interface IOperation {
    Operand execute (Operand a, Operand b);
}
