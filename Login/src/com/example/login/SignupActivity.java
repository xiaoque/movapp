package com.example.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends Activity{
	private EditText email, pass, passconfirm;
	private Button signup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_signup);
		findViews();
		setListener();
	}
	
	private void findViews() {
		email = (EditText) findViewById(R.id.signup_email);
		pass = (EditText) findViewById(R.id.signup_pass);
		passconfirm = (EditText) findViewById(R.id.signup_passconfirm);
	}
	private void setListener() {
		signup.setOnClickListener(signupListener);

	}
	private OnClickListener signupListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			if("".equals(email.getText().toString())|| "".equals(pass.getText().toString())||"".equals(passconfirm.getText().toString())){
				Toast toast = Toast.makeText(SignupActivity.this,
						"Please fill all fields", 1000);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
			else{
				if((pass.getText().toString().trim()).equals(passconfirm.getText().toString().trim())){
					String str_mail = email.getText().toString().trim();
					if(isEmailValid(str_mail)){
						String str_pass = pass.getText().toString().trim();
						Intent intent = new Intent();
						intent.setClass(SignupActivity.this, ScanActivity.class);
						startActivity(intent);
					}
					else{
						Toast toast = Toast.makeText(SignupActivity.this,
								"Please enter a valid email address", 1000);
						toast.setGravity(Gravity.CENTER, 0, 0);
						toast.show();
					}
				}else{
					Toast toast = Toast.makeText(SignupActivity.this,
							"Password confirm should be equal to password", 1000);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				}
			}
		}	
	};

	public boolean isEmailValid(String email) {
		String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
				+ "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
				+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
				+ "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
				+ "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
				+ "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);

		if (matcher.matches())
			return true;
		else
			return false;
	}

}
