package edu.stevens.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	private TextView myTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.other);

		
		Intent intent=getIntent();
		String value=intent.getStringExtra("name");
		
		
		myTextView=(TextView)findViewById(R.id.myTextView);
		myTextView.setText(value);
	}
	
	
}
