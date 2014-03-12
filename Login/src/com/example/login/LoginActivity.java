package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity{
	
	private Button view_signup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_login);
		findViews();
		setListener();
	}

	private void findViews() {
		view_signup = (Button) findViewById(R.id.signup);
	}
	
	private OnClickListener signupListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, SignupActivity.class);
			startActivity(intent);
		}
	};
	
	private void setListener() {
		view_signup.setOnClickListener(signupListener);
	}
}

