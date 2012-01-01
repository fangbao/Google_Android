package edu.stevens.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private Button myButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        myButton=(Button)findViewById(R.id.btn1);
        myButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
//				Intent intent=new Intent();
//				intent.setClass(MainActivity.this, OtherActivity.class);
//				intent.putExtra("name", "tom");
//				startActivity(intent);
				
				Uri uri=Uri.parse("smsto://0000083");
				Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
				intent.putExtra("sms_body", "input your content");
				startActivity(intent);
			}
		});
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, R.string.exit);
		menu.add(0,2,2,R.string.about);
		
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==1){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	
    
}