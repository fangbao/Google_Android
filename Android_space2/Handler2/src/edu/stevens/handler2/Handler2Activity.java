package edu.stevens.handler2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;


public class Handler2Activity extends Activity {
	private Handler handler=new Handler();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        
        HandlerThread t=new HandlerThread("handler_thread");
        t.start();
        Handler myHandler=new MyHandler(t.getLooper());
        Message msg=myHandler.obtainMessage();
        Bundle data=new Bundle();
        data.putInt("age", 18);
        data.putString("name", "tom");
        msg.setData(data);
        msg.sendToTarget();
        
    }
    
    class MyHandler extends Handler{
		public MyHandler() {
			super();
		}

		public MyHandler(Looper looper) {
			super(looper);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void handleMessage(Message msg) {
			Bundle data=msg.getData();
			System.out.println("name:"+data.getString("name"));
			System.out.println("age:"+data.getInt("age"));
		}
    	
    }
}