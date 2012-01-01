package edu.stevens.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver
{

	private static final String TAG ="MyReceiver";

	
	public MyReceiver()
	{
		super();
		Log.i(TAG, "MyReceiver");
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.i(TAG, "onReceiver");

	}

}
