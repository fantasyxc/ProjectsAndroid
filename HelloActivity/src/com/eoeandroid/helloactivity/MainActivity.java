package com.eoeandroid.helloactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Set layout
		setContentView(R.layout.activity_main);
		
		// Set button
		Button mButton1 = (Button)findViewById(R.id.button1);
		Button mButton2 = (Button)findViewById(R.id.button2);
		
		// Bind button1
		// get out when time passed
		mButton1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent _intent = 
						new Intent(MainActivity.this, ActivityB.class);
				startActivity(_intent);
				System.out.println("BacktoMain!");
			}
		});
		
		// Bind button2
		// get out and get result
		mButton2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent _intent = 
						new Intent(MainActivity.this, ActivityC.class);
				startActivityForResult(_intent, 100);
			}
			
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
			String val = data.getExtras().getString("getdata1");
			TextView textview = (TextView)findViewById(R.id.tvDisplay);
			textview.setText(val);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
