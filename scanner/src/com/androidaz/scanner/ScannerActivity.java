package com.androidaz.scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;

public class ScannerActivity extends Activity {
	private Button button1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ScannerActivity.this,
						CaptureActivity.class);
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 1);
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (resultCode == RESULT_OK) {
			String capturedQrValue = intent.getStringExtra("scan_result");
			// String format =
			intent.getStringExtra("SCAN_RESULT_FORMAT");
			Toast.makeText(ScannerActivity.this,
					"Scan Result:" + capturedQrValue, Toast.LENGTH_SHORT)
					.show();
			// Handle successful scan
		} else if (resultCode == RESULT_CANCELED) {
			// Handle cancel
		}
	}

}