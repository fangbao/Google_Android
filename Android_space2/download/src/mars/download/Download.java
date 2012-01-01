package mars.download;

import mars.utils.HttpDownloader;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Download extends Activity {
    /** Called when the activity is first created. */
    private Button downloadTxtButton;
    private Button downloadMp3Button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        downloadTxtButton = (Button)findViewById(R.id.downloadTxt);
        downloadTxtButton.setOnClickListener(new DownloadTxtListener());
        downloadMp3Button = (Button)findViewById(R.id.downloadMp3);
        downloadMp3Button.setOnClickListener(new DownloadMp3Listener());
    }
    
    class DownloadTxtListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			HttpDownloader httpDownloader = new HttpDownloader();
			String lrc = httpDownloader.download("http://192.168.1.107:8080/voa1500/a1.lrc");
			System.out.println(lrc);
		}
    	
    }
    class DownloadMp3Listener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			HttpDownloader httpDownloader = new HttpDownloader();
			int result = httpDownloader.downFile("http://192.168.1.107:8080/voa1500/a1.mp3", "voa/", "a1.mp3");
			System.out.println(result);
		}
    	
    }
    
}