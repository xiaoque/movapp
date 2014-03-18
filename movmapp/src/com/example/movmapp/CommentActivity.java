package com.example.movmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CommentActivity extends Activity{

	@Override
	protected void onCreate(Bundle bn){
		super.onCreate(bn);
		setContentView(R.layout.activity_comment);
		
		Intent intent=getIntent();
		
		
		final String titleStr = intent.getStringExtra("title");
		
		EditText et = (EditText) findViewById(R.id.comment);
		final String commentStr = et.getText().toString();
		
		Button bt1 = (Button) findViewById(R.id.submitcomment);
		
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				
				
				
				intent.setClass(CommentActivity.this, ShowCommentListActivity.class);
				
				CommentActivity.this.startActivity(intent);
			}
		});
			
		Button bt2 = (Button) findViewById(R.id.cancelcomment);
			
		bt2.setOnClickListener(new View.OnClickListener() {
				
			@Override
			public void onClick(View v) {
			
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				

				String tempStr = titleStr;
				intent.putExtra("title", tempStr);
				
				intent.setClass(CommentActivity.this, ShowMovieItemActivity.class);
					
				CommentActivity.this.startActivity(intent);
			}
		});
	

	}
}
