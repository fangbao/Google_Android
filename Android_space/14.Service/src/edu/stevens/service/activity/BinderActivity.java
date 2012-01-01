package edu.stevens.service.activity;

import edu.stevens.service.activity.BinderService.MyBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BinderActivity extends Activity
{
	private Button btnStartBinderService;
	private Button btnStopBinderService;
	
	private Boolean isConnected=false;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.binder);
        
        btnStartBinderService=(Button)findViewById(R.id.btnStartBinderService);
        btnStopBinderService=(Button)findViewById(R.id.btnStopBinderService);
        btnStartBinderService.setOnClickListener(listener);
        btnStopBinderService.setOnClickListener(listener);
    }
    
    private OnClickListener listener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
			switch (v.getId())
			{
			case R.id.btnStartBinderService:
				bindService();
				break;
				
			case R.id.btnStopBinderService:
				
				unbindService();
				break;
			default:
				break;
			}
			
		}
	};
	
	private void unbindService()
	{
		if(isConnected){
			unbindService(conn);
		}
		
	}

	private void bindService()
	{
		Intent intent=new Intent(BinderActivity.this,BinderService.class);
		bindService(intent, conn, BIND_AUTO_CREATE);
		
	}
	
	private ServiceConnection conn=new ServiceConnection()
	{
		
		@Override
		public void onServiceDisconnected(ComponentName name)
		{
			isConnected=false;
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder binder)
		{
			MyBinder myBinder=(MyBinder) binder;
			BinderService service=myBinder.getService();
			service.myMethod();
			isConnected=true;
		}
	};
}
