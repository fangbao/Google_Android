package edu.stevens.service.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ExampleService extends Service
{
	public static final String TAG="ExampleService";

	@Override
	public void onCreate()
	{
		
		super.onCreate();
		Log.i(TAG,"ExampleService--->onCreate");
	}

	
	
	@Override
	public void onStart(Intent intent, int startId)
	{
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}



	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Log.i(TAG,"ExampleService--->onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG,"ExampleService--->onDestroy");
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		Log.i(TAG,"ExampleService--->onBind");
		return null;
	}

}
