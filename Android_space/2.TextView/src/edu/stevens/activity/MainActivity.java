package edu.stevens.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MainActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// TextView tv=new TextView(this);
		// tv.setText("hello,everyone");
		// setContentView(tv);
//		TextView tv = (TextView) findViewById(R.id.tv);
//		tv.setText(Html.fromHtml("hello,<font color='blue'>guys</font>,heyhey"));
		TextView tv = (TextView) findViewById(R.id.tv);
		
//		SpannableStringBuilder style=new SpannableStringBuilder(str);
//		style.setSpan(new ForegroundColorSpan(Color.RED), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		style.setSpan(new ForegroundColorSpan(Color.GREEN), 6, 21, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		style.setSpan(new ForegroundColorSpan(Color.BLUE), 21, 34, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		tv.setText(style);

		
	}
}