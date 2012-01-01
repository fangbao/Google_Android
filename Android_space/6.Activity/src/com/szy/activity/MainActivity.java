package com.szy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity
{
	private final static String TAG="MainActivity";
	private Button secondBtn=null;
	private Button thirdBtn=null;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		secondBtn=(Button)findViewById(R.id.secondBtn);
		thirdBtn=(Button)findViewById(R.id.thirdBtn);
		secondBtn.setOnClickListener(listener);
		thirdBtn.setOnClickListener(listener);
		Log.i(TAG, "MainActivity-->onCreate");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "MainActivity-->onDestroy");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i(TAG, "MainActivity-->onPause");
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.i(TAG, "MainActivity-->onRestart");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.i(TAG, "MainActivity-->onResume");
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.i(TAG, "MainActivity-->onStart");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(TAG, "MainActivity-->onStop");
	}
	
	private OnClickListener listener=new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			Button btn=(Button)v;
			Intent intent=new Intent();
			switch (btn.getId())
			{
			case R.id.secondBtn:
				intent.setClass(MainActivity.this, SecondActivity.class);
				break;
			case R.id.thirdBtn:
				intent.setClass(MainActivity.this, ThirdActivity.class);
				break;
			}
			startActivity(intent);
		}
		
	};
	
}