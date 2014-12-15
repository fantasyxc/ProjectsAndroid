package com.example.hellocontentresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;            
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private final String EOE_URI = "content://com.eoeandroid.hellocontentprovider.provider.books/books"
			+ "";
	private ContentResolver cr;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cr = this.getContentResolver();
		
		Button mButton1 = (Button)findViewById(R.id.button1);
		mButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Cursor cursor = cr.query(Uri.parse(EOE_URI), null, null, null, null);
				while (cursor.moveToNext()) {
					String name = cursor.getString(1);
					TextView tv = (TextView)findViewById(R.id.showText);	
					tv.setText(name);
				}
				cursor.close();
			}
		});
		
		Button mButton2 = (Button)findViewById(R.id.button2);
		mButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ContentValues cv = new ContentValues();
				cv.put("bookname", "Android开发入门与实践第二版");
				int result = cr.update(Uri.parse(EOE_URI), cv, null, null);
				if (0 < result) {
					Toast.makeText(MainActivity.this, "修改成功", 3000).show();;
				}
			}
		});
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
