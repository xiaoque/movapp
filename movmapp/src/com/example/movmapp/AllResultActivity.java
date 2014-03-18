package com.example.movmapp;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AllResultActivity extends Activity{
	
	

	@Override
	protected void onCreate(Bundle bn){
		
		super.onCreate(bn);
		setContentView(R.layout.activity_allresult);
		
		
		Intent intent=getIntent();
		
		ListView movieList;
		movieList = (ListView) this.findViewById(R.id.allresultlist);
		
		//Put the data into a dynamic array
		final ArrayList<HashMap<String,Object>> ls = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i < 1; i++){
			HashMap<String, Object>map = new HashMap<String, Object>();
			map.put("ItemTitle", "Frozen");
			ls.add(map);
		}

		//Adapter
		SimpleAdapter lsAdapter = 
				new SimpleAdapter(this, ls, R.layout.movie_item, 
						new String[]{"ItemTitle"}, new int[]{R.id.ItemTitle});
		
		//add and show
		movieList.setAdapter(lsAdapter);
		
		//click
		movieList.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				String tempStr = ls.get(arg2).get("ItemTitle").toString();
				
				intent.putExtra("title", tempStr);
				intent.setClass(AllResultActivity.this, ShowMovieItemActivity.class);
				
				AllResultActivity.this.startActivity(intent);
			}
		});
		
		
	}

}
