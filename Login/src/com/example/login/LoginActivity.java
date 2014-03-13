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

public class LoginActivity extends Activity {

	private EditText mail, pass;
	private Button btn_signup, btn_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_login);
		findViews();
		setListener();
	}

	private void setListener() {
		btn_signup.setOnClickListener(new ButtonListener());
		btn_login.setOnClickListener(new ButtonListener());
	}

	private void findViews() {
		btn_signup = (Button) findViewById(R.id.btn_signup);
		btn_login = (Button) findViewById(R.id.btn_login);
		mail = (EditText) findViewById(R.id.login_email);
		pass = (EditText) findViewById(R.id.login_pass);
	}

	private class ButtonListener implements OnClickListener {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_login:
				valideInput();
				break;
			case R.id.btn_signup: {
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, SignupActivity.class);
				startActivity(intent);
				break;
			}

			}
		}

	}

	public void valideInput() {
		if ("".equals(mail.getText().toString())
				|| "".equals(pass.getText().toString())) {
			Toast toast = Toast.makeText(LoginActivity.this,
					"Please fill all fields", 1000);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();

		} else {
			String str_mail = mail.getText().toString().trim();
			String str_pass = pass.getText().toString().trim();
			if (isEmailValid(str_mail)) {
				Toast.makeText(LoginActivity.this, str_mail, 1000).show();
				Toast.makeText(LoginActivity.this, str_pass, 1000).show();
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, ScanActivity.class);
				startActivity(intent);
			} else {
				Toast toast = Toast.makeText(LoginActivity.this,
						"Please enter a valid email address", 1000);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		}
	}

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
