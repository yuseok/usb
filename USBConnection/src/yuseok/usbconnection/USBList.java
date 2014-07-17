package yuseok.usbconnection;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.widget.TextView;

public class USBList extends Activity {
//	ListView mDeviceList;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.simpletextview);
		text = (TextView) findViewById(R.id.simpletextview);
		showUSBDrivers();
		
		
		
//		mDeviceList = (ListView) findViewById(R.id.deviceList);
//		mDeviceList.setAdapter(new PrivateListAdapter(this));
//		showUSBDrivers();

		super.onCreate(savedInstanceState);
	}

	void showUSBDrivers() {

		UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
		HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
		text.append(deviceList.toString());
		
		
	}

}
