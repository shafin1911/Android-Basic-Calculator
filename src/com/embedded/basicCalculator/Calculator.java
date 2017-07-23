package com.embedded.basicCalculator;
import java.math.BigDecimal;


public class Calculator 
{
    private static Calculator calculator;   
    private BigDecimal current = new BigDecimal( 0 );

    private Calculator()
    {

    }

    public static Calculator getInstance()
    {
        if ( calculator == null )
        {
            calculator = new Calculator();
        }
        return calculator;
    }
    
    
    public void operation( char operator, BigDecimal leftOperand, BigDecimal rightOperand )
    {       
        switch ( operator )
        {
	        case '+':
	            current = leftOperand.add( rightOperand );
	            break;
	        case '-':
	            current = rightOperand.subtract( leftOperand );
	            break;
	        case '/':
	        	try
	        	{
	        		current = rightOperand.divide(leftOperand, 2, BigDecimal.ROUND_HALF_EVEN);//Round half is used to avoid errors due to decimal length
	        	} 
	        	catch (ArithmeticException ex)
	        	{
	        		
	        	}
	            break;
	        case '*':
	            current = leftOperand.multiply( rightOperand );
	            break;
	        default:
	            break;
        }       
    }

    public BigDecimal getCurrent() 
    {
    	return current;
    }

    public void setCurrent(BigDecimal current) 
    {
        this.current = current;
    }

}