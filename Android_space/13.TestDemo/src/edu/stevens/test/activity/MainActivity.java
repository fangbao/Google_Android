package edu.stevens.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private static final String TAG="MainActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String str=test();
        Log.i(TAG, str);
    }
    
    private String test(){
    	int i=10;
    	int j=100;
    	int k=i+j;
    	String str="Android:"+k;
    	return str;
    }
}