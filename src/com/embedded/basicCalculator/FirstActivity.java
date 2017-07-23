package com.embedded.basicCalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends Activity{
	
	public static final String PREFS_NAME = "MyPrefsFile";
	SharedPreferences myPref;
	
	double result;
	Button add, sub, mul, div, equ, dot, del, c;
	Button one, two, three, four, five, six, seven, eight, nine, zero;
	Button mr, mp, mm, mc, ms;
	Button btnHistory;
	EditText mainTextField;
	Button btnSQLHistory;
	static int Dcount = 0;
	
	public void LoadAllWidget() 
	{
		add = (Button) findViewById(R.id.btnAdd);
		sub = (Button) findViewById(R.id.btnSub);
		mul = (Button) findViewById(R.id.btnMul);
		div = (Button) findViewById(R.id.btnDiv);
		equ = (Button) findViewById(R.id.btnEqu);
		del = (Button) findViewById(R.id.btnDel);
		dot = (Button) findViewById(R.id.btnDot);
		c = (Button) findViewById(R.id.btnC);

		one = (Button) findViewById(R.id.btn1);
		two = (Button) findViewById(R.id.btn2);
		three = (Button) findViewById(R.id.btn3);
		four = (Button) findViewById(R.id.btn4);
		five = (Button) findViewById(R.id.btn5);
		six = (Button) findViewById(R.id.btn6);
		seven = (Button) findViewById(R.id.btn7);
		eight = (Button) findViewById(R.id.btn8);
		nine = (Button) findViewById(R.id.btn9);
		zero = (Button) findViewById(R.id.btn0);
		
		mr = (Button) findViewById(R.id.mr);
		mp = (Button) findViewById(R.id.mp);
		mm = (Button) findViewById(R.id.mm);
		mc = (Button) findViewById(R.id.mc);
		ms = (Button) findViewById(R.id.ms);
		
		btnHistory = (Button) findViewById(R.id.btnHistory);
		btnSQLHistory = (Button) findViewById(R.id.btnSQLHistory);
		
		mainTextField = (EditText) findViewById(R.id.mainTextField);
		mainTextField.setEnabled(false);
		mainTextField.setKeyListener(null);
	}

	public void AddButtonListener() 
	{
		add.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(ifOperatorOkay())
				{
					mainTextField.append("+");
				}
				else 
				{
					String str = "Operator not allowed here";
					Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
					msg.show();
				}
			}
		});
		
		sub.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str1 = mainTextField.getText().toString();
				
				if(ifOperatorOkay())
				{
					mainTextField.append("-");
				}
				
				else if(str1.equals(""))
				{
					mainTextField.append("-");
				}
				
				else 
				{
					String str = "Operator not allowed here";
					Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
					msg.show();
				}
			}
		});

		mul.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(ifOperatorOkay())
				{
					mainTextField.append("*");
				}
				else 
				{
					String str = "Operator not allowed here";
					Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
					msg.show();
				}

			}
		});

		div.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(ifOperatorOkay())
				{
					mainTextField.append("/");
				}
				else 
				{
					String str = "Operator not allowed here";
					Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
					msg.show();
				}

			}
		});

		del.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str = mainTextField.getText().toString();
				if (str != null && str.length() > 0) 
				{
			        str = str.substring(0, str.length() - 1);
			    }
				mainTextField.setText(str);
			}
		});

		c.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.setText("");
			}
		});

		equ.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString = mainTextField.getText().toString();
				
				if(ifOperatorOkay())
				{
			        	Intent i = new Intent(FirstActivity.this, Calculation.class).putExtra("str", myString);
			        	startActivityForResult(i, 1);
				}
				
				else 
				{
					String str = "Operator not allowed here";
					Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
					msg.show();
				}
				
			}
		});
		
		dot.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str1 = "0";
				str1 += mainTextField.getText().toString();
				String[] expArray = str1.split("(?<=[-+*/])|(?=[-+*/])");
				
				for(int i = expArray.length - 1; i < expArray.length; i++)
				{
					if(expArray[i].contains("."))
					{
						String str = ". not allowed here normal in";
						Toast msg = Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG);
						msg.show();
					}
					
					else 
					{
						mainTextField.append(".");
					}
				}
			}
		});

		one.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("1");
			}
		});

		two.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("2");

			}
		});

		three.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("3");

			}
		});

		four.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("4");

			}
		});

		five.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("5");

			}
		});

		six.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("6");

			}
		});

		seven.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("7");

			}
		});

		eight.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("8");

			}
		});

		nine.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("9");

			}
		});

		zero.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mainTextField.append("0");

			}
		});
	
		mr.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myPref = getSharedPreferences(PREFS_NAME, 0);
			    String str = myPref.getString("info", "No Info Found");
			    if(str.equals("No Info Found") || str.equals("") ) 
			    {
			    	mainTextField.setText("");
			    }
			    else
			    	mainTextField.setText(str);
			}
		});
		
		mp.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myPref = getSharedPreferences(PREFS_NAME, 0);
			    SharedPreferences.Editor editor = myPref.edit();
			    
			    String str = myPref.getString("info", "No Info Found");
			    
			    if(str.equals("No Info Found") || str.equals(""))
			    {
			    	mainTextField.setText("");
			    }
			    else
			    {
				    double a = Double.parseDouble(str);
				    a = a + 1;
				    str = Double.toString(a);
				    
				    editor.putString("info", str);
				    // Commit the edits!
				    editor.commit();
			    }
			}
		});
		
		mm.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myPref = getSharedPreferences(PREFS_NAME, 0);
			    SharedPreferences.Editor editor = myPref.edit();
			    
			    String str = myPref.getString("info", "No Info Found");
			    if(str.equals("No Info Found") || str.equals(""))
			    {
			    	mainTextField.setText("");
			    }
			    else
			    {
				    double a = Double.parseDouble(str);
				    a = a - 1;
				    str = Double.toString(a);
				    
				    editor.putString("info", str);
				    // Commit the edits!
				    editor.commit();
			    }
			}
		});
		
		mc.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myPref = getSharedPreferences(PREFS_NAME, 0);
			    SharedPreferences.Editor editor = myPref.edit();
				editor.clear(); 
				editor.commit();
			}
		});
		
		ms.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				myPref = getSharedPreferences(PREFS_NAME, 0);
			    SharedPreferences.Editor editor = myPref.edit();
			    
			    String str = mainTextField.getText().toString();
			    editor.putString("info", str);
				editor.commit();
			}
		});
		
		btnHistory.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), history.class);
				startActivity(i);
			}
		});
		
		btnSQLHistory.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), SQLhistory.class);
				startActivity(i);
			}
		});
	}
	
	public boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } 
	    
	    catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	
	public Boolean ifOperatorOkay()
	{
		String str = mainTextField.getText().toString();
		
		if(str.equals(""))
		{
			return false;
		}
		
		else if(isStringInt(str.substring(str.length() - 1)))
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LoadAllWidget();
		AddButtonListener();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	    if (requestCode == 1) {
	        if(resultCode == Activity.RESULT_OK){
	            String result = data.getStringExtra("result");
	            mainTextField.setText(result);
	        }
	        if (resultCode == Activity.RESULT_CANCELED) {
	            //Write your code if there's no result
	        }
	    }
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    // Checks the orientation of the screen
	    Bundle value = new Bundle();
	    value.putString("k1", mainTextField.getText().toString());
	    Log.d("BC config log", "in onConfigChange");
	    if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) 
	    {
	    	mainTextField.setText(value.get("k1").toString());
	    } 
	    else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
	    {
	    	mainTextField.setText(value.get("k1").toString());
	    }
	}
}
