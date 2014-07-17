package yuseok.usbconnection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {

	Button mUSBList;
	Button mUSBConnect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.main_layout);

		mUSBList = (Button) findViewById(R.id.showUSBList);
		mUSBConnect = (Button) findViewById(R.id.connectUSB);

		mUSBList.setOnClickListener(ocl);
		mUSBConnect.setOnClickListener(ocl);

		super.onCreate(savedInstanceState);

	}

	

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.showUSBList:
				startActivity(new Intent(Main.this, USBList.class));
				break;
			case R.id.connectUSB:
				Toast.makeText(Main.this, "connect usb device",
						Toast.LENGTH_SHORT).show();
				break;

			}

		}
	};

	boolean doubleBackToExitPressedOnce = false;

	@Override
	public void onBackPressed() {

		if (doubleBackToExitPressedOnce) {
			super.onBackPressed();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "한번 더 누르면 꺼짐", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;
			}
		}, 2000);

	}

}
