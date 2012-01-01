package edu.stevens.service.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BinderService extends Service
{
	private static final String TAG = "BinderService";
	private MyBinder binder=new MyBinder();
	
	public class MyBinder extends Binder{
		
		public BinderService getService(){
			return BinderService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return binder;
	}
	
	public void myMethod(){
		Log.i(TAG, "Mymethod");
	}

}
