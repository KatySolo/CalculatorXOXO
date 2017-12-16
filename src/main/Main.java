package main;

import calculator.Calculator;


public class Main {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            calc.Calculate("(1+2i+2+4i)+2-4i");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


