package com.example.movmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle bn){
		
		super.onCreate(bn);
		setContentView(R.layout.activity_result);
		Intent intent=getIntent();
		
		TextView textview = (TextView)findViewById(R.id.result);
		String res = intent.getStringExtra("result");
		
		//int resInt = Integer.parseInt(res);

		textview.setText(res/*+"$".replace("$","\n")+res*/);
		
	}

}
