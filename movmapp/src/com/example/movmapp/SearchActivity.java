package com.example.movmapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SearchActivity extends Activity {

	private Button btn_qrcode, btn_showall;
	private ImageView btn_search;
	private EditText keyword;

	@Override
	protected void onCreate(Bundle bn) {
		super.onCreate(bn);
		setContentView(R.layout.activity_search);
		findViews();
		setListener();
	}

	private void setListener() {
		btn_search.setOnClickListener(searchListener);
		btn_qrcode.setOnClickListener(qrcodeListener);
		btn_showall.setOnClickListener(showallListener);
	}

	private void findViews() {
		btn_search = (ImageView) findViewById(R.id.search_key);
		btn_qrcode = (Button) findViewById(R.id.search_qrcode);
		btn_showall = (Button) findViewById(R.id.search_showall);
		keyword = (EditText) findViewById(R.id.search_keywordinput);
	}

	private OnClickListener searchListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			String tempStr = keyword.getText().toString().trim();
			intent.putExtra("result", tempStr);
			intent.setClass(SearchActivity.this, ResultActivity.class);
			SearchActivity.this.startActivity(intent);
		}
	};

	private OnClickListener qrcodeListener = new OnClickListener() {
		@Override
		public void onClick(View v) {

		}
	};
	private OnClickListener showallListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(SearchActivity.this, AllResultActivity.class);
			SearchActivity.this.startActivity(intent);
		}
	};
}
