package com.example.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			if(isEmpty(mail,"please fill mail address")){
				return ;
			}
			if(isEmpty(pass,"please fill password")){
				return;
			}
			String str_mail = mail.getText().toString().trim();
			String str_pass = pass.getText().toString().trim();
			if(!isEmailValid(mail,"valide email")){
				return ;
			}

			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, ScanActivity.class);
			startActivity(intent);
		}
	};
	
	public boolean isEmailValid(EditText et,String hint) {
		String email = et.getText().toString().trim();
		String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
				+ "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
				+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
				+ "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
				+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
				+ "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);

		if (matcher.matches()){
			return true;
		}
		else{
			et.setError(hint);
			return false;
		}
	}
	
	public boolean isEmpty(EditText et, String hint){
		if(et.getText()==null ||"".equals( et.getText().toString().trim())){
			et.setError(hint);
			return true;
		}
		return false;
	}

}

