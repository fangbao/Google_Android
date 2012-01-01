package edu.stevens.status;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private Button btn1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn1=(Button)findViewById(R.id.button1);
        btn1.setOnClickListener(listener);
    }
    
    
    
    
    @Override
	protected void onStart()
	{
    	super.onStart();
    	NotificationManager manger=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		manger.cancel(R.layout.main);
	}




	private OnClickListener listener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			Intent intent=new Intent(MainActivity.this, StatusService.class);
			startService(intent);
		}
	};
}