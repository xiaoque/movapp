package com.example.movmapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends Activity{
	private EditText mail, pass, passconfirm;
	private Button btn_signup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_signup);
		findViews();
		setListener();
	}
	private void setListener() {
		btn_signup.setOnClickListener(signupListener);
	}

	private void findViews() {
		mail = (EditText)findViewById(R.id.signup_mail);
		pass = (EditText)findViewById(R.id.signup_pass);
		passconfirm = (EditText)findViewById(R.id.signup_passconfirm);
		btn_signup = (Button)findViewById(R.id.signup_ok);
	}
	
	private OnClickListener signupListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if(isEmpty(mail,"please fill mail address")){
				return;
			}
			if(isEmpty(pass,"please fill password")){
				return;
			}
			if(isEmpty(passconfirm,"fill password confirm")){
				return;
			}
			if(!isEmailValid(mail,"valide email")){
				return ;
			}
			if(!isEquals(pass,passconfirm,"two same")){
				return;
			}
			Intent intent = new Intent();
			intent.setClass(SignupActivity.this, SearchActivity.class);
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
			et.requestFocus();
			et.setError(hint);
			return false;
		}
	}
	
	public boolean isEmpty(EditText et, String hint){
		if(et.getText()==null ||"".equals( et.getText().toString().trim())){
			et.requestFocus();
			et.setError(hint);
			return true;
		}
		return false;
	}
	
	public boolean isEquals(EditText et1,EditText et2, String hint){
		String temp = et2.getText().toString().trim();
		if(et1.getText().toString().trim().equals(temp)){
			return true;
		}
		else{
			et2.requestFocus();
			et2.setError(hint);
			return false;
		}
	}
}
