package com.eoeandroid.helloservice;

import android.app.IntentService;
import android.content.Intent;

public class HelloIntentService extends IntentService{

	public HelloIntentService() {
		super("HelloIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("��Ϣ8��");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onDestroy () {
		System.out.println("ִ����onHandleIntent֮����Զ����ã�");
		super.onDestroy();
	}
}