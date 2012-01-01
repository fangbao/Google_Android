package com.szy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends Activity
{
	private static final String TAG = "MainActivity";

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		Log.i(TAG, "ThirdActivity-->onCreate");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "ThirdActivity-->onDestroy");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i(TAG, "ThirdActivity-->onPause");
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.i(TAG, "ThirdActivity-->onRestart");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.i(TAG, "ThirdActivity-->onResume");
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.i(TAG, "ThirdActivity-->onStart");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(TAG, "ThirdActivity-->onStop");
	}
}