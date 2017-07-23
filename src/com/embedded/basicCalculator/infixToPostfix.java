package com.embedded.basicCalculator;
import java.util.*;

public class infixToPostfix 
{
	public infixToPostfix()
	{
		
	}
	
	/** Method converts an infix expression into a postfix expression */
	public static List<String> infixToPostfixMethod(String input) 
	{
	    int priority = 0;
	    String postfixBuffer = "";
	    Stack<Character> stack = new Stack<Character>();
	    List<String> postfixArray = new ArrayList<String>();

	    for (int i = 0; i < input.length(); i++) 
	    {
	        char ch = input.charAt(i);
	        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') 
	        {
	            if (postfixBuffer.length() > 0) 
	            {
	                postfixArray.add(postfixBuffer);
	            }
	            postfixBuffer = "";
	            // check the precedence
	            if (stack.size() <= 0)
	                stack.push(ch);
	            else 
	            {
	                Character chTop = (Character) stack.peek();
	                if (chTop == '*' || chTop == '/')
	                    priority = 1;
	                else
	                    priority = 0;
	                if (priority == 1) 
	                {
	                    if (ch == '+' || ch == '-') 
	                    {
	                        postfixArray.add(String.valueOf(stack.pop()));
	                        i--;
	                    } 
	                    else 
	                    { // Same
	                        postfixArray.add(String.valueOf(stack.pop()));
	                        i--;
	                    }
	                } 
	                else 
	                {
	                    if (ch == '+' || ch == '-') 
	                    {
	                        postfixArray.add(String.valueOf(stack.pop()));
	                        stack.push(ch);
	                    } 
	                    else
	                        stack.push(ch);
	                }
	            }
	        } 
	        else 
	        {
	            postfixBuffer += ch;
	        }
	    }
	    postfixArray.add(postfixBuffer);
	    int len = stack.size();
	    for (int j = 0; j < len; j++)
	        postfixArray.add(stack.pop().toString());

	    return postfixArray; // Return the postfix expression to calculator parser
	}
}