package com.example.movmapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class AppStartActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appstart);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
					Intent intent = null;
					intent = new Intent(AppStartActivity.this, SearchActivity.class);
					startActivity(intent);
					AppStartActivity.this.finish();
			}
		}, 1000);
	}

}

