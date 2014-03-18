package com.example.movmapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ShowCommentListActivity extends Activity{

	protected void onCreate(Bundle bn){
		super.onCreate(bn);
		setContentView(R.layout.activity_show_commentlist);
		
		Intent intent = getIntent();
		
		ListView commentlist = (ListView)findViewById(R.id.commentList);
		
		//Put the data into a dynamic array
		final ArrayList<HashMap<String,Object>> ls = new ArrayList<HashMap<String,Object>>();
		for(int i = 0; i < 1; i++){
			HashMap<String, Object>map = new HashMap<String, Object>();
			map.put("ItemComment", "It's magnifique!");
			map.put("line","--------------------------------------");
			ls.add(map);
		}
		
		//Adapter
		SimpleAdapter lsAdapter = 
				new SimpleAdapter(this, ls, R.layout.comment_item, 
						new String[]{"ItemComment","line"}, new int[]{R.id.ItemComment,R.id.line});
		
		commentlist.setAdapter(lsAdapter);
		
		

	}
	
}
