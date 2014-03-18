package com.example.movmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowMovieItemActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle bn){
		
		super.onCreate(bn);
		setContentView(R.layout.activity_show_movieitem);
		TextView movieTitle = (TextView) findViewById(R.id.MovieTitle);
		
		Intent intent=getIntent();
		
		final String titleStr = intent.getStringExtra("title");
		
		movieTitle.setText(titleStr);
		
		/*
		 * 假设这里有数据库获取了信息
		 * */
		TextView movieDescription = (TextView) findViewById(R.id.MovieDescription);
		movieDescription.setText("Elsa, princess of Arendelle, possesses the magical ability to create ice and snow. One night while playing, she accidentally injures her younger sister, Anna. The king and queen seek help from trolls, who heal Anna and remove her memories of her sister's magic. The royal couple isolates the children in their castle until Elsa learns to control her powers. Afraid of hurting her sister again, Elsa spends most of her time alone in her room, causing a rift between the girls as they grow up. When the girls are teenagers, their parents die at sea during a storm.");
		
		Button bt = (Button) findViewById(R.id.toComment);
		
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				
				String tempStr = titleStr;
				
				intent.putExtra("title", tempStr);
				
				intent.setClass(ShowMovieItemActivity.this, CommentActivity.class);
				
				ShowMovieItemActivity.this.startActivity(intent);
			}
		});
		
		
	}

}
