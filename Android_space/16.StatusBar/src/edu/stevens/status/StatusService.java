package edu.stevens.status;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;

public class StatusService extends IntentService
{
	private static final String TAG = "StatusService";

	// private static final int KUKA=0;

	public StatusService()
	{
		super("statusService");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent)
	{
		Log.i(TAG, "Start to downnload...");

		showNotification(false);

		try
		{
			Thread.sleep(10000);
			showNotification(true);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Log.i(TAG, "download is done");

	}

	private void showNotification(boolean finish)
	{
		Notification notification;
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
		NotificationManager manger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		if (!finish)
		{
			notification = new Notification(R.drawable.head, "start to download", System.currentTimeMillis());
			notification.setLatestEventInfo(this, "download", "downloading...", contentIntent);
		}else{
			notification = new Notification(R.drawable.head, "download ok", System.currentTimeMillis());			
			notification.setLatestEventInfo(this, "download", "download ok", contentIntent);
			
		}
		notification.defaults=Notification.DEFAULT_ALL;
		manger.notify(R.layout.main, notification);
		
	}

}
