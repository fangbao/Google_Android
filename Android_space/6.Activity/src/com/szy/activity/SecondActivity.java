package com.szy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Log.i(TAG, "SecondActivity-->onCreate");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "SecondActivity-->onDestroy");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i(TAG, "SecondActivity-->onPause");
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.i(TAG, "SecondActivity-->onRestart");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.i(TAG, "SecondActivity-->onResume");
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.i(TAG, "SecondActivity-->onStart");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(TAG, "SecondActivity-->onStop");
	}
}