package com.embedded.basicCalculator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class Calculation extends Activity{
	/** Called when the activity is first created. */
	String FILENAME = "test.txt";
	DatabaseHandler db = new DatabaseHandler(this);
	
	public  Calculation() 
	{
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent returnIntent = new Intent();
		String s = "0";
		s += getIntent().getStringExtra("str");
		CalculatorParser ob = new CalculatorParser(s);
		String result = ob.value;
        returnIntent.putExtra("result",result);
    	setResult(Activity.RESULT_OK,returnIntent);
    	setHistory(ob);
    	finish();
	}
	
	public void setHistory(CalculatorParser ob)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
		String currentDateandTime = sdf.format(new Date());
		
		String data = "Expression: " + getIntent().getStringExtra("str") + " = " + ob.value + " " + currentDateandTime + "\t\n";
		
		//set SQL
		db.addEntity(new Entity(getIntent().getStringExtra("str"), currentDateandTime, ob.value));
		
		//Set File
		FileOutputStream fos = null;
		try 
		{
			fos = openFileOutput(FILENAME, Context.MODE_APPEND);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			fos.write(data.getBytes());
			fos.flush();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			fos.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
