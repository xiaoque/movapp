package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
	
	private EditText mail,pass;
	private Button btn_signup, btn_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_login);
		findViews();
		setListener();
	}
	
	private void setListener() {
		btn_signup.setOnClickListener(signupListener);
		btn_login.setOnClickListener(loginListener);
	}

	private void findViews() {
		btn_signup = (Button) findViewById(R.id.btn_signup);
		btn_login = (Button) findViewById(R.id.btn_login);
		mail = (EditText) findViewById(R.id.login_email);
		pass = (EditText) findViewById(R.id.login_pass);
	}
	
	private OnClickListener signupListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, SignupActivity.class);
			startActivity(intent);
		}
	};
	
	private OnClickListener loginListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String str_mail = mail.getText().toString().trim();
			String str_pass = pass.getText().toString().trim();
			Toast.makeText(LoginActivity.this, str_mail, 1000).show();
			Toast.makeText(LoginActivity.this, str_pass, 1000).show();
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, ScanActivity.class);
			startActivity(intent);
		}
	};
	
	public int testInput(String strmail, String strpass){
		return 0;
	}

}

