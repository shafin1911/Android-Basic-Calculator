package com.embedded.basicCalculator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class CalculatorParser 
{
	public String value;
	
	public CalculatorParser(String exp)
	{
		value = start(exp);
	}
	
    public String start(String line)
    {
        List<String> postfixString = infixToPostfix.infixToPostfixMethod(line); //CalculatorParser to infixToPostfixConvert
        Calculator calculator = Calculator.getInstance();
        calculator.setCurrent( new BigDecimal( 0 ) );
        calculate( calculator, postfixString );

        return calculator.getCurrent().toString();
    }

    public void calculate(Calculator cal, List<String> postFix) 
    {
        Stack<BigDecimal> stack = new Stack<BigDecimal>();

        for ( int i = 0; i < postFix.size(); i++ ) 
        {
            String next = postFix.get(i);
            if (next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/")) 
            {
            	cal.operation( next.charAt(0), stack.pop(), stack.pop() ); 
                stack.push(cal.getCurrent());
            } 
            else
            {
                stack.push(new BigDecimal(next.trim()));
            }
        }
    }

}