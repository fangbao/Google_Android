package edu.stevens.intent.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    
	private Button btn;
	private final static int REQUEST_CODE=1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn=(Button)findViewById(R.id.mainBtn);
        btn.setOnClickListener(listener);
    }
    
    private OnClickListener listener=new OnClickListener()
	{
		
		@Override
		public void onClick(View v)
		{
//			Intent intent=new Intent();
//			intent.setAction(Intent.ACTION_CALL);
//			intent.setData(Uri.parse("tel:110"));
//			startActivity(intent);
			
//			Intent intent=new Intent();
//			intent.setAction(Intent.ACTION_SENDTO);
//			intent.setData(Uri.parse("smsto:5554"));
//			intent.putExtra("sms_body", "good morning");
//			startActivity(intent);
			
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, SecondActivity.class);
			intent.putExtra("str", "intent demo");
			//startActivity(intent);
			startActivityForResult(intent, REQUEST_CODE);
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(requestCode==REQUEST_CODE)
		{
			if(resultCode==SecondActivity.RESULT_CODE)
			{
				Bundle bundle=data.getExtras();
				String str=bundle.getString("back");
				Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
			}
		}
	}
	
	
}