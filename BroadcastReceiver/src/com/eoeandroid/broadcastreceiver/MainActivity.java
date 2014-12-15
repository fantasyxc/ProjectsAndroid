package com.eoeandroid.broadcastreceiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context mContext;
	private Button btnSendBroadcast;
	private TextView tvBroadcastContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		
		btnSendBroadcast = (Button)findViewById(R.id.bt_sendBroadcast);
		btnSendBroadcast.setOnClickListener(
				(OnClickListener) new SendBroadcastClickListener());
		
		tvBroadcastContent = (TextView)findViewById(R.id.et_broadcastContent);
	}
	
	private class SendBroadcastClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			String content = tvBroadcastContent.getText().toString().trim();
			if (content.length() < 1) {
				Toast.makeText(mContext, tvBroadcastContent.getHint(), 1).show();
				return;
			}
			
			Intent intent = new Intent();
			intent.setAction("com.eoeandroid.action.BroadcastReceiverTest");
			intent.putExtra("content", content);
			sendBroadcast(intent);
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
