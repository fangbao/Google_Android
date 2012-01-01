package edu.stevens.listview;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewActivity extends ListActivity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
        HashMap<String,String> map1=new HashMap<String,String>();
        HashMap<String,String> map2=new HashMap<String,String>();
        HashMap<String,String> map3=new HashMap<String,String>();
        
        map1.put("user_name", "tom");
        map1.put("user_ip", "102.12.32.1");
        
        map2.put("user_name", "lee");
        map2.put("user_ip", "122.222.322.221");
        
        map3.put("user_name", "matt");
        map3.put("user_ip", "192.120.132.12");
        
        list.add(map1);
        list.add(map2);
        list.add(map3);
        
        SimpleAdapter adapter=new SimpleAdapter(this,list ,R.layout.user, 
        		new String[]{"user_name","user_ip"}, new int[]{R.id.user_name,R.id.user_ip});
        setListAdapter(adapter);
        
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		System.out.println("id:"+id);
		System.out.println("position:"+position);
	}
	
	
}