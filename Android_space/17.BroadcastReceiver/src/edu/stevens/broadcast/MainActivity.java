package edu.stevens.broadcast;

import edu.stevens.receiver.SecondReceiver;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    protected static final String ACTION = "edu.stevens.broadcast.ACTION";
	/** Called when the activity is first created. */
	private Button btn1;
	private Button registerBtn;
	private Button unRegisterBtn;
	private SecondReceiver secondReceiver;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn1=(Button)findViewById(R.id.button1);
        registerBtn=(Button)findViewById(R.id.btnRegisterRec);
        unRegisterBtn=(Button)findViewById(R.id.btnUnRegisterRec);
        
        btn1.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent intent=new Intent();
				intent.setAction(ACTION);
				sendBroadcast(intent);
				
			}
		});
        
        registerBtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				secondReceiver=new SecondReceiver();
				IntentFilter intentFilter=new IntentFilter();
				intentFilter.addAction(ACTION);
				
				registerReceiver(secondReceiver, intentFilter);
				
			}
		});
        
        unRegisterBtn.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				
				unregisterReceiver(secondReceiver);
				
			}
		});
    }
}