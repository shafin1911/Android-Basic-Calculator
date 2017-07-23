package com.embedded.basicCalculator;

public class Entity {
	//private variables
    String expression;
    String date;
    String result;
    
    // Empty constructor
    public Entity()
    {
 
    }
    
    // constructor
    public Entity(String expression, String date, String result)
    {
        this.expression = expression;
        this.date = date;
        this.result = result;
    }
 
    // constructor
    public Entity(String expression, String date)
    {
    	this.expression = expression;
        this.date = date;
    }
    
    // constructor
    public Entity(String result)
    {
    	this.result = result;
    }
    
    // getting expression
    public String getExpression(){
        return this.expression;
    }
 
    // setting expression
    public void setExpression(String expression){
    	this.expression = expression;
    }
 
    // getting date
    public String getDate(){
        return this.date;
    }
 
    // setting date
    public void setDate(String date){
        this.date = date;
    }
 
    // getting phone result
    public String getResult(){
        return this.result;
    }
 
    // setting phone result
    public void setResult(String result){
        this.result = result;
    }
}
