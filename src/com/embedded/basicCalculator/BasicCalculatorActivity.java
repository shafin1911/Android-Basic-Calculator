//Karim, Shafin Al
//14-27769-3
//Embedded Technologies[A]

package com.embedded.basicCalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BasicCalculatorActivity extends Activity {
	Button btnCalc;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_xml);
		
		btnCalc = (Button) findViewById(R.id.btnCalc);
		
		btnCalc.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), FirstActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
}