package com.embedded.basicCalculator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class history extends Activity 
{
	Button btnBack;
	TextView scrTextView;
	String FILENAME = "test.txt";
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		scrTextView = (TextView) findViewById(R.id.scrTextView);
		scrTextView.setText(getHistory());
		
		btnBack.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), FirstActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
	public String getHistory() 
	{
		FileInputStream fis = null;
		
		try 
		{
			fis = openFileInput(FILENAME);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		InputStreamReader inputStreamReader = new InputStreamReader(fis);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	
		StringBuilder sb = new StringBuilder();
		String line;
	
		try 
		{
			while ((line = bufferedReader.readLine()) != null) 
			{
				sb.append(line);
			}
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	
		try 
		{
			bufferedReader.close();
			inputStreamReader.close();
			fis.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}