package com.eoeandroid.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class HelloBindService extends Service{

	private final IBinder mBinder = new LocalBinder();
	private String BOOKNAME =  "Android开发入门与实践第二版";
	
	public class LocalBinder extends Binder {
		HelloBindService getService() {
			return HelloBindService.this;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "成功绑定Service", 1000).show();
		return mBinder;
	}
	
	public boolean onUnbind(Intent intent) {
		Toast.makeText(this, "成功取消绑定Service", 1000).show();
		return false;
	}

	public String getBookName() {
		return BOOKNAME;
	}
}
