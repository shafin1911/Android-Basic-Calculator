package com.embedded.basicCalculator;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SQLhistory extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Button btnBack;
		TextView scrTextView;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql_history);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		scrTextView = (TextView) findViewById(R.id.scrTextView);
		  
        showHistory(scrTextView);
        
        btnBack.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(), FirstActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	
	public void showHistory(TextView scrTextView) 
	{
		DatabaseHandler db = new DatabaseHandler(this);
		// Reading all Expression
        List<Entity> entity = db.getAllEntity();       
        StringBuffer stringBuffer = new StringBuffer();
        for (Entity e : entity) 
        {
            String log = "Expression: "+e.getExpression()+ " , Result: " + e.getResult() + " , Date: " + e.getDate();
            // Writing Expression to textview
            stringBuffer.append(log);
        }
        scrTextView.setText(stringBuffer.toString());
	}
}
